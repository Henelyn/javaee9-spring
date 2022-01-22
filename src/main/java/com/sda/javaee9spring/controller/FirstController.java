package com.sda.javaee9spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //responsible for web ...?
@Slf4j      //part of the lombok like singleton pattern, same as the line:  private static final Logger log = LoggerFactory.getLogger(FirstController.class);

public class FirstController {
    //   private static final Logger log = LoggerFactory.getLogger(FirstController.class); //singleton. Same as @Slf4j annotation.

    @GetMapping("/my-first-page") //put URL in  the browser.
    public String firstPage() { //that string is the name of the template (at the moment from resources template html file we created
        log.info("firstPage() method called!"); //that text will be shown when we run our web application
        return "home-page"; //html file name (looking for html inside resources/templates)
    }
}

