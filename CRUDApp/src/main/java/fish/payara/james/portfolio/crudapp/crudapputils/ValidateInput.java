package fish.payara.james.portfolio.crudapp.crudapputils;

import java.sql.SQLException;

public class ValidateInput {
    public static void assertNotNull(Integer id, String companyName) throws Exception {
        if(id == null || companyName.equals("")){
            throw new SQLException("Value was null");
        }
    }
}
