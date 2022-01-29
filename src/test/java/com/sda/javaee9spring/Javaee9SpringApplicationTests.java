package com.sda.javaee9spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Javaee9SpringApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void dependencyInjectionFirstTrial() {
        Toy furryTeddy = new Toy("furry Teddy");
        Child john = new Child("John", furryTeddy);
        // dependency injection is providing all required class dependencies during creation
        // of object of that class
        // furryTeddy (of type Toy) is dependency of john (of type Child)
        //john (witch is of type Child) is dependency of jason (of type Parent)
        // dependency is actually composition, so one item is made of another
        Parent jason = new Parent("Jason", john);
    }
}
//Toy is made of name
record Toy(String name){}
//Child is composed of: name and toy
record Child(String name, Toy favoriteToy) { }
// parent is made of: name and child
record Parent(String name, Child child) {
}

class Animal{}
class Mammal extends Animal {}
class Tiger extends Mammal{}
//Tiger is Mammal
//Tiger is Animal
//We cannot say: Parent is Child (parent don't extend Child)
