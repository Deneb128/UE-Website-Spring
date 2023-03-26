package com.universalelements.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.security.URIParameter;

@Getter
@Setter
public class GlobalExceptionMessageHandler extends RuntimeException {

    private String title = "Error";
    private String URIpath = "/errors/generalerror";
    private String errorCategory = "General Error";
    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public GlobalExceptionMessageHandler(String message) {
        super(message);
    }

    public GlobalExceptionMessageHandler(String message, String title, String URIPath, String errorCategory, HttpStatus httpStatus) {
        super(message);
        this.title = title;
        this.URIpath = URIPath;
        this.errorCategory = errorCategory;
        this.httpStatus = httpStatus;
    }

}