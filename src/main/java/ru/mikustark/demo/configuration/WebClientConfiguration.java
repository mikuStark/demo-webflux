package ru.mikustark.demo.configuration;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.netty.LogbookClientHandler;
import reactor.netty.http.client.HttpClient;
import ru.mikustark.demo.configuration.properties.PersonWebClientProperties;
import ru.mikustark.demo.model.dictionary.Product;
import ru.mikustark.demo.repository.ProductDictionaryRepository;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties({
        PersonWebClientProperties.class
})
public class WebClientConfiguration {

    Logbook logbook = Logbook.create();

    @Bean
    public WebClient integrationPersonWebClient(PersonWebClientProperties personWebClientProperties) {
        HttpClient httpClient = HttpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, personWebClientProperties.getConnectTimeout())
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(personWebClientProperties.getReadTimeout(), TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new LogbookClientHandler(logbook));
                });
        return WebClient.builder()
                .baseUrl(personWebClientProperties.getUrl())
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @Bean
    public CommandLineRunner demo(ProductDictionaryRepository repository) {
        return (args) -> repository.saveAll(Arrays.asList(new Product("098", "productName098"),
                        new Product("088", "productName088"),
                        new Product("087", "productName087")))
                    .blockLast(Duration.ofSeconds(10));
    }
}
