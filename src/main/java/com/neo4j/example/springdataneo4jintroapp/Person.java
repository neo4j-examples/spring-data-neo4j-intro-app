package com.neo4j.example.springdataneo4jintroapp;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jennifer Reif
 */
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Property("born")
    private int birthyear;

    @Relationship(type = "ACTED_IN")
    private List<Movie> movies = new ArrayList<>();

    public Person() {
    }

    public Person(String name, int birthyear) {
        this.name = name;
        this.birthyear = birthyear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public List<Movie> getMovies() { return movies; }

    public void setMovies(List<Movie> movies) { this.movies = movies; }
}
