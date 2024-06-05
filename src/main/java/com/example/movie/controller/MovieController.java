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
}