package CDI.Alternatives;

import CDI.CustomBean;
import jakarta.enterprise.context.Dependent;

@Dependent
public class DefaultBean extends CustomBean {
    public boolean isAlternative(){
        return false;
    }
}
