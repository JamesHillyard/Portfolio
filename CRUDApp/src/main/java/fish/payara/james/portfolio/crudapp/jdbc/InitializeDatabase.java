package fish.payara.james.portfolio.crudapp.jdbc;

import fish.payara.james.portfolio.crudapp.crudapputils.PropertiesReader;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ApplicationScoped
public class InitializeDatabase {
    @Resource(name = "jdbc/mysqlPool")
    private DataSource dataSource;
    @Inject
    PropertiesReader pr;


    public void postConstruct(@Observes @Initialized(ApplicationScoped.class) Object o){
        try{
            try(Connection connection = dataSource.getConnection()){
                if(pr.getProperty("DBMS").equals("mySQL")) {
                    connection.prepareStatement("USE CRUDAppDB").execute();
                    connection.prepareStatement("CREATE OR REPLACE TABLE Company (id int PRIMARY KEY, CompanyName varchar(255));").execute();
                    connection.prepareStatement("INSERT INTO Company(`id`,`CompanyName`) VALUES (10,'Payara'), (11, 'Fish');").executeUpdate();
                }
                //Else is assuming you must be using postgreSQL. Create or replace table doesn't exist within postgresql
                else{
                    connection.prepareStatement("DROP TABLE Company").execute();
                    connection.prepareStatement("CREATE TABLE Company(id int PRIMARY KEY, CompanyName varchar(255));").execute();
                    connection.prepareStatement("INSERT INTO Company VALUES (10,'Payara'), (11, 'Fish');").executeUpdate();
                }

            }
            System.out.println("Created table and test data");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
