package com.sda.javaee9spring.entityOrModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PERSON_ENTITIES")
@Data //from lombok. Almost like record but provides also setters
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //database will prepare for us that key (id)
    private Long id;
    private String name;
    private String surname;
    private int age;


}
