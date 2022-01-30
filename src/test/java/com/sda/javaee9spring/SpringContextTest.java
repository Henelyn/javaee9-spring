package com.sda.javaee9spring;

import com.sda.javaee9spring.component.MyFirstSpringComponent;
import com.sda.javaee9spring.controller.FirstController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpringContextTest {
    @Autowired
    private FirstController myFirstController;

    @Test
    void checkFirstControllerReference() {
        assertNotNull(myFirstController);
        String firstPageName = myFirstController.firstPage();
        assertEquals("home-page", firstPageName);
    }

    @Autowired
    private MyFirstSpringComponent myFirstSpringComponent;

    @Autowired
    private MyFirstSpringComponent myFirstSpringComponentSecondReference;

    @Test
    void checkMyFirstSpringComponentRef() {
        assertNotNull(myFirstSpringComponent);
    }

    @Test
    void manyObjectsOfTheSameTypeTest(){
        //== - under the hood checks if 2 references points to the same object
        //by default every bean inside Context is singleton
        assertSame(myFirstSpringComponent, myFirstSpringComponentSecondReference);
    }
}

