package com.sickjumps.rollinish.gui.table;

import com.sickjumps.rollinish.campaign.character.Participant;
import java.util.List;

/**
 *
 * @author Nathan
 */

public class AvailablePlayerTableModel extends PlayerTableModel {

    public AvailablePlayerTableModel(List<Participant> players) {
        super(players);
    }
    
    @Override
    public boolean isCellEditable(int columnIndex, int rowIndex) {
        return false;
    }

}
