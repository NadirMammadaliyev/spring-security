package az.nadir.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RestApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RestApiApplication.class);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

  /*  @Bean
    CommandLineRunner run(AppUserService appUserService) {
        return args -> {
            appUserService.saveRole(new Role(null, RoleName.ROLE_USER.value()));
            appUserService.saveRole(new Role(null, RoleName.ROLE_ADMIN.value()));


            appUserService.saveAppUser(new AppUser(null, "Nadir Mammadaliyev", "nadeer", "password", new ArrayList<>()));
            appUserService.saveAppUser(new AppUser(null, "Omer Xelil", "khalil", "password", new ArrayList<>()));
            appUserService.saveAppUser(new AppUser(null, "Amrah Mammadkhanli", "ahmrah", "password", new ArrayList<>()));
            appUserService.saveAppUser(new AppUser(null, "Chingiz Umudlu", "chingiz", "password", new ArrayList<>()));

            appUserService.addRoleToUser("nadeer", RoleName.ROLE_ADMIN.value());
            appUserService.addRoleToUser("khalil", RoleName.ROLE_ADMIN.value());
            appUserService.addRoleToUser("ahmrah", RoleName.ROLE_ADMIN.value());
            appUserService.addRoleToUser("ahmrah", RoleName.ROLE_USER.value());
            appUserService.addRoleToUser("chingiz", RoleName.ROLE_USER.value());
        };
    }*/
}
