package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.Campaign;
import com.sickjumps.rollinish.campaign.Encounter;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Nathan
 */


public class CampaignViewerFrameTest {
    
    private final static List<Encounter> testEncounters = Arrays.asList(new Encounter[] {
        new Encounter("Test Encounter 1"),
        new Encounter("Test Encounter 2"),
        new Encounter("Test Encounter 3"),
        new Encounter("Test Encounter 4"),
        new Encounter("Test Encounter 5")
    });

    public static void main(String[] args) {
        Campaign campaign = mock(Campaign.class);
        
        when(campaign.getCampaignName()).thenReturn("Test Campaign");
        when(campaign.getEncounters()).thenReturn(testEncounters);
        
        CampaignViewerFrame frame = new CampaignViewerFrame(campaign);
        frame.setVisible(true);
    }
}
