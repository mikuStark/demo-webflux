package ru.mikustark.demo.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.mikustark.demo.model.PersonDTO;
import ru.mikustark.demo.model.dictionary.Product;
import ru.mikustark.demo.model.integration.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public abstract class PersonMapper {

    public PersonDTO mapPersonDTO(Person person, List<Product> result) {
        return mapToPersonDTO(person, mapListProduct(person, result));
    }

    @Mappings({
            @Mapping(target = "products", source = "productsList")
    })
    public abstract PersonDTO mapToPersonDTO(Person response, ArrayList<String> productsList);

    private ArrayList<String> mapListProduct(Person person, List<Product> result) {
        ArrayList<String> newList = new ArrayList<>();
        person.getProductId().forEach(el -> newList.add(getProductName(el, result)));
        return newList;
    }

    private String getProductName(String el, List<Product> result) {
        Optional<Product> product = result.stream().filter(prod -> el.equals(prod.getProductId())).findFirst();
        return product.isPresent() ? product.get().getValue() : "defaultValue";
    }
}
