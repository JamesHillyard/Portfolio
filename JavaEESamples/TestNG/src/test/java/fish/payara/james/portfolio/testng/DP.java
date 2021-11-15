package fish.payara.james.portfolio.testng;

import org.testng.annotations.DataProvider;

public class DP {

    @DataProvider (name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][] {{"First-Value"}};
    }
}
