package co.edu.umb.ds.productinfo.business.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private final String message;

    //private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestap;

    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timestap) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestap = timestap;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestap() {
        return timestap;
    }


}
