package com.sickjumps.rollinish.gui.table;

import com.sickjumps.rollinish.campaign.character.Monster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nathan
 */

public class MonsterTableModel extends AbstractTableModel implements RowObjectTableModel<Monster> {
    
    private final List<Monster> monsters;
    private final List<String> headers;
    
    public MonsterTableModel(List<Monster> monsters) {
        this.monsters = monsters;
        headers = new ArrayList<>(Arrays.asList( new String[] { "Name", "Size", "Type", "Tags", "Alignment", "XP", "Source" } ));
    }

    @Override
    public int getRowCount() {
        return this.monsters.size();
    }

    @Override
    public int getColumnCount() {
        return this.headers.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.headers.get(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Monster m = this.monsters.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return m.getName();
            case 1:
                return m.getSize().toString();
            case 2:
                return m.getType().toString();
            case 3:
                return m.getTag();
            case 4:
                return m.getAlignment().toString();
            case 5:
                return m.getXp();
            case 6:
                return m.getSource();
            default:
                throw new IndexOutOfBoundsException("Column index: " + columnIndex);
        }
    }

    @Override
    public Monster getRow(int rowIndex) {
        return this.monsters.get(rowIndex);
    }
    
    @Override
    public List<Monster> getRows(int... rows) {
        List<Monster> monsterList = new ArrayList<>();
        
        for (int row : rows) {
            monsterList.add(this.monsters.get(row));
        }
        
        return monsterList;
    }

    @Override
    public void addRow(Monster t) {
        this.monsters.add(t);
        super.fireTableDataChanged();
    }

    @Override
    public void insertRow(Monster t, int rowIndex) {
        this.monsters.add(rowIndex, t);
        super.fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        this.monsters.remove(rowIndex);
        super.fireTableDataChanged();
    }
}
