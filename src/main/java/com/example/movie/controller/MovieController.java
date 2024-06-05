package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;

@RestController
public class MovieController{

    @Autowired
    public MovieJpaService s;

    @GetMapping("/movies")
    public ArrayList<Movie> getMovies(){
        return s.getMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") int movieId){
        return s.getMovieById(movieId);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie){
        return s.addMovie(movie);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updatMovie(@PathVariable("movieId") int movieId, @RequestBody Movie movie){
        return s.updateMovie(movieId, movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId){
        s.deleteMovie(movieId);
    }
}