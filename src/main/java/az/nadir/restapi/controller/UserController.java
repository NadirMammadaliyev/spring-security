package az.nadir.restapi.controller;

import az.nadir.restapi.dto.UserDto;
import az.nadir.restapi.model.response.RestResponse;
import az.nadir.restapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public RestResponse<Boolean> saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @GetMapping("/get-by-id")
    public RestResponse<UserDto> getUser(@RequestParam Long id){
        return userService.getUser(id);
    }
}
