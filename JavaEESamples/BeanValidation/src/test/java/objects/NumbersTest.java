package objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NumbersTest {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<Numbers>> violations;
    ConstraintViolation<Numbers> violation;
    private Numbers numbers, invalidNumbers;

    @BeforeAll
    void setUpTest() {
        numbers = new Numbers(11, 99,
                2,
                0.9, 1.6,
                -1, -1,
                1, 1,
                100.23);

        invalidNumbers = new Numbers(9, 101,
                7,
                1.1, 1.4,
                1, 1,
                -1, -1,
                1);

        violations = validator.validate(invalidNumbers);
    }

    @BeforeEach
    void setUpEach() {
         violation = violations.iterator().next();
    }

    @Test
    void minimum() {
        assertEquals("must be greater than or equal to 10", violation.getMessage());
    }

    @Test
    void maximum() {
        assertEquals("must be greater than or equal to 10", violation.getMessage());
    }
}