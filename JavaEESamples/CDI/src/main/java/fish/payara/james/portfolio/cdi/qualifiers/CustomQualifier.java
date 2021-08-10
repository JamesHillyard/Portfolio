package fish.payara.james.portfolio.cdi.qualifiers;

import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Target({TYPE, FIELD})
@Retention(RUNTIME)
public @interface CustomQualifier {
}
