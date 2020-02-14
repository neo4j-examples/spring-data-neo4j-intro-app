package com.neo4j.example.springdataneo4jintroapp.controllers;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Person;
import com.neo4j.example.springdataneo4jintroapp.repositories.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Iterable<Person> findAllPersons() { return personRepository.findAll(); }

    @GetMapping("/{name}")
    public Person getPersonByName(@PathVariable String name) {
        return personRepository.getPersonByName(name);
    }

    @GetMapping("/search/{name}")
    public Iterable<Person> findPersonByNameLike(@PathVariable String name) {
        return personRepository.findPersonByNameLike(name);
    }

    @GetMapping("/actanddirect")
    public List<Person> getPersonsWhoActAndDirect() {
        return personRepository.getPersonsWhoActAndDirect();
    }
}
