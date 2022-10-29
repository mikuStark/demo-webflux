package ru.mikustark.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.mikustark.demo.exception.IntegrationPersonCallException;
import ru.mikustark.demo.model.ServiceError;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(IntegrationPersonCallException.class)
    public ResponseEntity<ServiceError> handleException() {
        return ResponseEntity.status(HttpStatus.NOT_EXTENDED)
                .body(ServiceError.builder()
                        .message("Ошибка при обращении в сервис Person")
                        .build());
    }
}
