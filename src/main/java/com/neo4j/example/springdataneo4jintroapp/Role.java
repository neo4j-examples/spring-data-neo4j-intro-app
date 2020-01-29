package com.neo4j.example.springdataneo4jintroapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RelationshipEntity(type = "ACTED_IN")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private List<String> roles = new ArrayList<>();

    @StartNode
    @JsonIgnoreProperties("acted")
    private Person person;

    @EndNode
    @JsonIgnoreProperties("characters")
    private Movie movie;

    public Role() {
    }

    public Role(Person person, Movie movie) {
        this.person = person;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public Person getPerson() {
        return person;
    }

    public Movie getMovie() {
        return movie;
    }
}
