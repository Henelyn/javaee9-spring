package com.sda.javaee9spring.service;

import com.sda.javaee9spring.entityOrModel.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService { //responsible for providing the data

    public List<Person> getAllPersons(){
        //With var Java is going to guess type of the variable based on assigned value
        // var name = "bella"; //String name = "bella" are teh same thing. Spring knows it's a String
        // var bella = new Person ("Bella", "Banana", 16);
        // Person bella = new Person ("Bella", "Banana", 16);
        // var bella = null //need initialization value, without that it won't work

        ArrayList<Person> myBestFriendsJava7 = new ArrayList<>(); //since Java 7
        var myBestFriendsJava10 = new ArrayList<Person>(); //since Java 10
        var myBestFriendsJava10v2 = new ArrayList<>(); //since Java 10
        var myBestFriendsJava10v3 = new ArrayList<Object>(); //since Java 10

        // this list will be dynamic in the future
        // var is used only inside the function. Local variable
        var persons //var means type less. Don't need to type List<Person> person = new ...
                = List.of(
                new Person("Bella", "Banana", 18),
                new Person("Jon", "Clone", 20),
                new Person("Jack", "Russell", 21)
        );

        return persons;
    }
}
