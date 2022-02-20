package com.sda.javaee9spring.service;

import com.sda.javaee9spring.entityOrModel.PersonEntity;
import com.sda.javaee9spring.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RealPersonService { //Knows nothing about controller

    private final PersonRepository personRepository;
    private final RestTemplate restTemplate;

    public RealPersonService(PersonRepository personRepository, RestTemplate restTemplate) {
        this.personRepository = personRepository;
        this.restTemplate = restTemplate;
    }

    public List<PersonEntity> readAllPersonEntities() { //send JSON to the user
        log.info("Trying to read all person entities");

        var result = personRepository.findAll(); //var will great a List for us
        log.info("person entities read from db: {}, result", result);

        return result;
    }

    public Optional<PersonEntity> readPersonEntityById(Long id) {
        log.info("trying to read entity by id: [{}]", id);

        Optional<PersonEntity> maybePerson = personRepository.findById(id); //return type is optional as there my or maybe not a person


        log.info("found Person entity: [{}]", maybePerson);
        return maybePerson;
    }

    @Transactional //when we prepare at least 2 queries
    public boolean deletePersonEntityById(Long id) {
        log.info("trying to delete entity by id: [{}]", id);

        boolean result = false;
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            result = true;
        }

        return result;
    }

    @Transactional //using query twice therefor we need @transactional
    public boolean savePerson(PersonEntity entity) {
        boolean result = false;
        log.info("entity for saving [{}]", entity);
        if (checkIfEntityIsValid(entity) && !personRepository.checkDuplicates(entity.getName(), entity.getSurname())) {
            personRepository.save(entity);
            log.info("entity after saving: [{}]", entity);
            result = true;
        } else {
            log.info("not valid object or duplicate one!!");
        }

        return result;
    }

    private static boolean checkIfEntityIsValid(PersonEntity entity) {
        boolean result = true;
        //" John " -> "John"
        //If name is null or theres only white spaces inside result will be false
        if (entity.getName() == null || entity.getName().isBlank()) { //trim will remove white space
            result = false;
        } else if (entity.getSurname() == null || entity.getSurname().isBlank()) {
            result = false;
        } else if (entity.getAge() < 0) {
            result = false;
        }
        log.info("entity: [{}], valid: [{}]", entity, result);
        return result;
    }
}