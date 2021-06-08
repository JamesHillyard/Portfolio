package fish.payara.james.portfolio.crudapp.databaseoperations;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RequestScoped
public class DeleteRow {
    @Resource(lookup = "fish/payara/james/portfolio/crudapp/jdbc/mysqlPool")
    private DataSource dataSource;

    public void removeRow(int id) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement insert = connection.prepareStatement("DELETE FROM Company WHERE id = ?;");
            insert.setInt(1, id);
            insert.executeUpdate();
        }
    }
}
