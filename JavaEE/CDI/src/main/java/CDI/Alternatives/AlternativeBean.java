package CDI.Alternatives;

import CDI.CustomBean;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Alternative;

@Dependent
@Alternative
public class AlternativeBean extends CustomBean {
    public boolean isAlternative(){
        return true;
    }
}
