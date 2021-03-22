package CDI.Injection;

import jakarta.inject.Qualifier;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Qualifier
@Max(10)
@Min(5)
public @interface Limiter {
}
