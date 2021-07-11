package com.example.springgraphql.model.movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IMDB {
    private Integer id;
    private Float rating;
    private Integer votes;
}
