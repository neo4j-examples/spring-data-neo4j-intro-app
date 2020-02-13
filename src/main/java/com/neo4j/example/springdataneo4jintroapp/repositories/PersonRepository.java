package com.neo4j.example.springdataneo4jintroapp.repositories;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author Jennifer Reif
 */
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Person getPersonByName(String name);

    Iterable<Person> findPersonByNameLike(String name);
}
