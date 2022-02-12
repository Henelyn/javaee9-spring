package com.sda.javaee9spring.homework.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    CarBody carBody;
    Wheel wheel1;
    Wheel wheel2;
    Wheel wheel3;
    Wheel wheel4;
    Engine engine;

    @Autowired
    public Car(CarBody carBody, Wheel wheel1, Wheel wheel2, Wheel wheel3, Wheel wheel4, Engine engine) {
        this.carBody = carBody;
        this.wheel1 = wheel1;
        this.wheel2 = wheel2;
        this.wheel3 = wheel3;
        this.wheel4 = wheel4;
        this.engine = engine;
    }
}
