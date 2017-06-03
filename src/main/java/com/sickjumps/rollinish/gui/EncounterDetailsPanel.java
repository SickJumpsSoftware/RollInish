package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.Encounter;
import javax.swing.JPanel;

/**
 *
 * @author Nathan
 */

public class EncounterDetailsPanel extends JPanel {

    private final Encounter encounter;
    
    public EncounterDetailsPanel(Encounter encounter) {
        this.encounter = encounter;
    }
}
