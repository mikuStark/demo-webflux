package ru.mikustark.demo;

import lombok.SneakyThrows;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpStatusCode;
import org.mockserver.springtest.MockServerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@SpringBootTest
@MockServerTest({
		"integration.person.url:http://localhost:${mockServerPort}"
})
@AutoConfigureWebTestClient
class ConfigTests {

	@Autowired
	protected WebTestClient client;

	protected MockServerClient mockServerClient;

	@SneakyThrows
	protected void mockService(String endpoint,
							   String method,
							   String responseFilePath,
							   HttpStatusCode code) {

		var responseData = Util.readFile(responseFilePath);

		mockServerClient
				.when(request()
						.withMethod(method)
						.withPath(endpoint))
				.respond(response()
						.withStatusCode(code.code())
						.withContentType(org.mockserver.model.MediaType.APPLICATION_JSON)
						.withBody(responseData));
	}

}
