package com.universalelements.Exception;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionMessageSender extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GlobalExceptionMessageHandler.class)
    ErrorResponse handleExceptionMessageSender(GlobalExceptionMessageHandler ex) {
        return ErrorResponse.builder(ex, ex.getHttpStatus(), ex.getMessage())
                .title(ex.getTitle())
                .type(URI.create("http://localhost:8080" + ex.getURIpath()))
                .property("errorCategory", ex.getErrorCategory())
                .property("timestamp", Instant.now())
                .build();
    }
}