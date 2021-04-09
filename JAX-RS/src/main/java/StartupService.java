import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ApplicationScoped
public class StartupService {

    @Resource(lookup = "jdbc/mysqlPool")
    private DataSource dataSource;

    public void postConstruct(@Observes @Initialized(ApplicationScoped.class) Object o) {
        try {
            try (Connection connection = dataSource.getConnection()) {
                connection.prepareStatement("USE JAXRS").execute();
                connection.prepareStatement("CREATE TABLE IF NOT EXISTS Orders (id int PRIMARY KEY, product VARCHAR(255), quantity int);").execute();
            }
            System.out.println("Created table and test data");
        } catch (SQLException e) {

        }
    }
}
