package org.woehlke.humanrights.digital.defense.defcon1.config.helper;

import java.util.List;

/**
 * @author Natural-Born-Coder
 */
public interface Neo4jConfigurationLogger {

    List<String> configurationLogger(org.neo4j.ogm.config.Configuration configuration);
}
