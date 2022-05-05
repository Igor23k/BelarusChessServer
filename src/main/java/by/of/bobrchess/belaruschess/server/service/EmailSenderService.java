package by.of.bobrchess.belaruschess.server.service;

public interface EmailSenderService {
    void send(String subject, String text, String fromEmail, String toEmail);
}
