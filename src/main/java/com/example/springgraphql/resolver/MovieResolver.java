package com.example.springgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.springgraphql.model.movie.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieResolver implements GraphQLResolver<Movie> {


}
