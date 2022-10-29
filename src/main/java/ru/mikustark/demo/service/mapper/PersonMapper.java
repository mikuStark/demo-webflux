package ru.mikustark.demo.service.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.mikustark.demo.model.PersonDTO;
import ru.mikustark.demo.model.integration.Person;

import java.util.ArrayList;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public abstract class PersonMapper {

    @Mappings({
            @Mapping(target = "products", source = "productId")
    })
    public abstract PersonDTO mapToPersonDTO(Person response);

    @AfterMapping
    void mapProductsList(@MappingTarget PersonDTO personDTO) {
        ArrayList<String> newList = new ArrayList<>();
        personDTO.getProducts().forEach(el -> newList.add(getProductName(el)));
        personDTO.setProducts(newList);
    }

    private String getProductName(String productId) {
        switch (productId) {
            case "098":
                return "productName098";
            case "088":
                return "productName088";
            case "087":
                return "productName087";
            default:
                return null;
        }
    }
}
