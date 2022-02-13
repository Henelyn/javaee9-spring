package com.sda.javaee9spring.service;

import com.sda.javaee9spring.entityOrModel.PersonEntity;
import com.sda.javaee9spring.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RealPersonService { //Knows nothing about controller

    private final PersonRepository personRepository;

    public RealPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonEntity> readAllPersonEntities() { //send JSON to the user
        log.info("Trying to read all person entities");

        var result = personRepository.findAll(); //var will great a List for us
        log.info("person entities read from db: {}, result", result);

        return result;
    }
}
