package pl.coderslab.charity.service;

import javax.mail.MessagingException;

public interface MailService {

    void sendMsg(String recipient, String topic, String content) throws MessagingException;
    void sendVerificationToken(String recipient, String token) throws MessagingException;
    void sendPasswordResetToken(String recipient, String token) throws MessagingException;
}
