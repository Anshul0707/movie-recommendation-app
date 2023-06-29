package com.movie.recommendation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie {
    private String tconst;
    private String titleType;
    private String primaryTitle;
    private Integer runtimeMinutes;
    private String genres;

    private Double averageRating;
    private Integer numVotes;


}
