package com.sickjumps.rollinish;

import com.sickjumps.rollinish.gui.NewCampaignDialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */

public class RollInish {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(RollInish.class);

    public static void main(String[] args) {
        System.setProperty("java.util.logging.config.file", "logging.properties");
        
        LOGGER.info("Successfully configured logging.");
        new NewCampaignDialog(null, false).getResult();
    }
}
