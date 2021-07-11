package com.example.springgraphql.model.movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Award {
    private Integer wins;
    private Integer nominations;
    private String text;
}
