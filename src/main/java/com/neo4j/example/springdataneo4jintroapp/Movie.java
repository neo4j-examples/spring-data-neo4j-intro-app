package com.neo4j.example.springdataneo4jintroapp;

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

    @Relationship(type = "ACTED_IN", direction = INCOMING)
    private List<Person> actors = new ArrayList<>();

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

    public List<Person> getActors() { return actors; }

    public void setActors(List<Person> actors) { this.actors = actors; }
}
