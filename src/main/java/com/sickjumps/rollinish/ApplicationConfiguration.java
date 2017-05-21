package com.sickjumps.rollinish;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        InputStream properties = ApplicationConfiguration.class.getClassLoader().getResourceAsStream("application.properties");
        
        if (configuration.isEmpty()) {
            try {
                configuration.load(properties);
            } catch (IOException ex) {
                logger.debug("Unable to load application configuration:", ex);
            }
        }
        
        logger.trace("configuration now contains: {}", configuration);
    }
    
    public Path getLastOrDefaultCampaignSaveDirectory() {
        logger.trace("entering getLastCampaignSaveDirectory");
        String path = configuration.getProperty("campaign.last_save_dir", configuration.getProperty("campaign.default_save_dir"));
        
        return Paths.get(path);
    }
    
    public void setLastCampaignSaveDirectory(Path directory) {
        logger.trace("entering setLastCampaignSaveDirectory, directory = {}", directory);
        
        String path = directory.toAbsolutePath().toString();
        configuration.setProperty("campaign.last_save_dir", path);
        
        flushConfiguration();
        
        logger.trace("exiting setLastCampaignSaveDirectory");
    }
    
    public void setLastCampaignName(String name) {
        logger.trace("entering setLastCampaignName, name = {}", name);
        
        configuration.setProperty("campaign.last_played", name);
        
        flushConfiguration();
        
        logger.trace("exiting setLastCampaignName");
    }
    
    void setDefaultCampaignSaveDirectory(String directory) {
        logger.trace("entering setDefaultCampaignSaveDirectory, directory = {}", directory);
        
        configuration.setProperty("campaign.default_save_dir", directory);
        
        flushConfiguration();
        
        logger.trace("exiting setDefaultCampaignSaveDirectory");
    }
    
    private void flushConfiguration() {
        
        try (FileOutputStream fos = new FileOutputStream("")) {
            configuration.store(fos, "");
        } catch (IOException ex) {
            logger.error("Error writing configuration, properties file may not match current configuration", ex);
        }
    }
}
