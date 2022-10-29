package ru.mikustark.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceError {

    private LocalDateTime timeStamp = LocalDateTime.now();

    private String message;
}
