package com.neo4j.example.springdataneo4jintroapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

/**
 * @author Jennifer Reif
 */
@NodeEntity
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private int released;
    @Property("tagline")
    private String description;

    @JsonIgnoreProperties("movie")
    @Relationship(type = "ACTED_IN", direction = INCOMING)
    private List<Role> actors = new ArrayList<>();

    @JsonIgnoreProperties({"actedIn", "directed"})
    @Relationship(type = "DIRECTED", direction = INCOMING)
    private List<Person> directors = new ArrayList<>();

    public Movie() {
    }

    public Movie(String title, int released, String tagline) {
        this.title = title;
        this.released = released;
        this.description = tagline;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public List<Role> getActors() { return actors; }

    public void setActors(List<Role> actors) { this.actors = actors; }

    public List<Person> getDirectors() { return directors; }

    public void setDirectors(List<Person> directors) { this.directors = directors; }
}
