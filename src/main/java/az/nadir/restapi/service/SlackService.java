package az.nadir.restapi.service;

import az.nadir.restapi.model.response.RestResponse;
import az.nadir.restapi.model.slack.SlackMessage;

public interface SlackService {
    RestResponse<Boolean> sendMessageToSlack(SlackMessage slackMessage);
}
