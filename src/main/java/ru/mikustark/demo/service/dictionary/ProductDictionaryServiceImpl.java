package ru.mikustark.demo.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import ru.mikustark.demo.model.dictionary.Product;
import ru.mikustark.demo.repository.ProductDictionaryRepository;

import java.util.List;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@Service
@RequiredArgsConstructor
public class ProductDictionaryServiceImpl implements ProductDictionaryService {

    private final ProductDictionaryRepository productDictionaryRepository;

    @Override
    @Transactional
    public Mono<List<Product>> getProductDictionary() {
        return productDictionaryRepository.findAll().collectList();
    }
}
