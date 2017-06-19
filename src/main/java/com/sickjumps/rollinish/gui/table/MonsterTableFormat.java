package com.sickjumps.rollinish.gui.table;

import ca.odell.glazedlists.gui.TableFormat;
import com.sickjumps.rollinish.campaign.character.Monster;

/**
 *
 * @author Nathan
 */

public class MonsterTableFormat implements TableFormat<Monster> {
    
    private final String[] columnNames = new String[] { "Name", "Size", "Type", "Tags", "Alignment", "XP", "Source" };

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    @Override
    public Object getColumnValue(Monster baseObject, int column) {
        switch (column) {
            case 0:
                return baseObject.getName();
            case 1:
                return baseObject.getSize();
            case 2:
                return baseObject.getType();
            case 3:
                return baseObject.getTag();
            case 4:
                return baseObject.getAlignment();
            case 5:
                return baseObject.getXp();
            case 6:
                return baseObject.getSource();
            default:
                throw new IndexOutOfBoundsException("Column index out of bounds");
        }
    }
}
