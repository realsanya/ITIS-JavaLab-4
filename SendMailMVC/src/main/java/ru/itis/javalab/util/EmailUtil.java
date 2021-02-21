package ru.itis.javalab.util;

import org.springframework.stereotype.Component;
import ru.itis.javalab.models.Email;


@Component
public interface EmailUtil {
    void sendMail(Email email);
}

