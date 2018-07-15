package org.woehlke.humanrights.digital.defense.defcon1.config.properties;

/**
 * Created by tw on 23.06.18.
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author Natural-Born-Coder
 */
@Component
@Validated
@ConfigurationProperties
public class AllProperties {

    @NonNull
    @Value("${spring.application.name}")
    private String springApplicationName;

    public String getSpringApplicationName() {
        return springApplicationName;
    }

    public void setSpringApplicationName(String springApplicationName) {
        this.springApplicationName = springApplicationName;
    }

    public void logDebug(){
        LOGGER.debug("-------------------------------------------------------------");
        LOGGER.debug("   spring.application.name = " + this.springApplicationName + " ");
        LOGGER.debug("-------------------------------------------------------------");
    }

    private static final Log LOGGER = LogFactory.getLog(AllProperties.class);
}
