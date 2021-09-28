package com.neo4j.example.springdataneo4jintroapp.domainClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.ArrayList;
import java.util.List;

@RelationshipProperties
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private List<String> roles = new ArrayList<>();

    @TargetNode
    @JsonIgnoreProperties({"actedIn", "directed"})
    private Person person;

    public Long getId() {
        return id;
    }

    public List<String> getRoles() { return roles; }

    public Person getPerson() {
        return person;
    }

}
