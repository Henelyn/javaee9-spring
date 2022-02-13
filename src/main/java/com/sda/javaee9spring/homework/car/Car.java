package com.sda.javaee9spring.homework.car;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public record Car(CarBody carBody, Wheel wheel1,
                  Wheel wheel2, Wheel wheel3,
                  Wheel wheel4,
                  Engine engine) { //If you have final fields you can make it record
 /*   @Autowired
    public Car(CarBody, Wheel wheel1, Wheel wheel2, Wheel wheel3, Wheel wheel4, Engine engine) {
        this.carBody = carBody;
        this.wheel1 = wheel1;
        this.wheel2 = wheel2;
        this.wheel3 = wheel3;
        this.wheel4 = wheel4;
        this.engine = engine; */

        public Car { //If you use record, that's how you can add log for it. Otherwise, you need to use @Slf4j annotation
            log.info("Car was created");
        }
    }
