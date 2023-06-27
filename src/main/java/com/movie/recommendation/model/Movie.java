package com.movie.recommendation.model;

import lombok.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String tconst;
    private String titleType;
    private String primaryTitle;
    private String runtimeMinutes;
    private String genres;

    public Movie(String tconst, String primaryTitle, int runtimeMinutes, String genres) {

    }
}
