package az.nadir.restapi.service.impl;

import az.nadir.restapi.dto.UserDto;
import az.nadir.restapi.mapper.UserMapper;
import az.nadir.restapi.model.user.User;
import az.nadir.restapi.model.response.MessageResult;
import az.nadir.restapi.model.response.RestResponse;
import az.nadir.restapi.repository.UserRepository;
import az.nadir.restapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @SneakyThrows
    public RestResponse<Boolean> saveUser(UserDto userDto){
        if (userDto == null) {
            return new RestResponse<>(MessageResult.MessageCode.BAD_REQUEST, MessageResult.Message.INVALID_ARGUMENT,
                    false);
        }
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        log.info("User:" + userDto);
        userRepository.save(user);
        RestResponse<Boolean> restResponse = new RestResponse<>();
        restResponse.setObjectWithSuccess(true);
        log.info("saveUser RestResponse: " + restResponse);
        return restResponse;
    }

    @Override
    @SneakyThrows
    public RestResponse<UserDto> getUser(Long id) {
        if (id == null) {
            return new RestResponse<>(MessageResult.MessageCode.BAD_REQUEST, MessageResult.Message.INVALID_ARGUMENT);
        }
        User user = userRepository.findAllById(id);
        if(user == null){
            return new RestResponse<>(MessageResult.MessageCode.NOT_FOUND, MessageResult.Message.NOT_FOUND);
        }
        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);
        RestResponse<UserDto> restResponse = new RestResponse<>();
        restResponse.setSuccess();
        restResponse.setResponseObject(userDto);
        log.info("getUser RestResponse: " + restResponse);
        return restResponse;
    }
}
