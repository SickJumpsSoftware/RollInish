package com.sickjumps.rollinish;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.prefs.Preferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */

public class ApplicationConfiguration {
    private final Preferences configuration;
    private final static Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);
    
    public ApplicationConfiguration() {
        logger.trace("empty constructor");
        configuration = Preferences.userRoot().node(this.getClass().getName());
    }
    
    public String getLastCampaignSaveDirectory() {
        logger.trace("entering getLastCampaignSaveDirectory");
        
        String path = configuration.get("campaign.last_save_dir", "");
        logger.debug("found last campaign save directory: {}", path);
        
        return path;
    }
    
    public void setLastCampaignSaveDirectory(Path directory) {
        logger.trace("entering setLastCampaignSaveDirectory, directory = {}", directory);
        
        String path = directory.toAbsolutePath().toString();
        configuration.put("campaign.last_save_dir", path);
        
        logger.trace("exiting setLastCampaignSaveDirectory");
    }
    
    public String getDefaultCampaignSaveDirectory() {
        logger.trace("entering getDefaultCampaignSaveDirectory");
        
        String path = configuration.get("campaign.default_save_dir", "");
        logger.debug("found default campaign save directory: {}", path);
        
        return path;
    }
    
    public void setDefaultCampaignSaveDirectory(String directory) {
        logger.trace("entering setDefaultCampaignSaveDirectory, directory = {}", directory);
        
        configuration.put("campaign.default_save_dir", directory);
        
        logger.trace("exiting setDefaultCampaignSaveDirectory");
    }
    
    public String getLastCampaignName() {
        logger.trace("entering getLastCampaignName");
        
        String name = configuration.get("campaign.most_recent_name", "");
        if (name.isEmpty()) {
            logger.debug("no recent campaign found, returning empty string");
        } else {
            logger.debug("found last campaign name: {}", name);
        }
        
        return name;
    }
    
    public void setLastCampaignName(String name) {
        logger.trace("entering setLastCampaignName, name = {}", name);
        
        configuration.put("campaign.last_played", name);
        
        logger.trace("exiting setLastCampaignName");
    }
}
