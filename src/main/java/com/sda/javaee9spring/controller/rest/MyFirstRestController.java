package com.sda.javaee9spring.controller.rest;

import com.sda.javaee9spring.entityOrModel.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //It has @ResponseBody= (If method provides response Object, Spring will convert it to json and put it into the responseBody
@Slf4j
@RequestMapping("/rest")
public class MyFirstRestController {

    //Person object is returned as JSON inside body of response
    @GetMapping("/one-person") //without getMapping it's just a func
    public Person onePerson(){ //object of class Person
        return new Person("Kati", "Karu", 12); //provides a Person. In localhost, we see json, not the html page
    }

    @GetMapping("/persons") // in JSON types are classes
    public List<Person> persons(){
        return List.of(
                new Person("Kasia", "P", 15),
                new Person("Marek", "M", 17)
        );
    }

    @GetMapping("/persons-array")
    public Person[] personsArray(){
        return new Person []{
                new Person("Kasia", "P", 15),
                new Person("Marek", "M", 17)
        };
    }
}
