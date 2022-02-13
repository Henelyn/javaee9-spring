package com.sda.javaee9spring.homework.car;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EngineHead {

    public EngineHead() {
        log.info("Engine head is created");
    }
}
