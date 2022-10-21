package az.nadir.restapi.service;

import az.nadir.restapi.model.mail.SendMessage;
import az.nadir.restapi.model.response.RestResponse;

public interface MailSenderService {
    RestResponse<Boolean> sendMessage(SendMessage sendMessage);
}
