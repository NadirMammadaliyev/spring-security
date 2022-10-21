package az.nadir.restapi.service.impl;

import az.nadir.restapi.dto.UserDto;
import az.nadir.restapi.event.EmailPublisher;
import az.nadir.restapi.model.mail.SendMessage;
import az.nadir.restapi.model.response.MessageResult;
import az.nadir.restapi.model.response.RestResponse;
import az.nadir.restapi.service.MailSenderService;
import az.nadir.restapi.service.UserService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log
public class MailSenderServiceImpl implements MailSenderService {
    private final EmailPublisher emailPublisher;
    private final UserService userService;

    @Override
    @SneakyThrows
    public RestResponse<Boolean> sendMessage(SendMessage sendMessage) {
        log.info("sendMessage:" + sendMessage);
        LocalDateTime nowDate = LocalDateTime.now();
        emailPublisher.sendEmail(sendMessage);

        UserDto userDto = new UserDto();
        userDto.setMail(sendMessage.getEmail());
        userDto.setMessage("Body: " + sendMessage.getBody());
        userDto.setCount(sendMessage.getCount());
        userDto.setName(sendMessage.getName());
        userDto.setSurname(sendMessage.getSurname());


        RestResponse<Boolean> save = userService.saveUser(userDto);
        if (!save.getResponseObject()) {
            return new RestResponse<>(MessageResult.MessageCode.ERROR, MessageResult.Message.ERROR, false);
        }
        RestResponse<Boolean> restResponse = new RestResponse<>();
        restResponse.setObjectWithSuccess(true);
        return restResponse;
    }
}
