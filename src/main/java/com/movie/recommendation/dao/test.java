package com.movie.recommendation.dao;

import com.movie.recommendation.dto.DatabaseConfiguration;
import com.movie.recommendation.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class test {
    private final DatabaseConfiguration databaseConfiguration;

    public test(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }

    public static void main(String[] args) {
        List<Movie> longestDurationMovies = getLongestDurationMovies();
        System.out.println(longestDurationMovies);

    }
    public static List<Movie> getLongestDurationMovies() {
        List<Movie> movies = new ArrayList<>();
        Movie movie = null;
        String sql = "SELECT tconst, primaryTitle, runtimeMinutes, genres FROM movies ORDER BY runtimeMinutes DESC LIMIT 10";
        System.out.println("working");
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println(" try working");
            while (rs.next()) {
                movie = new Movie();

//                movie.setTconst("tconst");
//                movie.setPrimaryTitle("primaryTitle");
//                movie.setRuntimeMinutes("runtimeMinutes");
//                movie.setGenres("genres");


                movie.setTconst(rs.getString("tconst"));
                movie.setPrimaryTitle(rs.getString("primaryTitle"));
                movie.setRuntimeMinutes(rs.getInt("runtimeMinutes"));
                movie.setGenres(rs.getString("genres"));

                movies.add(movie);
            }
        } catch (SQLException e) {
            System.out.println(" catch working");
            e.printStackTrace();
        }
        return movies;
    }
}
