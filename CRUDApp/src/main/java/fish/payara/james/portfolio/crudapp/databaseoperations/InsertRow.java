package fish.payara.james.portfolio.crudapp.databaseoperations;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RequestScoped
public class InsertRow {

    @Resource(lookup = "fish/payara/james/portfolio/crudapp/jdbc/mysqlPool")
    private DataSource dataSource;

    public void addRow(int id, String companyName) throws SQLException {

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement insert = connection.prepareStatement("INSERT INTO Company VALUES (?,?);");
            insert.setInt(1, id);
            insert.setString(2, companyName);
            insert.executeUpdate();
        }
    }
}
