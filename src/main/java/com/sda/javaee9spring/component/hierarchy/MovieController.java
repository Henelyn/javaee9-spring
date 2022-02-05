package com.sda.javaee9spring.component.hierarchy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //Controller is going to use the methods of service
public class MovieController {
    private final MovieService movieService;

    @Autowired //here it's only for ij not for the Spring to work. So we could see the graph on console Spring beans(?)
    public MovieController(MovieService movieService) {//best practice is use the constructor instead of autowired
        this.movieService = movieService;   //Autowired is used only inside test not in a production code!!!!!!!!!!!!!
    }
}
