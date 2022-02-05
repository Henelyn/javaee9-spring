package com.sda.javaee9spring;

import com.sda.javaee9spring.component.MyFirstSpringComponent;
import com.sda.javaee9spring.component.MySecondComponent;
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
        assertNotNull(myFirstController); //assert kontrollib, kas ei ole null, mis on meie ootus
        String firstPageName = myFirstController.firstPage(); //kutsub välja firstPage meetodi
        assertEquals("home-page", firstPageName);     //kontrollib, kas tulemus on, mida soovime
    }

    //Autowired ja Test jooksevad koos
    @Autowired //Spring teeb objekti kui tal on see olemas.
    private MyFirstSpringComponent myFirstSpringComponent;

    @Autowired //kas saame uue või sama objekti? Testime manyObject testis
    private MyFirstSpringComponent myFirstSpringComponentSecondReference;

    @Test
    void checkMyFirstSpringComponentRef() {
        assertNotNull(myFirstSpringComponent);
    }

    @Test //Vastus on üks instance of the class!
    void manyObjectsOfTheSameTypeTest(){
        //== - under the hood checks if 2 references points to the same object
        //by default every bean inside Context is singleton
        assertSame(myFirstSpringComponent, myFirstSpringComponentSecondReference);
    }

    //Kui tegime mitte singletoni, tahame teada, kas Spring annab meile 2 erinevat instanced
    @Autowired
    private MySecondComponent secondComponent;
    @Autowired // mõlemal on oma uba. Same as use keyword new just Spring is going to create it
    private MySecondComponent mySecondComponent;

    @Test
    void checkMySecondSpringComponent(){
        assertNotSame(secondComponent, mySecondComponent); //kontrollin, kas ei ole samad
    }
}

