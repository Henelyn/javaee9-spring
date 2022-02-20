package com.sda.javaee9spring.controller.rest;

import com.sda.javaee9spring.entityOrModel.Person;
import com.sda.javaee9spring.entityOrModel.PersonEntity;
import com.sda.javaee9spring.service.RealPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping("/persons/{id}") //create an endpoint for GET method
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


    @DeleteMapping("/persons/{id}") //create an endpoint for Delete method
    public ResponseEntity<Void> deletePersonEntityById(@PathVariable("id") Long id){
        log.info("Trying do delete person entity by id: [{}]", id);

        boolean deleted = personService.deletePersonEntityById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/persons") //create an endpoint for post method
    public ResponseEntity<PersonEntity>  createPersonEntity(@RequestBody PersonEntity newPersonToSave) {//I need to learn about response codes
        log.info("Received new person to save: [{}]", newPersonToSave);
        personService.savePerson(newPersonToSave);
        return ResponseEntity.created(URI.create("/api/persons/%d".formatted(newPersonToSave.getId())))
                .body(newPersonToSave);
    }
}
