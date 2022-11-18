package ru.mikustark.demo.model.dictionary;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@Data
@NoArgsConstructor
public class Product {

    @Id
    private Long id;

    private String productId;

    private String value;

}
