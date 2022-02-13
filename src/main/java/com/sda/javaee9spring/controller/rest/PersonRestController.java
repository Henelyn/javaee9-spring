package com.sda.javaee9spring.controller.rest;

import com.sda.javaee9spring.service.RealPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PersonRestController { //depends on RealPersonService
    private final RealPersonService personService;


    public PersonRestController(RealPersonService personService) { //alt + enter
        this.personService = personService;
    }
}
