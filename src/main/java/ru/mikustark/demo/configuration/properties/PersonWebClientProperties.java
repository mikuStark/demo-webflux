package ru.mikustark.demo.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@Data
@Configuration
@ConfigurationProperties("integration.person")
public class PersonWebClientProperties {

    private String url;
    private String pathId;
    private Integer connectTimeout;
    private Integer readTimeout;
}
