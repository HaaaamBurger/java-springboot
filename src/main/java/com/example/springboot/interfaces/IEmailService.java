package com.example.springboot.interfaces;

import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;

public interface IEmailService {
    void sendEmailWithAttachments(String to, String subject, String text, byte[] attachment);
}
