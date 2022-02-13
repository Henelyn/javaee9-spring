package com.sda.javaee9spring.repository;

import com.sda.javaee9spring.entityOrModel.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Spring is going to provide implementation on its own
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {//responsible for data access. CrudRepository is template. need to provide entity(?)
}
