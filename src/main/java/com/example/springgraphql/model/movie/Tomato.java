package com.example.springgraphql.model.movie;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Tomato {
    private Viewer viewer;
    private LocalDateTime lastUpdated;
}
