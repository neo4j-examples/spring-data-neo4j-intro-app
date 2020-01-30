package com.neo4j.example.springdataneo4jintroapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonIgnoreProperties("person")
    @Relationship(type = "ACTED_IN")
    private List<Role> actedIn = new ArrayList<>();

    @JsonIgnoreProperties({"actors", "directors"})
    @Relationship(type = "DIRECTED")
    private List<Movie> directed = new ArrayList<>();

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

    public List<Role> getActedIn() { return actedIn; }

    public void setActedIn(List<Role> movies) { this.actedIn = actedIn; }

    public List<Movie> getDirected() { return directed; }

    public void setDirected(List<Movie> directed) { this.directed = directed; }
}
