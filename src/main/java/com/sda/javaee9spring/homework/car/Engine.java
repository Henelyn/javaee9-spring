package com.sda.javaee9spring.homework.car;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Engine { //engine is a composition
   private final EngineBody engineBody;
   private final EngineHead engineHead;

    @Autowired
    public Engine(EngineBody engineBody, EngineHead engineHead) {
        this.engineBody = engineBody;
        this.engineHead = engineHead;
        log.info("Engine was created");
    }
}
