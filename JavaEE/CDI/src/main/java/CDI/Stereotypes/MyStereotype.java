package CDI.Stereotypes;

import jakarta.ejb.Asynchronous;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Stereotype;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@RequestScoped
@Asynchronous
@Stereotype
@Target(TYPE)
@Retention(RUNTIME)
public @interface MyStereotype {
}
