package az.nadir.restapi.model.response;

import lombok.ToString;

@ToString(callSuper = true)
public class RestResponse<T> extends MessageResult {
    private T responseObject;

    public Object getErrorObject() {
        return errorObject;
    }

    public void setErrorObject(Object errorObject) {
        this.errorObject = errorObject;
    }

    private Object errorObject;

    public RestResponse() {
        this.setError();
    }

    public RestResponse(T data) {
        this.responseObject = data;
        this.setSuccess();
    }

    public RestResponse(int code, String message) {
        super(code, message);
    }

    public RestResponse(int code, String message, T data) {
        super(code, message);
        this.responseObject = data;
    }

    public RestResponse setSuccess(String message) {
        this.setSuccess(message);
        return this;
    }

    public RestResponse setSuccess(int code, String message) {
        this.setSuccess(code, message);
        return this;
    }

    public RestResponse setError(int code, String message) {
        super.setError(code, message);
        return this;
    }

    public T getResponseObject() {
        return this.responseObject;
    }

    public void setResponseObject(T responseObject) {
        this.responseObject = responseObject;
    }

    public void setObjectWithSuccess(T responseObject) {
        this.responseObject = responseObject;
        this.setSuccess();
    }
}
