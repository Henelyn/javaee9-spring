package com.sda.javaee9spring.repository;

import com.sda.javaee9spring.entityOrModel.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository //Spring is going to provide implementation on its own
//Changed CrudRepository to paRepository that extends CrudRepository to have more methods to use.
//responsible for data access. CrudRepository is template. need to provide entity(?)
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {


    //based on the name of that method spring is going to build SQL Query for us
    //Spring is using class properties to build the query: like name, surname, id or age
    //use it only for simple/short(method names) cases. Otherwise, @query is better idea
    boolean existsByNameAndSurname(String name, String surname); //doing the same thing as @Query (for complicated and long sql queris


    //we can provide our own query and spring with hibernate is going to use it.
    //it's very useful for longer queries
    // we've got two options here:
    //1. using native sql (with native query set to true) or JPQL (with native query set to false)
    //JPQL is Java Persistence Query Language -subset of sql
    @Query(value = """
    SELECT COUNT(*) > 0
    FROM PERSON_ENTITIES
    WHERE name = :name AND surname = :surname
    """,
            nativeQuery = true)
    boolean checkDuplicates(String name, String surname);
}
