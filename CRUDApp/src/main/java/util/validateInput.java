package util;

import java.sql.SQLException;

public class validateInput {
    public static void assertNotNull(Integer id, String companyName) throws Exception {
        if(id == null || companyName.equals("")){
            throw new SQLException("Value was null");
        }
    }
}
