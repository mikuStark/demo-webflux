package ru.mikustark.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.mikustark.demo.model.dictionary.Product;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
public interface ProductDictionaryRepository extends ReactiveCrudRepository<Product, Long> {
}
