package ru.mikustark.demo.configuration;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import ru.mikustark.demo.configuration.properties.PersonWebClientProperties;

import java.time.Duration;
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

    @Bean
    public WebClient integrationPersonWebClient(PersonWebClientProperties personWebClientProperties) {
        HttpClient httpClient = HttpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, personWebClientProperties.getConnectTimeout())
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(personWebClientProperties.getReadTimeout(), TimeUnit.MILLISECONDS));
                });
        return WebClient.builder()
                .baseUrl(personWebClientProperties.getUrl())
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
