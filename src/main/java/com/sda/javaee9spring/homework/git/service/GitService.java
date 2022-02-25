package com.sda.javaee9spring.homework.git.service;

import com.sda.javaee9spring.homework.git.model.GitResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GitService {

    //Klient, mille kaudu saab teha erinevaid päringuid "api.github.com" suunas
    WebClient client = WebClient.create("https://api.github.com");

    //meetod, mis tagastab meile GitResponse massiivi vastuse
    public GitResponse[] getGitRepositories() {
        //Kasutab client'it, et teha GET päring antud sisestatud URI vastu.
        //Retrieve() saadab päringu teele.
        //bodyToMono() mapib saadud vastuse GitResponse klassi (kuna vastuseid on mitu, siis paneb need massiivi).
        //Block() tähendab, et ootab ära GitHubist tulnud vastuse, hoiab seni seda protsessi kinni kuni vastus on käes.
        return client.get()
                .uri("/users/henelyn/repos")
                .retrieve()//Saab vastuse
                .bodyToMono(GitResponse[].class)//teeb array talle ette antud klassiks
                .block();
    }
}
