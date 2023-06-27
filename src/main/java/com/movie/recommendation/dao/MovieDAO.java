package com.movie.recommendation.dao;

import com.movie.recommendation.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDAO {
    List<Movie> getAllMovies();

    List<Movie> getLongestDurationMovies();

    String addNewMovie(Movie movies);

    List<Movie> getTopRatedMovies();
}
