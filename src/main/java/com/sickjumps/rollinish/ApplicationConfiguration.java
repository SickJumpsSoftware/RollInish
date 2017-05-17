package com.sickjumps.rollinish;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */

public class ApplicationConfiguration {

    private final static Properties configuration = new Properties();
    private final static Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);
    
    public ApplicationConfiguration() {
        if (configuration.isEmpty()) {
            try (FileInputStream fis = new FileInputStream("application.properties")) {
                configuration.load(fis);
            } catch (IOException ex) {
                logger.error("Unable to load application configuration", ex);
            }
        }
    }
}
