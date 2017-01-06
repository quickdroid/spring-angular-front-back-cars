package com.cars.mike.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DBConfiguration {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    @Primary
    public DataSource dbDataSource() {

        return DataSourceBuilder.create().build();
    }

    @Bean
    @Profile("test")
    public Flyway flyway(DataSource theDataSource) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(theDataSource);
        flyway.setLocations("classpath:db/migration");
        flyway.clean();
        flyway.migrate();

        return flyway;
    }


}
