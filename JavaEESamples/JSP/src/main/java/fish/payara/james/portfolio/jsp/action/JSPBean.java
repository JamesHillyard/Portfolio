package fish.payara.james.portfolio.jsp.action;

public class JSPBean {
    private String message = "No message specified";

    public String getMessage() {
        return(message);
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

