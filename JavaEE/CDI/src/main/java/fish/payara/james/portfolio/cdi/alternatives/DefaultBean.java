package fish.payara.james.portfolio.cdi.alternatives;

import fish.payara.james.portfolio.cdi.CustomBean;
import jakarta.enterprise.context.Dependent;

@Dependent
public class DefaultBean extends CustomBean {
    public boolean isAlternative(){
        return false;
    }
}
