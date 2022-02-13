package com.sda.javaee9spring.controller.rest;

import com.sda.javaee9spring.entityOrModel.PersonEntity;
import com.sda.javaee9spring.service.RealPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/")
public class PersonRestController { //depends on RealPersonService
    private final RealPersonService personService; //beans should be private

    @Autowired
    public PersonRestController(RealPersonService personService) { //alt + enter
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<PersonEntity> findAllPersons() {
        log.info("findAllPersons()");

        return personService.readAllPersonEntities();
    }
}
