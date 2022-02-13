package com.sda.javaee9spring.repository;

import com.sda.javaee9spring.entityOrModel.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Spring is going to provide implementation on its own
//Changed CrudRepository to paRepository that extends CrudRepository to have more methods to use.
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {//responsible for data access. CrudRepository is template. need to provide entity(?)
}
