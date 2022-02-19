package com.sda.javaee9spring.service;

import com.sda.javaee9spring.entityOrModel.Person;
import com.sda.javaee9spring.entityOrModel.PersonEntity;
import com.sda.javaee9spring.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Optional<PersonEntity> readPersonEntityById(Long id){
        log.info("trying to read entity by id: [{}]", id);

      Optional<PersonEntity> maybePerson = personRepository.findById(id); //return type is optional as there my or maybe not a person


        log.info("found Person entity: [{}]", maybePerson);
        return maybePerson;
    }

    @Transactional
    public boolean deletePersonEntityById(Long id) {
        log.info("trying to delete entity by id: [{}]", id);

        boolean result = false;
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            result = true;
        }

        return result;
    }
}
