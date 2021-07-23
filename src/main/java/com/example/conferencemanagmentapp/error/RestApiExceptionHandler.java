package com.example.conferencemanagmentapp.error;

import com.example.conferencemanagmentapp.error.exception.ConferenceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;


@RestControllerAdvice
public class RestApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConferenceNotFoundException.class)
    public ResponseEntity<Object> handleSeanceNotFoundException(ConferenceNotFoundException ex) {
    HttpStatus notFoundStatus = HttpStatus.NOT_FOUND;
    RestApiException restApiException = new RestApiException(
            ex.getMessage(),
            notFoundStatus,
            LocalDateTime.now()
    );
        return new ResponseEntity<>(restApiException, notFoundStatus);
    }
}
