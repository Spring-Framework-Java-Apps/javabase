package org.woehlke.humanrights.digital.defense.defcon1.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.ogm.driver.Driver;
import org.neo4j.ogm.drivers.embedded.driver.EmbeddedDriver;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.woehlke.humanrights.digital.defense.defcon1.config.helper.Neo4jConfigurationLogger;

import java.io.File;
import java.util.List;


/**
 * @author Natural-Born-Coder
 */
@Configuration
@Profile({
    "default",
    "devembedded",
    "intembedded",
    "testembedded",
    "prodembedded",
    "travisembedded"
})
public class StorageConfigurationEmbedded {

    private final String packages[] = { "org.woehlke.neo4j.example.storage.neo4j.domain" };

	private final String graphDbFileName  = "target/var/graphDb";


    @Bean
    public Driver neo4jDriver() {
        //storageProperties.logDebug();
        //allProperties.logDebug();
        LOGGER.debug("   Neo4J Driver Configuration = Embedded : " + this.graphDbFileName + " ");
        LOGGER.debug("-------------------------------------------------------------");
        File db = new File( graphDbFileName );
        GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( db );
        Driver neo4jDriver = new EmbeddedDriver(graphDb);
        if (neo4jDriver == null) {
            LOGGER.error("");
            LOGGER.error("-------------------------------------------------------------");
            LOGGER.error("   driver == null                                            ");
            LOGGER.error("-------------------------------------------------------------");
            LOGGER.error("");
        } else {
            org.neo4j.ogm.config.Configuration configuration = neo4jDriver.getConfiguration();
            if(configuration != null){
                List<String> logInfos = neo4jConfigurationLogger.configurationLogger(configuration);
                for (String logInfo:logInfos) {
                    LOGGER.debug(logInfo);
                }
            }
        }
        return neo4jDriver;
    }

    @Bean
	public SessionFactory sessionFactory(Driver neo4jDriver) {
        return new SessionFactory(neo4jDriver , packages );
	}



    @Autowired
    private Neo4jConfigurationLogger neo4jConfigurationLogger;

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
    private Neo4jProperties neo4jProperties;


    private static final Log LOGGER = LogFactory.getLog(StorageConfigurationEmbedded.class);
}
