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
//                .titleType(resultSet.getString("titletype"))
                .primaryTitle(resultSet.getString("primaryTitle"))
                .runtimeMinutes(resultSet.getInt("runtimeMinutes"))
                .genres(resultSet.getString("genres"))
                .build();
    }


    public static Movie buildMovieByRating(ResultSet resultSet) throws SQLException {
        return buildByRating(resultSet);
    }

    private static Movie buildByRating(ResultSet resultSet) throws SQLException {
        return Movie.builder()
                .tconst(resultSet.getString("tconst"))
                .primaryTitle(resultSet.getString("primaryTitle"))
                .genres(resultSet.getString("genres"))
                .averageRating(resultSet.getDouble("averageRating"))
                .build();
    }

    public static Movie buildMovieBySubTotal(ResultSet resultSet) throws SQLException {
        return buildBySubTotal(resultSet);
    }

    private static Movie buildBySubTotal(ResultSet resultSet) throws SQLException {
        return Movie.builder()
                .genres(resultSet.getString("genres"))
                .primaryTitle(resultSet.getString("primaryTitle"))
                .numVotes(resultSet.getInt("numVotes"))
                .build();
    }

}
