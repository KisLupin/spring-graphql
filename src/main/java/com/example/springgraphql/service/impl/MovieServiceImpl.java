package com.example.springgraphql.service.impl;

import com.example.springgraphql.model.movie.Movie;
import com.example.springgraphql.repository.MovieRepository;
import com.example.springgraphql.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findOneById(ObjectId id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> findMoviesWithPaging(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Movie> moviePage = movieRepository.findAll(paging);
        return moviePage.stream().collect(Collectors.toList());
    }
}
