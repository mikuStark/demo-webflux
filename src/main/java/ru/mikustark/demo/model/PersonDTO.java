package ru.mikustark.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class PersonDTO {

    @Schema(description = "id", required = true)
    private String id;
    @Schema(description = "Имя")
    private String firstName;
    @Schema(description = "Фамилия")
    private String lastName;
    @Schema(description = "Продукты")
    private ArrayList<String> products;
}
