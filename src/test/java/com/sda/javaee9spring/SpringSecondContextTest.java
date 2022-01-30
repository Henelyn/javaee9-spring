package com.sda.javaee9spring;

import com.sda.javaee9spring.component.MySecondSpringComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class SpringSecondContextTest {

    @Autowired
    private MySecondSpringComponent mySecondSpringComponent;

    @Autowired

    private MySecondSpringComponent mySecondSpringComponentSecondReference;

    @Test
    void checkMyFirstSpringComponentRef() {
        assertNotNull(mySecondSpringComponent);
    }

    @Test
    void manyObjectsOfTheSameTypeTest() {
        //== - under the hood checks if 2 references points to the same object
        //by default every bean inside Context is singleton
        assertSame(mySecondSpringComponent, mySecondSpringComponentSecondReference);
    }
}

