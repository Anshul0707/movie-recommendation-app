package com.movie.recommendation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rating {
    private String tconst;
    private double averageRating;
    private int numVotes;
}
