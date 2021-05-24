package co.edu.umb.ds.orderhistory.business.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    private final String message;

    //private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestop;

    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timestop) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestop = timestop;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestop() {
        return timestop;
    }
}
