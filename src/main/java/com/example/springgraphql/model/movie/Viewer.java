package com.example.springgraphql.model.movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Viewer {
    private Float rating;
    private Integer numReviews;
    private Integer meter;
}
