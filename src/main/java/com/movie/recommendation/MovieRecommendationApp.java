package com.movie.recommendation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@OpenAPIDefinition(info = @Info(
        title = "Movie Recommendation App",
        description = "The Movie Recommendation App is a web application that provides users with personalized movie recommendations based on runtime, rating, and genre. It includes the following features:\n" +
                " - Retrieve the top 10 movies with the longest runtime.\n" +
                " - Add new movies to the database.\n" +
                " - Display highly-rated movies.\n" +
                " - Show genre-wise movie lists with numVotes subtotals.\n\n" +
                "The app utilizes an SQL database and an HTTP server to handle user requests and deliver accurate movie recommendations. It is implemented using [Java-SpringBoot] and follows RESTful API principles.",
        version = "1.0"
))
public class MovieRecommendationApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MovieRecommendationApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Application is started ...");
    }
}
