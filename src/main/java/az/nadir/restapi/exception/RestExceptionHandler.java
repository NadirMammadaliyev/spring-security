package az.nadir.restapi.exception;

import az.nadir.restapi.model.response.RestResponse;
import javax.naming.AuthenticationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected RestResponse handleCredential(IllegalArgumentException e) {
        log.error("Bad Request caught: {}", e.getMessage());
        return new RestResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected RestResponse handleInternalError(Exception e) {
        log.error("Internal Exception caught: {}", e.getMessage());
        return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler({AuthenticationException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected RestResponse handleAuthenticationException(Exception e) {
        log.error("Authentication Exception caught: {}", e.getMessage());
        return new RestResponse(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
    }
}
