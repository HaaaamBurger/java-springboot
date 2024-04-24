package com.example.springboot.services;

import com.example.springboot.interfaces.IEmailService;
import jakarta.activation.DataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

@Component()
@RequiredArgsConstructor
public class EmailService implements IEmailService {
    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender mailSender;


    public void sendMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(subject);
        message.setText(text);
        this.mailSender.send(message);
    }

    @Override
    public void sendEmailWithAttachments(String to, String subject, String text, byte[] attachment) {
        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            DataSource attachmentDataSource = new ByteArrayDataSource(attachment, "image/png");
            mimeMessageHelper.addAttachment("car-log" ,attachmentDataSource);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


        mailSender.send(mimeMessage);

    }
    private final MimeMessage getMimeMessage() {
        return this.mailSender.createMimeMessage();
    }
}
