package com.sda.javaee9spring.component.hierarchy;

import org.springframework.stereotype.Controller;

@Controller
public class MovieController {
    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
}
