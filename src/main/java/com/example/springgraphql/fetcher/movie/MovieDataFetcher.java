package com.example.springgraphql.fetcher.movie;

import com.example.springgraphql.model.movie.Movie;
import com.example.springgraphql.service.MovieService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MovieDataFetcher implements DataFetcher<Movie> {
    private final MovieService movieService;

    public MovieDataFetcher(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public Movie get(DataFetchingEnvironment environment) {
        Map args = environment.getArguments();
        return movieService.findOneById(new ObjectId(String.valueOf(args.get("id"))));
    }
}
