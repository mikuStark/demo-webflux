package ru.mikustark.demo;

import org.junit.jupiter.api.Test;
import org.mockserver.model.HttpStatusCode;
import ru.mikustark.demo.model.Person;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
public class PersonControllerTest extends ConfigTests {

    @Test
    void getPersonInfoById() throws IOException {

        mockService(
                "/person/12345",
                "GET",
                "PersonOkResp.json",
                HttpStatusCode.OK_200);

        var expectedResult = Util.getObject("PersonOkResp.json", Person.class);

        Person result = client
                .get()
                .uri("/person/12345")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Person.class)
                .returnResult()
                .getResponseBody();

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPersonInfoByIdStatusCodeError() {

        mockService(
                "/person/12345",
                "GET",
                "PersonOkResp.json",
                HttpStatusCode.BAD_REQUEST_400);

        client
                .get()
                .uri("/person/12345")
                .exchange()
                .expectStatus().isEqualTo(510);
    }

}
