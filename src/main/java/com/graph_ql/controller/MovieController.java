package com.graph_ql.controller;

import com.graph_ql.model.Ganre;
import com.graph_ql.model.Movie;
import com.graph_ql.service.MovieService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @QueryMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @QueryMapping
    public Optional<Movie> findOne(@Argument Integer id){
        return movieService.findOne(id);
    }

    @MutationMapping
    public Movie create(@Argument String name, @Argument Ganre ganre) {
        return movieService.create(name, ganre);
    }

    @MutationMapping
    public Movie update(@Argument Integer id, @Argument String name, @Argument Ganre ganre) {
        return movieService.update(id, name, ganre);
    }

    @MutationMapping
    public Movie delete(@Argument Integer id) {
        return movieService.delete(id);
    }
}
