package ru.mikustark.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String id;
    private String firstName;
    private String lastName;
    private ArrayList<String> productId;
}
