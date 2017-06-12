package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.Encounter;
import com.sickjumps.rollinish.campaign.character.Participant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author Nathan
 */

public class EncounterPaneTest {

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
        encounters.stream().map((e) -> {
            e.setActive(activePlayers);
            return e;
        }).forEach((e) -> {
            e.setAvailable(availablePlayers);
        });
    }
    
    public static void main(String... args) {
        JFrame frame = new JFrame("Encounter pane test");
        JScrollPane scrollPane = new JScrollPane();
        
        scrollPane.setViewportView(PaneCreator.createEncounterPane(encounters));
        frame.getContentPane().add(scrollPane);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
