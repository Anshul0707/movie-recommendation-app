package com.movie.recommendation.config;

import com.movie.recommendation.dto.DatabaseConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Getter
@Slf4j
@AllArgsConstructor
public class ApplicationConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource DataSource() {
        return DataSourceBuilder.create().build();
    }


}
