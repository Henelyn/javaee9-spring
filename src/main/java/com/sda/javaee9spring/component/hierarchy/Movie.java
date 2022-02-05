package com.sda.javaee9spring.component.hierarchy;

public record Movie(String title) { //not a bean because its dynamic. Can modify outside Spring application
}
