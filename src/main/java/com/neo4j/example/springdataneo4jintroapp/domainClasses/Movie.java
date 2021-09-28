package com.neo4j.example.springdataneo4jintroapp.domainClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;


/**
 * @author Jennifer Reif
 */
@Node
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

    public Movie(String title, int released, String description) {
        this.title = title;
        this.released = released;
        this.description = description;
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
