package fish.payara.james.portfolio.crudapp.jdbc;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public class CompanyService {
    @Resource(lookup = "jdbc/mysqlPool")
    private DataSource dataSource;

    public Company findCompany(int id) throws SQLException {
        Company result = null;
        try(Connection connection = dataSource.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement("SELECT id, CompanyName FROM Company WHERE id = ?")){
                statement.setInt(1, id);
                try(ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next()){
                        result = new Company(resultSet.getInt("id"), resultSet.getString("CompanyName"));
                    }
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }
}
