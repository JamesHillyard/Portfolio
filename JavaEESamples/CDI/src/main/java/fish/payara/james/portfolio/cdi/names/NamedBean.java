package fish.payara.james.portfolio.cdi.names;

import fish.payara.james.portfolio.cdi.CustomBean;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("NamedBean")
public class NamedBean extends CustomBean {
}
