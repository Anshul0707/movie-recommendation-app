package com.movie.recommendation.controller;

import com.movie.recommendation.dto.Response;
import com.movie.recommendation.model.Movie;
import com.movie.recommendation.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {


    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/longest-duration-movies")
    public List<Movie> getLongestDurationMovies(@RequestParam(value = "limit",
            defaultValue = "10") int limit, @RequestParam(value = "sortType",
            defaultValue = "DESC") String sortType) {

        Response response;
        List<Movie> movies = null;
        try {
            movies = movieService.getLongestDurationMovies(limit, sortType);
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

    @PostMapping("/new-movie")
    public ResponseEntity<String> addNewMovie(@RequestBody Movie movie) {
        boolean isSaved = movieService.saveMovie(movie);
        if (isSaved) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/top-rated-movies")
    public List<Movie> getTopRatedMovies() {
        Response response;
        List<Movie> movies = null;
        try {
            movies = movieService.getTopRatedMovies();
            response = new Response();
            response.setStatus("Success");
            response.setMessage("Get top-rated-movies");
        } catch (Exception ex) {
            response = new Response();
            response.setStatus("Failure");
            response.setMessage("Can't get top-rated-movies");
        }
        return movies;
    }

    @GetMapping("/genre-movies-with-subtotals")
    public List<Movie> getGenreMoviesWithSubtotals() {
        Response response;
        List<Movie> movies = null;
        try {
            movies = movieService.getGenreMoviesWithSubtotals();
            response = new Response();
            response.setStatus("Success");
            response.setMessage("Get genre-movies-with-subtotals");
        } catch (Exception ex) {
            response = new Response();
            response.setStatus("Failure");
            response.setMessage("Can't genre-movies-with-subtotals.");
        }
        return movies;
    }

}
