package org.woehlke.humanrights.digital.defense.defcon1.storage.neo4j.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woehlke.humanrights.digital.defense.defcon1.storage.neo4j.repository.MovieRepository;
import org.woehlke.humanrights.digital.defense.defcon1.storage.neo4j.services.MovieService;

/**
 * Created by tw on 15.07.18.
 */
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
}
