package az.nadir.restapi.event;

import az.nadir.restapi.model.mail.SendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log
public class EmailPublisher {
    private final JavaMailSender javaMailSender;

    @EventListener()
    public void sendEmail(SendMessage sendMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreplyanonimmessage@gmail.com");
        message.setTo("nadirmammadaliyevforwork@gmail.com");
        String text = "Name: " + sendMessage.getName() + "\n" + "Surname: " + sendMessage.getSurname() + "\n" + "\n" +
                "Mail: " +
                sendMessage.getEmail() + "\n" +
                sendMessage.getBody();
        message.setText(text);
        message.setSubject("Yeni mushteri mesaji");
        log.info("sendEmail message: " + message);
        javaMailSender.send(message);
    }
}
