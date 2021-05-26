package Database.Extras;

import Database.Order;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public class DatabaseOrderOperations {
    @Resource(lookup = "jdbc/mysqlPool")
    private DataSource dataSource;

    private String operationErrorMessage;
    private int operationUpdateCount;

    public Order findOrder(int id) {
        Order result = null;
        try(Connection connection = dataSource.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement("SELECT id, product, quantity FROM Orders WHERE id = ?")){
                statement.setInt(1, id);
                try(ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next()){
                        result = new Order(resultSet.getInt("id"),
                                resultSet.getString("product"),
                                resultSet.getInt("quantity"));
                    }
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            operationErrorMessage = ex.getMessage();
        }
        return result;
    }

    public void addOrder(int id, String product, int quantity){
        try(Connection connection = dataSource.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders VALUES(?,?,?);")){
                statement.setInt(1, id);
                statement.setString(2, product);
                statement.setInt(3, quantity);
                statement.execute();
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            operationErrorMessage = ex.getMessage();
        }
    }

    public void updateOrder(int id, String product, int quantity){
        try(Connection connection = dataSource.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement("UPDATE Orders SET product=?, quantity=? WHERE id = ?;")){
                statement.setString(1, product);
                statement.setInt(2, quantity);
                statement.setInt(3, id);
                statement.execute();
                operationUpdateCount=statement.getUpdateCount();
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            operationErrorMessage = ex.getMessage();
        }
    }

    public void deleteOrder(int id){
        try(Connection connection = dataSource.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders WHERE id = ?;")){
                statement.setInt(1, id);
                statement.execute();
                operationUpdateCount=statement.getUpdateCount();
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            operationErrorMessage = ex.getMessage();
        }
    }

    public String getOperationErrorMessage(){
        return operationErrorMessage;
    }

    public int getOperationUpdateCount(){
        return operationUpdateCount;
    }
}
