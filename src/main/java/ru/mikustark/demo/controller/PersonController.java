package ru.mikustark.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.mikustark.demo.model.Person;
import ru.mikustark.demo.service.PersonService;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/person/{id}")
    public Mono<Person> personInfoById(
            @PathVariable(name = "id") String id) {
        return personService.getPersonInfoById(id);
    }
}
