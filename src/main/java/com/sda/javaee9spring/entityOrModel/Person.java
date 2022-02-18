package com.sda.javaee9spring.entityOrModel;

//entity meaning in database world is some "food on the table"?
//entity needs setters and therefor can not use record here.
//basically final class. Select convert record to class, and you'll see the class
public record Person(String name, String surname, int age) {
}

