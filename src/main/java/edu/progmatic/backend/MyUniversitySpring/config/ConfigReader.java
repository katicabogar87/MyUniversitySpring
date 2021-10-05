package edu.progmatic.backend.MyUniversitySpring.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;

@Configuration
public class ConfigReader {
    @Getter
    @Value("${custom.courses.resource}")
    private Path resource;

    @Getter
    @Value("${custom.regex.split.courses.line}")
    private String coursesSplitRegex;
}

