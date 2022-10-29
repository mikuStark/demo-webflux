package ru.mikustark.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.mikustark.demo.configuration.properties.PersonWebClientProperties;
import ru.mikustark.demo.exception.IntegrationPersonCallException;
import ru.mikustark.demo.model.Person;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final WebClient integrationPersonWebClient;
    private final PersonWebClientProperties personWebClientProperties;

    @Override
    public Mono<Person> getPersonInfoById(String id) {
        return integrationPersonWebClient
                .get()
                .uri(personWebClientProperties.getPathId(), id)
                .headers(headers -> {
                    headers.setContentType(MediaType.APPLICATION_JSON);
                })
                .exchangeToMono(response -> {
                    if (response.rawStatusCode() != 200) return Mono.error(new IntegrationPersonCallException());
                    return response.bodyToMono(Person.class);
                })
                .doOnSuccess(data -> log.info("Получена информация по клиенту {}", id))
                .doOnError(data -> log.info("Ошибка при обращении в сервис Person"));
    }
}
