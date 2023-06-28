package com.movie.recommendation.dao;

import com.movie.recommendation.dto.DatabaseConfiguration;
import com.movie.recommendation.mappers.MovieMapper;
import com.movie.recommendation.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MovieDAOImpl implements MovieDAO {
    private final DatabaseConfiguration databaseConfiguration;


    public MovieDAOImpl(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }


    @Override
    public List<Movie> getAllMovies() {
        String sql = "SELECT * FROM public.movies";
        try {
            return databaseConfiguration.getJdbcTemplate().query(sql, (resultSet, rowNum)
                    -> MovieMapper.buildMovie(resultSet));
        } catch (DataAccessException ex) {
            log.error(ex.getMessage(), ex);
        }
        return new ArrayList<>();
    }

//    @Override
//    public List<Movie> getLongestDurationMovies() {
//        String sql = "SELECT tconst, primaryTitle, runtimeMinutes, genres FROM public.movies ORDER BY runtimeMinutes DESC LIMIT 10";
//
//        try {
//            return databaseConfiguration.getJdbcTemplate().query(sql, (resultSet, rowNum) -> {
//                String tconst = resultSet.getString("tconst");
//                String primaryTitle = resultSet.getString("primaryTitle");
//                int runtimeMinutes = resultSet.getInt("runtimeMinutes");
//                String genres = resultSet.getString("genres");
//
//                return new Movie(tconst, primaryTitle, runtimeMinutes, genres);
//            });
//        } catch (DataAccessException ex) {
//            log.error(ex.getMessage(), ex);
//        }
//        return new ArrayList<>();
//    }


    @Override
    public List<Movie> getLongestDurationMovies() {
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


    @Override
    public String addNewMovie(Movie movies) {
        return null;
    }

    @Override
    public List<Movie> getTopRatedMovies() {
        return null;
    }



}
