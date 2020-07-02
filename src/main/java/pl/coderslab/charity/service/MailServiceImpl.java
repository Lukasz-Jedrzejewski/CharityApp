package pl.coderslab.charity.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.interfaces.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {


    private final JavaMailSender javaMailSender;

    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMsg(String recipient, String topic, String content) throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(recipient);
        helper.setSubject(topic);
        helper.setText(content, true);
        javaMailSender.send(msg);
    }

    @Override
    public void sendVerificationToken(String recipient, String token) throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(recipient);
        helper.setSubject("Potwierdzenie rejestracji");
        helper.setText("W celu dokończenia rejestracji kliknij w poniższy link: "
                +"http://localhost:8080/confirm-register?token="+token);
        javaMailSender.send(msg);
    }
}
