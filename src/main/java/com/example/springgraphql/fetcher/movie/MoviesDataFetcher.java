package com.example.springgraphql.fetcher.movie;

import com.example.springgraphql.model.movie.Movie;
import com.example.springgraphql.service.MovieService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MoviesDataFetcher implements DataFetcher<List<Movie>> {

    private final MovieService movieService;

    public MoviesDataFetcher(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public List<Movie> get(DataFetchingEnvironment environment) {
        return movieService.findAllMovies();
    }
}
