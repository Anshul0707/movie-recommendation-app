package com.movie.recommendation.service;

import com.movie.recommendation.dao.MovieDAO;
import com.movie.recommendation.model.Movie;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {

    MovieDAO movieDAO;

    public MovieService(MovieDAO movieDAO){
        this.movieDAO = movieDAO;
    }
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    public List<Movie> getLongestDurationMovies() {

        List<Movie> longestDurationMovies = null;
        try{
           longestDurationMovies = movieDAO.getLongestDurationMovies();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return longestDurationMovies;
    }
}
