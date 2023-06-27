package com.movie.recommendation.model;

import lombok.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private String tconst;
    private double averageRating;
    private int numVotes;
}
