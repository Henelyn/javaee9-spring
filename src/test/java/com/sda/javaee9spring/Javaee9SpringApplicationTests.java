package com.sda.javaee9spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Javaee9SpringApplicationTests {

    //SERVICE IS A LOGIC ABOUT OUR APPLICATION. in the future, we don't add it under the controller

    @Test
    void contextLoads() {
    }

    @Test
    void dependencyInjectionFirstTrial() { //Injection means providing independence
        Toy furryTeddy = new Toy("furry Teddy");
        Child john = new Child("John", furryTeddy);
        // dependency injection is providing all required class dependencies during creation
        // of object of that class
        // furryTeddy (of type Toy) is dependency of john (of type Child)
        //john (witch is of type Child) is dependency of jason (of type Parent)
        // dependency is actually composition, so one item is made of another
        Parent jason = new Parent("Jason", john);

//composition vs inheritance =

    }

    @Test
    void recordsTest(){
        Animal animal = new Animal();
        System.out.println(animal);

        Toy toy = new Toy("T");
        System.out.println(toy);
    }

    @Test
    void equalsTest(){
        Assertions.assertTrue(4 == 4);
        Animal one = new Animal();
        Animal two = new Animal();
        Animal three = new Animal();

        // == it checks if this is the same object
        // equals by defaults it checks if this is the same object

        Assertions.assertFalse(one == two);
        Assertions.assertFalse(one.equals(two));

        Toy furryTeddy = new Toy("furry Teddy");
        Toy furryTeddy2 = new Toy("furry Teddy");
        Assertions.assertEquals(furryTeddy, furryTeddy2); //Kas on samad või ei ole?
    }
}

//use records instead of @Value from Lombok
//records are immutable- cannot modify instances of the class- NO SETTERS
//By using records you don't need to use toString or equals. Records provides it for "free"
//Toy is made of name
record Toy(String name){}
//Child is composed of: name and toy
record Child(String name, Toy favoriteToy) { }
// parent is made of: name and child
record Parent(String name, Child child) {
}

class  Animal{}
class Mammal extends Animal {}
class Tiger extends Mammal{}
//Tiger is Mammal
//Tiger is Animal
//We cannot say: Parent is Child (parent don't extend Child)
