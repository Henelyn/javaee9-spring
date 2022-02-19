package com.sda.javaee9spring.controller.rest;

import com.sda.javaee9spring.entityOrModel.PersonEntity;
import com.sda.javaee9spring.service.RealPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    // /person/1
    // /person/10
    // /person/12345 etc thx to  @GetMapping("/persons/{id}") we don't need to do that

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> findPersonEntityById(@PathVariable("id") Long personId) {
        log.info("trying to find person entity by id: [{}]", personId);
        var personEntity = personService.readPersonEntityById(personId);
        return personEntity.map(personEntity1 -> ResponseEntity.ok(personEntity1)) // Optional<PersonEntity> -> Optional<ResponseEntity<PersonEntity>>
                .orElseGet(() -> ResponseEntity.notFound().build()); //ctrl space inside map() to add lambda

//
//        if (personEntity.isEmpty()) {
//            PersonEntity personEntityFromOptional = personEntity.get();
//            return ResponseEntity.notFound().build();
//        }
////            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);;
//
//        return ResponseEntity.ok(personEntity);
////        return new ResponseEntity<>(personEntity, null, HttpStatus.OK);
    }
}
