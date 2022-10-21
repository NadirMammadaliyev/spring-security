package az.nadir.restapi.controller;

import az.nadir.restapi.model.response.RestResponse;
import az.nadir.restapi.model.slack.SlackMessage;
import az.nadir.restapi.service.impl.SlackServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("slack")
@RequiredArgsConstructor
public class SlackController {
    private final SlackServiceImpl slackService;

    @PostMapping("/send")
    public RestResponse<Boolean> sendSlackMessage(@RequestBody SlackMessage slackMessage){
        return slackService.sendMessageToSlack(slackMessage);
    }
}
