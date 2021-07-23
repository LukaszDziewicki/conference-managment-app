package com.example.conferencemanagmentapp.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RestApiException {
    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDateTime timestamp;

}
