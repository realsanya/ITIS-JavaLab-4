package ru.itis.javalab.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import ru.itis.javalab.models.Email;

import java.util.concurrent.ExecutorService;

@Component
public class EmailUtilImpl implements EmailUtil {

    private final JavaMailSender javaMailSender;

    private final ExecutorService executorService;

    @Autowired
    public EmailUtilImpl(JavaMailSender javaMailSender, ExecutorService executorService) {
        this.javaMailSender = javaMailSender;
        this.executorService = executorService;
    }

    @Override
    public void sendMail(Email email) {
        executorService.submit(() -> javaMailSender.send(mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(email.getFrom());
            messageHelper.setTo(email.getTo());
            messageHelper.setSubject(email.getSubject());
            messageHelper.setText(email.getText(), true);
        }));
    }
}

