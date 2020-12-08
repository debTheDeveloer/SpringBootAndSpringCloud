package com.IN28minutes.rest.webservice.restfulwebservice.exception;

import java.util.Date;

public class ExceptionResponse {
    private String message;
    private Date timeStamp;
    private String details;

    public ExceptionResponse(String message, Date timeStamp, String details) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getDetails() {
        return details;
    }
}
