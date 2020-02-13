package com.neo4j.example.springdataneo4jintroapp.repositories;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author Jennifer Reif
 */
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    Movie getMovieByTitle(String title);

    Iterable<Movie> findMovieByTitleLike(String title);
}
