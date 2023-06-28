package com.movie.recommendation.controller;

import com.movie.recommendation.dto.Response;
import com.movie.recommendation.model.Movie;
import com.movie.recommendation.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/longest-duration-movies")
    public List<Movie> getLongestDurationMovies() {
        Response response;
        List<Movie> movies = null;

        try {
            movies = movieService.getLongestDurationMovies();
            response = new Response();
            response.setStatus("Success");
            response.setMessage("Get All Movies.");
        } catch (Exception ex) {
            response = new Response();
            response.setStatus("Failure");
            response.setMessage("Can't get All Movies.");
        }
        return movies;
    }
}
