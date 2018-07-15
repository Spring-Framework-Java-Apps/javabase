package org.woehlke.humanrights.digital.defense.defcon1.config.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by tw on 24.06.18.
 */
@Component
public class ApplicationFailedListener implements ApplicationListener<ApplicationFailedEvent> {

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        LOGGER.info(" ");
        LOGGER.info("================================ ");
        LOGGER.info("===== Application Failed ======= ");
        LOGGER.info("================================ ");
        LOGGER.info(" ");
    }

    private static final Log LOGGER = LogFactory.getLog(ApplicationFailedListener.class);
}
