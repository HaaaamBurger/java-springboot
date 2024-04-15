package com.example.springboot.service;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendMailWithHTML(String to, String subject, String description) throws MessagingException;
}
