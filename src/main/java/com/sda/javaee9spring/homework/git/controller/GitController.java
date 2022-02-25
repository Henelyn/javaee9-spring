package com.sda.javaee9spring.homework.git.controller;

import com.sda.javaee9spring.homework.git.model.GitResponse;
import com.sda.javaee9spring.homework.git.service.GitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Tavaline controller, et kuvada HTML template lehti
@Controller //v'tab päringuid vastu. Meil localhost, mujal serveri IP aadress v nime aadress vms
//Et saaks kuvada logi'sid
@Slf4j
public class GitController {
//Selleks, et Controller saaks kasutada Servicisse antud loogikat, peab selle siin väärtustama
    private final GitService gitService;

    @Autowired
    public GitController(GitService gitService) { //väärtustab GitService klassi
        this.gitService = gitService;
    }

    //@GetMapping ootab GET päringut. Veebilehed on kõik get päringud
    @GetMapping("/show-my-repositories") //Get päring /show-my-repositories
    public String showMyRepositories(Model data) { //See Model data on siin vist Thymeleaf jaoks, et kuvale andmeid edasi anda
        log.info("Retrieving Henelyn Github repositories...");
        //Pöördub GitService klassi meetodi 'getGitRepositories()' poole
        GitResponse[] response = gitService.getGitRepositories();
        //Lisab GitService'ist saadud vastuse Model'isse nimega 'gitResponse', et Thymeleaf saaks seda kasutada
        data.addAttribute("gitResponse", response);
        return "gitHub/repositories"; //Tagastab repositories.html lehe
    }
}
