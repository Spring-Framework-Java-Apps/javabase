package org.woehlke.humanrights.digital.defense.defcon1.config;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * @author Natural-Born-Coder
 *
 * TODO: #38
 */
@Configuration
@Profile({
    "dev",
    "int",
    "test",
    "prod",
    "travis"
})
@EnableConfigurationProperties({
    JpaProperties.class,
    Neo4jProperties.class,
    DataSourceProperties.class
})
public class StorageConfigurationDistributed {


    private final String packages[] = {
        "org.woehlke.humanrights.digital.defense.defcon1.storage.neo4j.domain"
    };


    @Bean
    public org.neo4j.ogm.config.Configuration configuration(Neo4jProperties neo4jProperties) {
        return neo4jProperties.createConfiguration();
    }

    @Bean
	public SessionFactory sessionFactory(org.neo4j.ogm.config.Configuration configuration ) {
        return new SessionFactory(configuration,packages);
	}

	private static final Log LOGGER = LogFactory.getLog(StorageConfigurationDistributed.class);

}
