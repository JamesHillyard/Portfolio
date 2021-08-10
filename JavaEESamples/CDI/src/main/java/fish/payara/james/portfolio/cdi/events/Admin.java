package fish.payara.james.portfolio.cdi.events;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Target({ TYPE, FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface Admin {
    public final static class Literal extends AnnotationLiteral<Admin> implements Admin {

        public static final Literal INSTANCE = new Literal();

        private static final long serialVersionUID = 1L;

    }
}
