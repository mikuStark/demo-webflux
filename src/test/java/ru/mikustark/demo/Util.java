package ru.mikustark.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * mkarbainova
 *
 * @author Mariya Karbainova
 */
@UtilityClass
public class Util {
    public String readFile(String fileName) throws IOException {
        final var resource = new ClassPathResource(fileName);
        return Files.readString(Path.of(resource.getURI()));
    }

    public <T> T getObject(String fileName, Class<T> fileType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(
                ClassLoader.getSystemClassLoader().getResource(fileName),
                fileType);
    }
}
