package com.example.springboot.serviceeiml;

import com.example.springboot.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component("EmailService")
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender mailSender;

    private final ITemplateEngine templateEngine;

    public void sendMailWithHTML(String to, String subject, String description) throws MessagingException {
        Context context = new Context();
        context.setVariable("gmail", from);

        String text = templateEngine.process("/car-creation-email.html", context);
        MimeMessage message = getMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setPriority(1);
        helper.setSubject(subject);
        helper.setTo("irynasksl@gmail.com");
        helper.setText(text);
        helper.setFrom(from);

        mailSender.send(message);
    }

    private final MimeMessage getMimeMessage() {
        return this.mailSender.createMimeMessage();
    }
}
