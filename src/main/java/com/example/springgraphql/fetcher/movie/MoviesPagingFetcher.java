package com.example.springgraphql.fetcher.movie;

import com.example.springgraphql.model.movie.Movie;
import com.example.springgraphql.service.MovieService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MoviesPagingFetcher implements DataFetcher<List<Movie>> {
    private final MovieService movieService;

    public MoviesPagingFetcher(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public List<Movie> get(DataFetchingEnvironment environment) {
        Map args = environment.getArguments();
        return movieService.findMoviesWithPaging((int) args.get("page"), (int) args.get("size"));
    }
}
