package org.woehlke.humanrights.digital.defense.defcon1.storage.neo4j.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.humanrights.digital.defense.defcon1.storage.neo4j.domain.Actor;

/**
 * Created by tw on 15.07.18.
 */
@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long> {
}
