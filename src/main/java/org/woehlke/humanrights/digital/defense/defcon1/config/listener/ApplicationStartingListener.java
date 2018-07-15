package org.woehlke.humanrights.digital.defense.defcon1.config.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by tw on 24.06.18.
 */
@Component
public class ApplicationStartingListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        LOGGER.info(" ");
        LOGGER.info("================================ ");
        LOGGER.info("===== Application Starting ===== ");
        LOGGER.info("================================ ");
        LOGGER.info(" ");
    }

    private static final Log LOGGER = LogFactory.getLog(ApplicationStartingListener.class);
}
