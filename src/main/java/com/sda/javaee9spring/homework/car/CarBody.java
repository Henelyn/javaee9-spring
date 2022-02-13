package com.sda.javaee9spring.homework.car;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CarBody {
    public CarBody(){
        log.info("CarBody was created");
    }
}
