package objects;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class User {

    @NotEmpty(message = "{user.name.invalid}")
    private String name;

    @Past
    private LocalDate birthDate;

    @NotEmpty
    @Email(message = "${validatedValue} is not a valid email. Please enter a valid email")
    private String email;

    @NotNull
    @Size(min = 6, max = 100, message = "${validatedValue} is not between {min}-{max} characters.")
    private String password;

    public User(String name, LocalDate birthDate, String email, String password) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
