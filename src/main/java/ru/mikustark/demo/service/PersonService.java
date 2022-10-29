package ru.mikustark.demo.service;

import reactor.core.publisher.Mono;
import ru.mikustark.demo.model.Person;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
public interface PersonService {

    Mono<Person> getPersonInfoById(String id);
}
