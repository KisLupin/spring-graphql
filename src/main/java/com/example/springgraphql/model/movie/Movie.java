package com.example.springgraphql.model.movie;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "movies")
@Getter
@Setter
@Builder
public class Movie {
    @Id
    private String id;
    private String plot;
    private List<String> genres;
    private Integer runtime;
    private Integer num_mflix_comments;
    private List<String> cast;
    private String title;
    @Field(name = "fullplot")
    private String fullPlot;
    private List<String> countries;
    private List<String> directors;
    private String rated;
    private LocalDateTime released;
    private String lastupdated;
    private Integer year;
    private IMDB imdb;
    private String type;
    private Tomato tomatoes;
}
