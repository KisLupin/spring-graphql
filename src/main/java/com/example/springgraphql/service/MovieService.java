package com.example.springgraphql.service;

import com.example.springgraphql.model.movie.Movie;
import com.example.springgraphql.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public interface MovieService {
    Movie findOneById(ObjectId id);

    List<Movie> findAllMovies();

    List<Movie> findMoviesWithPaging(int page, int size);
}
