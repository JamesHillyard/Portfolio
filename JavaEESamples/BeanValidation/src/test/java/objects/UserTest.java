package objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<User>> violations;

    private User validUser, invalidUser;
    private static final Logger LOGGER = Logger.getLogger(UserTest.class.getName());

    @BeforeEach
    void setUp() {
        validUser = new User("James", LocalDate.of(2002, 03, 22) , "james.hillyard@payara.fish", "Password123");
        invalidUser = new User("", LocalDate.of(3000, 03, 22), "james", "No");
    }

    @Test
    public void isValidUserTest() {
        violations = validator.validate(validUser);

        if (!violations.isEmpty()) {
            violations.forEach(violation -> {
                String message = violation.getPropertyPath()
                        + ": " + violation.getMessage();
                LOGGER.severe(message);
            });
            Assertions.fail("Invalid user details");
        }
    }

    @Test
    public void checkCustomMessageIsCorrect() {
        validUser.setPassword("one");
        violations = validator.validate(validUser);
        ConstraintViolation<User> violation = violations.iterator().next();

        assertEquals("${validatedValue} is not between {min}-{max} characters.", violation.getMessageTemplate());
        assertEquals("one is not between 6-100 characters.", violation.getMessage());
        assertEquals("password", violation.getPropertyPath().toString());
        assertEquals(User.class, violation.getRootBeanClass());
    }

    @Test
    public void testExternalErrorMessage() {
        validUser.setName("");
        violations = validator.validate(validUser);
        ConstraintViolation<User> violation = violations.iterator().next();

        assertEquals("Name cannot be blank.", violation.getMessage());
        assertEquals("{user.name.invalid}", violation.getMessageTemplate());
    }
}