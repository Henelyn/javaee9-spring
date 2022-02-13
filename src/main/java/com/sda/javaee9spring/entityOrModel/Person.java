package com.sda.javaee9spring.entityOrModel;

//entity meaning in database world is some "food on the dabe"?
//entity needs setters and can not use record here.
public record Person(String name, String surname, int age) { //basically final class. Select convert record to class and you'll see the class
}

