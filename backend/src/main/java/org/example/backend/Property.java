package org.example.backend;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("database")
public class Property {
    private String applicationUrl;
}
