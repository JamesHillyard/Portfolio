package POST;

import Extras.DatabaseOrderOperations;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/orders")
public class OrderResource {

    @Resource(lookup = "jdbc/mysqlPool")
    private DataSource dataSource;

    @Inject
    DatabaseOrderOperations orderOperations;

    @GET
    @Path("/get/{id}")
    public Order getOrder(@PathParam("id") int id) {
        Order order = orderOperations.findOrder(id);
        return order;
    }

    @POST
    @Path("/add")
    public Response addUser(@FormParam("id") int id, @FormParam("product") String product, @FormParam("quantity") int quantity) {
        orderOperations.addOrder(id, product, quantity);
        if(getOrder(id)!=null){
            return Response.status(200)
                    .entity("Order added successfully!<br> Id: " + id + "<br> Name: " + product + "<br> Quantity: " + quantity)
                    .build();
        }
        return Response.status(406)
                .entity("Order failed.\n"+orderOperations.getOperationErrorMessage())
                .build();
    }

    @POST
    @Path("/update")
    public Response updateUser(@FormParam("id") int id, @FormParam("product") String product, @FormParam("quantity") int quantity){
        orderOperations.updateOrder(id, product, quantity);
        if(orderOperations.getOperationUpdateCount()>0){
            return Response.status(200)
                    .entity("Order updated successfully!")
                    .build();
        }
        return Response.status(406)
                .entity("No changed made.\n"+orderOperations.getOperationErrorMessage())
                .build();
    }

    @POST
    @Path("/delete")
    public Response deleteUser(@FormParam("id") int id) {
        orderOperations.deleteOrder(id);
        if(getOrder(id)==null){
            return Response.status(200)
                    .entity("Order deleted successfully!")
                    .build();
        }
        return Response.status(406)
                .entity("Order failed to be removed.\n"+orderOperations.getOperationErrorMessage())
                .build();
    }
}

