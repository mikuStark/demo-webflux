package ru.mikustark.demo.service;

import reactor.core.publisher.Mono;
import ru.mikustark.demo.model.PersonDTO;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
public interface PersonService {

    Mono<PersonDTO> getPersonInfoById(String id);
}
