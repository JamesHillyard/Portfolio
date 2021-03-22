package CDI.Types;

import CDI.CustomBean;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Typed;

@Dependent
@Typed(TypedInterface.class)
public class TypedBean extends CustomBean implements TypedInterface {

}
