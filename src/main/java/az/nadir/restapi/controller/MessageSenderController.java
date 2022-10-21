package az.nadir.restapi.controller;

import az.nadir.restapi.model.mail.SendMessage;
import az.nadir.restapi.model.response.RestResponse;
import az.nadir.restapi.service.MailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
@AllArgsConstructor
public class MessageSenderController {
    private MailSenderService mailSenderService;

    @PostMapping("/send")
    public RestResponse<Boolean> sendMessage(@RequestBody SendMessage sendMessage) {
        return mailSenderService.sendMessage(sendMessage);
    }
}
