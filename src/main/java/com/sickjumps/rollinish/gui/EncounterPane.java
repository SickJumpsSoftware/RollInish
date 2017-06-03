package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.Encounter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Nathan
 */

public class EncounterPane extends JPanel {

    private final List<Encounter> encounters;
    private final Map<String, EncounterDetailsPanel> encounterMap;
    
    public EncounterPane(List<Encounter> encounters) {
        this.encounters = encounters;
        this.encounterMap = new HashMap<>();
        
        this.initializeComponents();
        
        
    }
    
    private void initializeComponents() {
        this.initializeEncountersPane();
        this.initializeLeftButtonPanel();
        this.initializeRightButtonPanel();
        
        this.setLayout(new FlowLayout());
        
        this.add(leftButtonPanel);
        this.add(encountersPane);
        this.add(rightButtonPanel);
        
        
    }
    
    private void initializeEncountersPane() {
        this.encountersPane = new JTabbedPane();
        
        for (Encounter e : this.encounters) {
            EncounterDetailsPanel panel = new EncounterDetailsPanel(e);
            
            this.encountersPane.addTab(e.getEncounterName(), panel);
            
            this.encounterMap.put(e.getEncounterName(), panel);
        }
    }
    
    private void initializeLeftButtonPanel() {
        this.leftButtonPanel = new JPanel();
        this.btnAddPlayer = new JButton("Add Player");
        this.btnRemovePlayer = new JButton("Remove Player");
        
        this.btnAddPlayer.setMinimumSize(new Dimension(90, 90));
        this.btnRemovePlayer.setMinimumSize(new Dimension(90, 90));
        
        this.leftButtonPanel.setLayout(new BoxLayout(leftButtonPanel, BoxLayout.PAGE_AXIS));
        this.leftButtonPanel.add(this.btnAddPlayer);
        this.leftButtonPanel.add(this.btnRemovePlayer);
        
        this.leftButtonPanel.setMinimumSize(new Dimension(125, 0));
        this.leftButtonPanel.setMaximumSize(this.leftButtonPanel.getMinimumSize());
        this.leftButtonPanel.setPreferredSize(this.leftButtonPanel.getMinimumSize());
        
        this.leftButtonPanel.setBorder(new LineBorder(new Color(255, 255, 255)));
    }
    
    private void initializeRightButtonPanel() {
        this.rightButtonPanel = new JPanel();
        this.rightButtonPanel.setMinimumSize(new Dimension(125, 0));
        
        this.rightButtonPanel.setBorder(new LineBorder(new Color(255, 255, 255)));
    }
    
    private JTabbedPane encountersPane;
    private JPanel leftButtonPanel;
    private JPanel rightButtonPanel;
    
    // left buttons
    private JButton btnAddPlayer;
    private JButton btnRemovePlayer;
    
    // right buttons
    private JButton btnRemoveParticipant;
    private JButton btnNextTurn;
}
