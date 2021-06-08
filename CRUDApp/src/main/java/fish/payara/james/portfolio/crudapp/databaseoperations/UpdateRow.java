package fish.payara.james.portfolio.crudapp.databaseoperations;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@ApplicationScoped
public class UpdateRow {

    @Resource(lookup = "fish/payara/james/portfolio/crudapp/jdbc/mysqlPool")
    private DataSource dataSource;

    public void updateRow(int id, String companyName) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(true);
            PreparedStatement update = connection.prepareStatement("UPDATE Company SET CompanyName = ? WHERE id = ?;");
            update.setString(1, companyName);
            update.setInt(2, id);
            update.executeUpdate();
        }
    }
}
