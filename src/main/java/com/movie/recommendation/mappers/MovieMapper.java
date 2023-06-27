package com.movie.recommendation.mappers;

import com.movie.recommendation.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper {
    public static Movie buildMovie(ResultSet resultSet) throws SQLException {
        return build(resultSet);
    }

    private static Movie build(ResultSet resultSet) throws SQLException {
        return Movie.builder()
                .tconst(resultSet.getString("tconst"))
                .titleType(resultSet.getString("titletype"))
                .primaryTitle(resultSet.getString("primarytitle"))
                .runtimeMinutes(resultSet.getString("runtimeminutes"))
                .genres(resultSet.getString("genres"))
                .build();
    }
}
