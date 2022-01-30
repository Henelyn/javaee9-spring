package com.sda.javaee9spring.component.hierarchy;

import org.springframework.stereotype.Service;

@Service //Also, a component under the hood. Spring let's create a service.
public class MovieService {
    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {//if you have a constructor you don't need to add @autowired
        this.movieRepository = movieRepository;           // as its private final we need to use constructor
    }
}
