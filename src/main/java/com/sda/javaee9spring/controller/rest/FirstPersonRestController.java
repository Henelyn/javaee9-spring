package com.sda.javaee9spring.controller.rest;

import com.sda.javaee9spring.entityOrModel.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/first-person-rest")//always use lowercase's inside address. dashes are okay
public class FirstPersonRestController {

    @GetMapping("/one-person")
    public ResponseEntity<Person> onePerson() {
        return  ResponseEntity.ok(new Person("Kati", "Karu", 30));
    }

    @GetMapping("/one-person-404")
    public ResponseEntity<Person> onePerson404() {
        log.info("onePerson404");
        return  ResponseEntity.notFound().build();
    }

    @GetMapping("/custom")
    public ResponseEntity<Person> customResponseEntity(){
        return new ResponseEntity<>(new Person("Kate", "M", 10), HttpStatus.OK);
    }

    @GetMapping("/with-headers")
    public ResponseEntity<Person> customResponseEntityWithHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Name", "henelyn");
        return new ResponseEntity<>(new Person("Toomas", "Agu", 45), headers, HttpStatus.OK);
    }
}

//CRUD