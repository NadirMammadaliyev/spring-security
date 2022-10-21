package az.nadir.restapi.service.impl;

import az.nadir.restapi.model.AppUser;
import az.nadir.restapi.model.Role;
import az.nadir.restapi.model.response.MessageResult;
import az.nadir.restapi.model.response.RestResponse;
import az.nadir.restapi.repository.AppUserRepository;
import az.nadir.restapi.repository.RoleRepository;
import az.nadir.restapi.service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;


@RequiredArgsConstructor
@Transactional
@Slf4j
@Service
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @SneakyThrows
    public AppUser saveAppUser(AppUser appUser) {
        log.info("saveAppUser appUser: {}", appUser);
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    @SneakyThrows
    public RestResponse<Boolean> saveRole(Role role) {
        log.info("saveRole role: {}", role);
        Role savedRole = roleRepository.save(role);
        log.info("saveRole savedRole: {}", savedRole);
        if(isEmpty(role)){
            return new RestResponse<>(MessageResult.MessageCode.ERROR, MessageResult.Message.ERROR);
        }
        RestResponse<Boolean> response = new RestResponse<>();
        response.setObjectWithSuccess(true);
        return response;
    }

    @Override
    @SneakyThrows
    public void addRoleToUser(String username, String roleName) {
        log.info("addRoleToUser username: {} roleName: {}", username, roleName);
        AppUser appUser = appUserRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    @SneakyThrows
    public AppUser getAppUser(String username) {
        log.info("getAppUser username: {}", username);
        return appUserRepository.findByUsername(username);
    }

    @Override
    @SneakyThrows
    public List<AppUser> getAppUsers() {
        log.info("getUsers");
        return appUserRepository.findAll();
    }

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            log.error("loadUserByUsername error message: User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("loadUserByUsername username : {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(), authorities);
    }
}
