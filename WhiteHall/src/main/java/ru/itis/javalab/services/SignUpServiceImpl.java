package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.models.Email;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.interfaces.UserRepository;
import ru.itis.javalab.services.interfaces.SignUpService;
import ru.itis.javalab.utils.EmailUtil;
import ru.itis.javalab.utils.MailsGenerator;

import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;
    private final MailsGenerator mailsGenerator;
    private final EmailUtil emailUtil;

    @Autowired
    public SignUpServiceImpl(UserRepository userRepository, EmailUtil emailUtil, MailsGenerator mailsGenerator) {
        this.userRepository = userRepository;
        this.emailUtil = emailUtil;
        this.mailsGenerator = mailsGenerator;
    }

    @Value("${server.url}")
    private String serverUrl;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void signUp(UserForm form) {
        User newUser = User.builder()
                .first_name(form.getFirstName())
                .last_name(form.getLastName())
                .email(form.getEmail())
                .password(form.getPassword())
                .confirmCode(UUID.randomUUID())
                .build();

        userRepository.save(newUser);

        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, newUser.getConfirmCode().toString());

        Email email = Email.builder()
                .from(from)
                .to(newUser.getEmail())
                .subject("Регистрация")
                .text(confirmMail)
                .build();

        emailUtil.sendMail(email);
    }
}

