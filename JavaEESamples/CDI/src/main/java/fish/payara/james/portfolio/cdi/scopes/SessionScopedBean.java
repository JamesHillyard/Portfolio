package fish.payara.james.portfolio.cdi.scopes;

import fish.payara.james.portfolio.cdi.CustomBean;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@SessionScoped
public class SessionScopedBean extends CustomBean implements Serializable {
}
