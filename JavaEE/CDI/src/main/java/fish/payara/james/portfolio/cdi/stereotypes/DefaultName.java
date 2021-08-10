package fish.payara.james.portfolio.cdi.stereotypes;

import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Stereotype
@Named
@Retention(RUNTIME)
public @interface DefaultName {
}
