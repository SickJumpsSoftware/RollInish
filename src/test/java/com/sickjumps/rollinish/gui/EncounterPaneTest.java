package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.Campaign;
import com.sickjumps.rollinish.campaign.Encounter;
import com.sickjumps.rollinish.campaign.character.Participant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Nathan
 */

public class EncounterPaneTest {
    
    private final static Campaign c = new Campaign("test campaign");

    private final static List<Encounter> encounters = new ArrayList<>(
        Arrays.asList( 
            new Encounter[] {
                new Encounter("test encounter 1"),
                new Encounter("test encounter 2"),
                new Encounter("test encounter 3"),
                new Encounter("test encounter 4")
            }
        )
    );
    
    private final static List<Participant> availablePlayers = new ArrayList<>(
        Arrays.asList(
            new Participant[] {
                new Participant("beshenid jasarkam", "nathan", 1),
                new Participant("matthas", "eddie", 0),
                new Participant("jeremiah breeze", "jake", 3),
                new Participant("memaw", "jordan", 1)
            }
        )
    );
    
    private final static List<Participant> activePlayers = new ArrayList<>();
    
    static {
        c.setAvailable(availablePlayers);
        encounters.stream().forEach(e -> e.setActive(activePlayers));
    }
    
    public static void main(String... args) {
        JFrame frame = new JFrame("Encounter pane test");
        JPanel panel = new JPanel();
        
        JTabbedPane encounterPane = PaneCreator.createEncounterTabbedPane(c);
        encounterPane.setPreferredSize(panel.getSize());
        
        panel.add(encounterPane);
        frame.add(panel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
