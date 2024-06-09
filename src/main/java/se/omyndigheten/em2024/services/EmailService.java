package se.omyndigheten.em2024.services;

import java.io.IOException;
import java.util.Map;

import jakarta.mail.MessagingException;

/**
 * Created by Krille on 09/06/2024 17:41
 */
public interface EmailService {

    public void sendSimpleMessage(String to,
                               String subject,
                               String text);
    public void sendHtmlEmail(String to, String subject, String htmlBody) throws MessagingException;
    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException;
}
