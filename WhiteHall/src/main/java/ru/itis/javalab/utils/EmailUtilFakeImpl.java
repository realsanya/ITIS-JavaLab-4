package ru.itis.javalab.utils;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.itis.javalab.models.Email;

@Component
@Profile("dev")
public class EmailUtilFakeImpl implements EmailUtil {

    @Override
    public void sendMail(Email email) {
        System.out.println(email.getText());
    }
}
