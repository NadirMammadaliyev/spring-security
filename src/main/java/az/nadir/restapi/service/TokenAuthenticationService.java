package az.nadir.restapi.service;

public interface TokenAuthenticationService {
    Boolean hasAccess(String token);

}
