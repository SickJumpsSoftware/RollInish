package com.sickjumps.rollinish.gui.table;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.swing.DefaultEventTableModel;
import com.sickjumps.rollinish.campaign.character.Monster;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nathan
 */

public class MonsterTableModel extends DefaultEventTableModel<Monster> implements RowObjectTableModel<Monster> {
    
    private final List<Monster> monsterList;

    public MonsterTableModel(EventList<Monster> source, TableFormat<Monster> tableFormat) {
        super(source, tableFormat);
        this.monsterList = source;
    }

    @Override
    public Monster getRow(int rowIndex) {
        return this.monsterList.get(rowIndex);
    }

    @Override
    public List<Monster> getRows(int... rows) {
        List<Monster> rowList = new ArrayList<>();
        
        for (int i : rows) {
            rowList.add(this.monsterList.get(i));
        }
        
        return rowList;
    }

    @Override
    public void addRow(Monster t) {
        this.monsterList.add(t);
        super.fireTableDataChanged();
    }

    @Override
    public void insertRow(Monster t, int rowIndex) {
        this.monsterList.add(rowIndex, t);
        super.fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        this.monsterList.remove(rowIndex);
        super.fireTableDataChanged();
    }
    
    @Override
    public void removeAllRows() {
        this.monsterList.clear();
    }
}
