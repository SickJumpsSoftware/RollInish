package com.sickjumps.rollinish.gui;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import com.sickjumps.rollinish.campaign.Campaign;
import com.sickjumps.rollinish.campaign.character.Monster;
import com.sickjumps.rollinish.campaign.io.MonsterDataParser;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */
public class CampaignViewerFrameTest {

    private final static EventList<Monster> testMonsters = new BasicEventList();
    private final static Logger logger = LoggerFactory.getLogger(CampaignViewerFrameTest.class);

    static {
        InputStream is = CampaignViewerFrameTest.class.getClassLoader().getResourceAsStream("monsters.csv");
        testMonsters.addAll(MonsterDataParser.getMonsterData(is));
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ulafe) {
            logger.debug("Nimbus L&F unsupported, reverting to default");
        }
        
        Campaign campaign = new Campaign("Test campaign");

        CampaignViewerFrame frame = new CampaignViewerFrame(campaign, new ArrayList<>(testMonsters));
        frame.setVisible(true);
    }
}
