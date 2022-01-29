package com.sda.javaee9spring.controller;

import com.sda.javaee9spring.entityOrModel.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/person")
public class PersonController {

    public static String PERSON_KEY = "personKey";

    @GetMapping("/names")

    public String showListOfPersonsNames(Model data) {
        //this list will be dynamic in the future
//        List<Person> persons
        var persons
                = List.of(
                new Person("Mati", "Nuude", 67),
                new Person("Kati", "Murutar", 60),
                new Person("Oolu", "Tuuda", 45)
        );

        data.addAttribute(PERSON_KEY, persons);
        return "persons/persons-names"; // return name of the template
    }
}
