package az.nadir.restapi.service;

import az.nadir.restapi.model.AppUser;
import az.nadir.restapi.model.Role;
import az.nadir.restapi.model.response.RestResponse;

import java.util.List;

public interface AppUserService {
    AppUser saveAppUser(AppUser appUser);

    RestResponse<Boolean> saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getAppUser(String username);

    List<AppUser> getAppUsers();
}
