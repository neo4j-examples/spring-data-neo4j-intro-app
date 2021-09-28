package com.neo4j.example.springdataneo4jintroapp.domainClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

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
    private Integer birthYear;

    @JsonIgnoreProperties("person")
    @Relationship(type = "ACTED_IN")
    private List<Movie> actedIn = new ArrayList<>();

    @JsonIgnoreProperties({"actors", "directors"})
    @Relationship(type = "DIRECTED")
    private List<Movie> directed = new ArrayList<>();

    public Person(String name, Integer birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public List<Movie> getActedIn() { return actedIn; }

    public void setActedIn(List<Movie> movies) { this.actedIn = movies; }

    public List<Movie> getDirected() { return directed; }

    public void setDirected(List<Movie> directed) { this.directed = directed; }
}
