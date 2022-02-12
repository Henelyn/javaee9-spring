package com.sda.javaee9spring.homework.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    EngineBody engineBody;
    EngineHead engineHead;

    @Autowired
    public Engine(EngineBody engineBody, EngineHead engineHead) {
        this.engineBody = engineBody;
        this.engineHead = engineHead;
    }
}
