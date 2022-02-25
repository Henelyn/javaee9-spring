package com.sda.javaee9spring.homework.git.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//Tavaline Java objekt, mida kasutame, et JSON vastus siia ümber mappida.
public record GitResponse(Long id,
                          //Kui muutuja nimi on sama, mis JSON'is, siis ta oskab selle kohe ära mappida
                          String name,
                          //Kui muutuja nimi on teistsugune JSON'is kui siin, siis peame kasutama sellist annotatsiooni.
                          //See ütleb, et url mapi JSON vastusest "html_url".
                         @JsonProperty("html_url")
                          String url,
                          @JsonProperty("private")
                          Boolean available) { //Suure tähega Boolean, et väärtus saaks olla null. primitiiv ei saa null olla
}
