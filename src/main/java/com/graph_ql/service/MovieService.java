package com.graph_ql.service;

import com.graph_ql.model.Ganre;
import com.graph_ql.model.Movie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MovieService {
    private List<Movie> movies = new ArrayList<>();
    AtomicInteger id = new AtomicInteger(0);

    public List<Movie> findAll() {
        return movies;
    }

    public Optional<Movie> findOne(Integer id) {
        return movies.stream().filter(movie -> Objects.equals(movie.getId(), id)).findFirst();
    }

    public Movie create(String name, Ganre ganre) {
        var movie = new Movie(id.incrementAndGet(), name, ganre);
        movies.add(movie);
        return movie;
    }

    public Movie update(Integer id, String name, Ganre ganre) {
        Optional<Movie> movie = movies.stream().filter(m -> Objects.equals(m.getId(), id)).findFirst();
        var newMovie = new Movie(id, name, ganre);
        if (movie.isPresent()) {
            int index = movies.indexOf(movie.get());
            movies.set(index, newMovie);
        } else {
            throw new IllegalArgumentException("Invalid movie");
        }
        return newMovie;
    }

    public Movie delete(Integer id) {
        var movie = movies.stream().filter(item -> Objects.equals(item.getId(), id)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        movies.remove(movie);
        return movie;
    }

    @PostConstruct
    private void init() {
        var m1 = new Movie(id.incrementAndGet(), "Terminator 2", Ganre.ACTION);
        var m2 = new Movie(id.incrementAndGet(), "IT", Ganre.HORROR);
        var m3 = new Movie(id.incrementAndGet(), "Brave Heart", Ganre.HISTORY);
        var m4 = new Movie(id.incrementAndGet(), "When You sleep", Ganre.MELODRAMA);
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        movies.add(m4);
    }
}
