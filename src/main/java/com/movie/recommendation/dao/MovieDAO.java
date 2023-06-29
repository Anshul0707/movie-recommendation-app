package com.movie.recommendation.dao;

import com.movie.recommendation.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDAO {

    List<Movie> getLongestDurationMovies(int limit, String sortType);

    List<Movie> getTopRatedMovies(double limit, String sortType);

    public boolean saveMovie(Movie movie);

    List<Movie> getGenreMoviesWithSubtotals();

    void updateRuntimeMinutes();
}
