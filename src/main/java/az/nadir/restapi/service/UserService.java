package az.nadir.restapi.service;

import az.nadir.restapi.dto.UserDto;
import az.nadir.restapi.model.response.RestResponse;

public interface UserService {
    RestResponse<Boolean> saveUser(UserDto userDto);

    RestResponse<UserDto> getUser(Long id);

}
