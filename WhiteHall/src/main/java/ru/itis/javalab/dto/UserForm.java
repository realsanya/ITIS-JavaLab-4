package ru.itis.javalab.dto;

import lombok.Data;
import ru.itis.javalab.validation.ValidNames;
import ru.itis.javalab.validation.ValidPassword;
import ru.itis.javalab.validation.ValidPasswords;

import javax.validation.constraints.Email;

@Data
@ValidNames(
        message = "{errors.invalid.names}",
        name = "firstName",
        surname = "lastName"
)
@ValidPasswords(
        message = "{errors.invalid.passwords}",
        password = "password",
        passwordAgain = "passwordAgain"
)
public class UserForm {
    private String firstName;
    private String lastName;
    @Email(message = "{errors.incorrect.email}")
    private String email;
    @ValidPassword(message = "{errors.incorrect.password}")
    private String password;
    private String passwordAgain;
}
