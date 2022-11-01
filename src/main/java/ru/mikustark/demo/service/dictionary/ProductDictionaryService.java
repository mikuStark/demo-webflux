package ru.mikustark.demo.service.dictionary;

import reactor.core.publisher.Mono;
import ru.mikustark.demo.model.dictionary.Product;

import java.util.List;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
public interface ProductDictionaryService {

    Mono<List<Product>> getProductDictionary();
}
