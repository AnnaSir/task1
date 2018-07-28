package ru.anna.mytestpr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.db")
    public DataSource dataSource() {
        System.out.println("dataSource, prefix = spring.db");
        return DataSourceBuilder.create().build();
    }

}
