package az.nadir.restapi.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class MessageResult {
    @Getter
    @Setter
    private int code;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private boolean success;
    @Getter
    @JsonIgnore
    private Map<String, String> errors;

    public MessageResult() {
        if (errors == null) errors = new HashMap<>();
    }

    public MessageResult(int code, String message) {
        this.code = code;
        this.message = message;
        if (code != 200) success = false;
        if (errors == null) errors = new HashMap<>();
    }

    public MessageResult setSuccess() {
        this.code = 200;
        this.message = "SUCCESS";
        this.success = true;
        return this;
    }

    public MessageResult setSuccess(String message) {
        this.code = 200;
        this.message = message;
        this.success = true;
        return this;
    }

    public MessageResult setError() {
        this.code = MessageCode.ERROR;
        this.message = Message.ERROR;
        this.success = false;
        return this;
    }

    public MessageResult setError(int code, String message) {
        this.code = code;
        this.message = message;
        this.success = false;
        return this;
    }



    public MessageResult setInvalidArgument() {
        this.code = MessageCode.BAD_REQUEST;
        this.message = Message.INVALID_ARGUMENT;
        this.success = false;
        return this;
    }

    public interface Message {
        String SUCCESS = "SUCCESS";
        String BAD_REQUEST = "Bad request";
        String NOT_FOUND = "Not found";
        String ERROR = "Internal error";
        String INVALID_ARGUMENT = "Please make sure all parameters are valid";
        String INTERNAL_SERVER_ERROR = "Internal Server Error";
        String AUTHENTICATION_ERROR = "Authentication Error";
    }

    public interface MessageCode {
        int SUCCESS = 200;
        int BAD_REQUEST = 400;
        int NOT_FOUND = 404;
        int ERROR = 500;
        int UNAUTHORIZED = 401;
    }
}
