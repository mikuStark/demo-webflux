package ru.mikustark.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@Data
@NoArgsConstructor
public class ServiceError {

    private LocalDateTime timeStamp = LocalDateTime.now();

    private String message;

    public ServiceError(String message) {
        this.message = message;
    }
}
