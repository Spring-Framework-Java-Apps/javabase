package org.woehlke.humanrights.digital.defense.defcon1.storage.neo4j.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woehlke.humanrights.digital.defense.defcon1.storage.neo4j.repository.ActorRepository;
import org.woehlke.humanrights.digital.defense.defcon1.storage.neo4j.services.ActorService;

/**
 * Created by tw on 15.07.18.
 */
@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
}
