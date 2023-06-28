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
    private int runtimeMinutes;
    private String genres;


}
