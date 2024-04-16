package com.example.springboot.interfaces;

import jakarta.mail.MessagingException;

public interface IEmailService {
    void sendMailWithHTML(String to, String subject, String description) throws MessagingException;
}
