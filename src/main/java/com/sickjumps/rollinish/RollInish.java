package com.sickjumps.rollinish;

import com.sickjumps.rollinish.campaign.Campaign;
import com.sickjumps.rollinish.campaign.CampaignManager;
import com.sickjumps.rollinish.gui.CampaignFrame;
import com.sickjumps.rollinish.gui.EncounterPanelFactory;
import com.sickjumps.rollinish.gui.StartDialog;
import com.sickjumps.rollinish.io.CampaignSerializer;
import com.sickjumps.rollinish.io.DateBasedNamingStrategy;
import com.sickjumps.rollinish.log.CampaignLogManager;
import javax.swing.SwingUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */
public class RollInish {

    private final static Logger LOGGER = LoggerFactory.getLogger(RollInish.class);
    private static ApplicationConfiguration configuration;

    public static void main(String[] args) {

        LOGGER.info("Initializing application configuration");
        configuration = new ApplicationConfiguration();
        configuration.setDefaultCampaignSaveDirectory(System.getProperty("user.home"));

        LOGGER.info("Initialize campaign manager");
        CampaignManager cm = new CampaignManager(configuration, new CampaignSerializer(), new DateBasedNamingStrategy());

        LOGGER.info("Create PanelFactory");
        EncounterPanelFactory factory = new EncounterPanelFactory();

        LOGGER.info("Spin up turn log manager");
        CampaignLogManager manager = CampaignLogManager.instance();

        LOGGER.info("Start GUI");
        SwingUtilities.invokeLater(() -> {
            LOGGER.info("Show start dialog");
            Campaign c = new StartDialog(null, true, cm, configuration).getResult();

            LOGGER.info("Show main campaign frame");
            CampaignFrame frame = new CampaignFrame(c, manager, factory);

            frame.setVisible(true);
        });
    }
}
