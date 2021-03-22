package CDI.Scopes;

import CDI.CustomBean;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@SessionScoped
public class SessionScopedBean extends CustomBean implements Serializable {
}
