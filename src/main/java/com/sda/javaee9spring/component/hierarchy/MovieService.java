package com.sda.javaee9spring.component.hierarchy;

import org.springframework.stereotype.Service;

@Service //Also, a component under the hood. Spring let's create a service. Singleton.
public class MovieService { //CAN WE MAKE THE CLASS RECORD AND USE THE CONSTRUCTOR AS WE DID? WHI DIDNT WE USED RECORD HERE?
    private final MovieRepository movieRepository;

//Selleks, et saaks MovieService teha, peab tegema enne MovieRepository
    public MovieService(MovieRepository movieRepository) {//if you have a constructor you don't need to add @autowired
        this.movieRepository = movieRepository; // as its private final we need to use constructor
    }
}
