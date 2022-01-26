package james.websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/chat/{username}", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ChatEndpoint {

    private Session session;
    private static final Set<ChatEndpoint> chatEndpoints = new CopyOnWriteArraySet<>();
    private static final HashMap<String, String> users = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {

        this.session = session;
        chatEndpoints.add(this);
        users.put(session.getId(), username);

        Message message = new Message();
        message.setFrom(username);
        message.setContent("Connected!");
        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session, Message message) {
        message.setFrom(users.get(session.getId()));

        if(message.getContent().startsWith("dm")) {
            String targetUsername = message.getContent().split(" ", 3)[1];
            message.setTo(targetUsername);
            directMessage(message);
            return;
        }

        broadcast(message);
    }

    @OnClose
    public void onClose(Session session) {

        chatEndpoints.remove(this);
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent("Disconnected!");
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) throws EncodeException, IOException {
        for (ChatEndpoint endpoint : chatEndpoints) {
            if(endpoint.session.getId().equals(session.getId())) {
                endpoint.session.getBasicRemote().sendObject("Error: "+throwable.getMessage());
            }
        }
    }

    private static void broadcast(Message message) {
        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote().sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void directMessage(Message message) {
        String targetUser = message.getTo();
        String sender = message.getFrom();
        for (ChatEndpoint chatEndpoint : chatEndpoints) {
            if (users.get(chatEndpoint.session.getId()).equals(targetUser) ||
                    users.get(chatEndpoint.session.getId()).equals(sender)) {
                try {
                    chatEndpoint.session.getBasicRemote().sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
