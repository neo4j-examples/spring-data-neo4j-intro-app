package com.neo4j.example.springdataneo4jintroapp.repositories;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

/**
 * @author Jennifer Reif
 */
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Person getPersonByName(String name);

    Iterable<Person> findPersonByNameLike(String name);

    @Query("MATCH (am:Movie)<-[ai:ACTED_IN]-(p:Person)-[d:DIRECTED]->(dm:Movie) " + 
            "RETURN p, collect(ai), collect(d), collect(am), collect(dm);")
    List<Person> getPersonsWhoActAndDirect();
}
