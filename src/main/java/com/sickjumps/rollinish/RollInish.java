package com.sickjumps.rollinish;

import com.sickjumps.rollinish.campaign.Campaign;
import com.sickjumps.rollinish.campaign.DefaultCampaign;
import com.sickjumps.rollinish.campaign.character.Monster;
import com.sickjumps.rollinish.campaign.designer.CampaignDesigner;
import com.sickjumps.rollinish.campaign.io.CampaignSerializer;
import com.sickjumps.rollinish.campaign.io.MonsterDataParser;
import com.sickjumps.rollinish.gui.ApplicationStartDialog;
import com.sickjumps.rollinish.gui.CampaignViewerFrame;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */
public final class RollInish {

    private final static Logger logger = LoggerFactory.getLogger(RollInish.class);

    public static void main(String[] args) {
        logger.info("RollInish v0.1a");
        RollInish app = new RollInish();

        logger.info("Logging is live");

        logger.info("Loading application configuration");
        final ApplicationConfiguration config = new ApplicationConfiguration();

        logger.info("Loading monster data");
        List<Monster> monsterData = app.loadMonsterData();
        
        logger.info("Setting Look&Feel");
        try {
            UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ulafe) {
            logger.debug("Nimbus L&F unsupported, reverting to default");
        }

        SwingUtilities.invokeLater(() -> {
            Campaign c;

            logger.info("Create and show application start dialog");
            ApplicationStartDialog start = new ApplicationStartDialog();
            ApplicationStartDialog.ApplicationChoice choice = start.getResult();

            if (choice.equals(ApplicationStartDialog.ApplicationChoice.LOAD)) {
                logger.info("Load existing campaign");
                c = app.loadExistingCampaign(config);
            } else {
                logger.info("Create new campaign");
                c = app.createNewCampaign(config);
            }

            logger.info("Starting main GUI");
            CampaignViewerFrame cvf = new CampaignViewerFrame(c, monsterData);
            cvf.setVisible(true);
        });
    }

    private List<Monster> loadMonsterData() {
        List<Monster> monsterData = new ArrayList<>();

        try (InputStream is = RollInish.class.getClassLoader().getResourceAsStream("monsters.csv")) {
            monsterData.addAll(MonsterDataParser.getMonsterData(is));
        } catch (IOException ex) {
            logger.error("Unable to parse monster data from CSV", ex);
        }

        return monsterData;
    }

    private Campaign loadExistingCampaign(ApplicationConfiguration config) {
        String saveDirectory = config.getLastCampaignSaveDirectory();
        if (saveDirectory.isEmpty()) {
            saveDirectory = config.getDefaultCampaignSaveDirectory();
        }

        final JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(saveDirectory));
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = jfc.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();

            return CampaignSerializer.load(f);
        } else {
            return new DefaultCampaign();
        }
    }

    private Campaign createNewCampaign(ApplicationConfiguration config) {
        CampaignDesigner designer = new CampaignDesigner(config);

        return designer.getResult();
    }
}
