package com.sickjumps.rollinish.gui.table;

import ca.odell.glazedlists.gui.TableFormat;
import com.sickjumps.rollinish.campaign.character.Participant;

/**
 *
 * @author Nathan
 */
public class PlayerTableFormat implements TableFormat<Participant> {

    private final String[] columnNames = new String[]{"Character Name", "Player Name", "Initiative"};

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    @Override
    public Object getColumnValue(Participant baseObject, int column) {
        switch (column) {
            case 0:
                return baseObject.getCharacterName();
            case 1:
                return baseObject.getPlayerName();
            case 2:
                return baseObject.getInitiative();
            default:
                throw new IndexOutOfBoundsException("Column index out of bounds");
        }
    }
}
