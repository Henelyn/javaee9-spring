package com.sda.javaee9spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //responsible for web ...? //Greats a bean for you adn stores it under Spring context
@Slf4j
//part of the lombok like singleton pattern, same as the line:  private static final Logger log = LoggerFactory.getLogger(FirstController.class);
@RequestMapping("/first")
public class FirstController {
    //   private static final Logger log = LoggerFactory.getLogger(FirstController.class); //singleton. Same as @Slf4j annotation.

    @GetMapping({"/my-first-page", "/"}) //put URL in  the browser.
    public String firstPage() { //that string is the name of the template (at the moment from resources template html file we created
        log.info("firstPage() method called!"); //that text will be shown when we run our web application
        return "home-page"; //html file name (looking for html inside resources/templates)
        // We return String because
    }

    @GetMapping("/my-second-page") //@GetMappings is used for creating URL's
    public String secondPage() {
        log.info("secondPage() method called!!!");
        //looking for html page inside resources/templates
        return "second-page";
    }

    //    @GetMapping("/third-page")
    //    @GetMapping(value = "/third-page")
    //    @GetMapping(value = {"/third-page"}, params = {})
    @GetMapping(value = {"/third-page", "/third-too", "/abcd"})
    public String thirdPage() {
        log.info("thirdPage() method was called!!!");
        return "pages/third-page";
    }

    // /my-name?name=Henelyn&surname=Kandver
    // name param with value Henelyn
    // surname param with value Kandver
    @GetMapping("/my-name")
    public String myName(@RequestParam(value = "Name", defaultValue = "Jüri") String myFirstName,
                         @RequestParam(value = "surname", defaultValue = "Tamm") String mySurname,
                         Model pageParameters) { //That's a map
        log.info("myName() method was called!!!");
        log.info("my name is: [{}] and my surname is: [{}]", myFirstName, mySurname);
        log.info(String.format("my name is: [%s] and my surname is: [%s]", myFirstName, mySurname));


        pageParameters.addAttribute("myName", myFirstName)
                      .addAttribute("mySurname", mySurname);

        return "pages/name-and-surname";
    }

    @PostMapping("/my-first-post")
    public String myFirstOtherThanGetHttpMethod() {
        log.info("myFirstOtherThanGetHttpMethod() was called");
        return "pages/post-page";
    }
}


//end points are urls given to @GetMapping