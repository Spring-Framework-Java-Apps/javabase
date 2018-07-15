package org.woehlke.humanrights.digital.defense.defcon1.config.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by tw on 23.06.18.
 */
@Component
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        LOGGER.info(" ");
        LOGGER.info("================================ ");
        LOGGER.info("===== Application Started ====== ");
        LOGGER.info("================================ ");
        LOGGER.info(" ");
    }

    private static final Log LOGGER = LogFactory.getLog(ApplicationStartedListener.class);

}
