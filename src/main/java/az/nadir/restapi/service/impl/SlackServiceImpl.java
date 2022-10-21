package az.nadir.restapi.service.impl;

import az.nadir.restapi.model.response.RestResponse;
import az.nadir.restapi.model.slack.SlackMessage;
import az.nadir.restapi.service.SlackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log
public class SlackServiceImpl implements SlackService {

    private final RestTemplate restTemplate;

    @Value("${slack.url}")
    String url;

    @Override
    public RestResponse<Boolean> sendMessageToSlack(SlackMessage slackMessage) {
        log.info("sendMessageToSlack.start slackMessage: " + slackMessage);
        String message = slackMessage.getMessage() + " " + slackMessage.getEmoji();
        Map<String, String> messageBuilder = new HashMap<>();
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        messageBuilder.put("text", message);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(messageBuilder, httpHeaders);
        restTemplate.postForEntity(url, request, String.class);

        RestResponse<Boolean> restResponse =  new RestResponse<>();
        restResponse.setObjectWithSuccess(true);
        log.info("sendMessageToSlack.end restResponse: " + restResponse);
        return restResponse;
    }
}
