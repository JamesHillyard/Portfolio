package Database;

import Database.Extras.DatabaseOrderOperations;

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
    @Path("/get")
    @Produces("application/json")
    public Order getOrder(@QueryParam("id") int id) {
        Order order = orderOperations.findOrder(id);
        return order;
    }

    @POST
    @Path("/add")
    public Response addUser(@QueryParam("id") int id, @QueryParam("product") String product, @QueryParam("quantity") int quantity) {
        orderOperations.addOrder(id, product, quantity);
        if(getOrder(id)!=null){
            return Response.status(200)
                    .entity("Order added successfully!\n Id: " + id + "\n Name: " + product + "\n Quantity: " + quantity)
                    .build();
        }
        return Response.status(406)
                .entity("Order failed.\n"+orderOperations.getOperationErrorMessage())
                .build();
    }

    @PUT
    @Path("/update")
    public Response updateUserTesting(@QueryParam("id") int id, @QueryParam("product") String product, @QueryParam("quantity") int quantity){
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

    @DELETE
    @Path("/delete")
    public Response deleteUserTesting(@QueryParam("id") int id) {
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

