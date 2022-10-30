package ru.mikustark.demo.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.mikustark.demo.model.PersonDTO;
import ru.mikustark.demo.model.ServiceError;
import ru.mikustark.demo.service.PersonService;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@RestController
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(
        title = "Микросервис demo",
        version = "1",
        description = "Микросервис demo"))
public class PersonController {

    private final PersonService personService;

    @Operation(
            summary = "Получение информации о человеке по id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный ответ"),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Внутренняя ошибка сервиса",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ServiceError.class))
                            }),
                    @ApiResponse(
                            responseCode = "510",
                            description = "Ошибка вызываемых сервисов",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ServiceError.class))
                            })
            }
    )
    @GetMapping(value = "/person/{id}")
    public Mono<PersonDTO> personInfoById(
            @PathVariable(name = "id") String id) {
        return personService.getPersonInfoById(id);
    }
}
