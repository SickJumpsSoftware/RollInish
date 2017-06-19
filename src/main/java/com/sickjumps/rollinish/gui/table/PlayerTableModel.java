package com.sickjumps.rollinish.gui.table;

import com.sickjumps.rollinish.campaign.character.Participant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nathan
 */

public class PlayerTableModel extends AbstractTableModel implements RowObjectTableModel<Participant> {
    
    private final List<String> headers;
    private final List<Participant> players;
    
    public PlayerTableModel(List<Participant> players) {
        this.players = players;
        this.headers = new ArrayList<>( Arrays.asList(new String[] {"Character Name", "Player Name", "Initiative"}));
    }

    @Override
    public int getRowCount() {
        return this.players.size();
    }

    @Override
    public int getColumnCount() {
        return this.headers.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Participant p = this.players.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getCharacterName();
            case 1:
                return p.getPlayerName();
            case 2:
                return p.getInitiative();
            default:
                throw new IndexOutOfBoundsException("Column index out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex == 2);
    }
    
    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        if (!this.isCellEditable(rowIndex, columnIndex)) return;
        
        int value = (int) o;
        this.players.get(rowIndex).setInitiative(value);
        super.fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.headers.get(columnIndex);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            default:
                throw new IndexOutOfBoundsException("Column index out of bounds");
        }
    }

    @Override
    public Participant getRow(int rowIndex) {
        return this.players.get(rowIndex);
    }

    @Override
    public List<Participant> getRows(int... rows) {
        List<Participant> playerList = new ArrayList<>();
        
        for (int row : rows) playerList.add(this.players.get(row));
        
        return playerList;
    }

    @Override
    public void addRow(Participant t) {
        this.players.add(t);
        super.fireTableDataChanged();
    }

    @Override
    public void insertRow(Participant t, int rowIndex) {
        this.players.add(rowIndex, t);
        super.fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        this.players.remove(rowIndex);
    }

}
