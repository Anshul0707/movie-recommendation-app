package com.movie.recommendation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseConfiguration {
    private JdbcTemplate jdbcTemplate;
}
