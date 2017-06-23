package com.sickjumps.rollinish.gui;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import com.sickjumps.rollinish.campaign.Campaign;
import com.sickjumps.rollinish.campaign.character.Monster;
import com.sickjumps.rollinish.campaign.io.MonsterDataParser;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author Nathan
 */
public class CampaignViewerFrameTest {

    private final static EventList<Monster> testMonsters = new BasicEventList();

    static {
        InputStream is = CampaignViewerFrameTest.class.getClassLoader().getResourceAsStream("monsters.csv");
        testMonsters.addAll(MonsterDataParser.getMonsterData(is));
    }

    public static void main(String[] args) {
        Campaign campaign = new Campaign("Test campaign");

        CampaignViewerFrame frame = new CampaignViewerFrame(campaign, new ArrayList<>(testMonsters));
        frame.setVisible(true);
    }
}
