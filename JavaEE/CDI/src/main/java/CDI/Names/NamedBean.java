package CDI.Names;

import CDI.CustomBean;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("NamedBean")
public class NamedBean extends CustomBean {
}
