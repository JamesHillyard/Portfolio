package fish.payara.james.portfolio.cdi.types;

import fish.payara.james.portfolio.cdi.CustomBean;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Typed;

@Dependent
@Typed(TypedInterface.class)
public class TypedBean extends CustomBean implements TypedInterface {

}
