package com.movie.recommendation.service;

import com.movie.recommendation.dao.DAOService;
import com.movie.recommendation.dao.MovieDAO;
import com.movie.recommendation.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieDAO movieDAO;

    private final DAOService daoService;

    public MovieService(DAOService daoService) {
        this.daoService = daoService;
        this.movieDAO = daoService.getMovieDAO();
    }

    public List<Movie> getLongestDurationMovies(int limit, String sortType) {
        List<Movie> longestDurationMovies = null;
        try {
            longestDurationMovies = movieDAO.getLongestDurationMovies(limit, sortType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return longestDurationMovies;
    }

    public boolean saveMovie(Movie movie) {
        try {
            movieDAO.saveMovie(movie);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Movie> getTopRatedMovies() {
        List<Movie> topRatedMovies = null;
        try {
            topRatedMovies = movieDAO.getTopRatedMovies();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topRatedMovies;
    }

    public List<Movie> getGenreMoviesWithSubtotals() {
        List<Movie> genreMoviesWithSubtotals = null;
        try {
            genreMoviesWithSubtotals = movieDAO.getGenreMoviesWithSubtotals();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genreMoviesWithSubtotals;
    }
}
