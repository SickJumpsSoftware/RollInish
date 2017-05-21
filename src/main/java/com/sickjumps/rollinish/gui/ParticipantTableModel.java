package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.Participant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nathan
 */

public class ParticipantTableModel extends AbstractTableModel 
                                   implements ObjectRowTableModel<Participant> {
    
    private final List<String> columns;
    private final List<TableModelListener> listeners;
    private final List<Participant> players;
    
    public ParticipantTableModel(List<String> columns, List<Participant> participants) {
        this.columns = columns;
        this.listeners = new ArrayList<>();
        this.players = participants;
    }

    @Override
    public int getRowCount() {
        return this.players.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.columns.get(columnIndex);
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
                throw new IndexOutOfBoundsException("Column index not supported: " + columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex < 2);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Participant p = this.players.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getCharacterName();
            case 1: return p.getPlayerName();
            case 2: return p.getInitiative();
            default: throw new IndexOutOfBoundsException("Column index not supported: " + columnIndex);
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (!(aValue instanceof Integer)) return;
        
        if (isCellEditable(rowIndex, columnIndex)) {
            Participant p = this.players.get(rowIndex);
            
            p.setInitiative((int) aValue);
            
            super.fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        this.listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        this.listeners.removeIf((x) -> x.equals(l));
    }
    
    @Override
    public Participant getRow(int row) {
        return this.players.get(row);
    }

    @Override
    public void add(Participant p) {
        this.insert(this.getRowCount(), p);
    }
    
    @Override
    public void insert(int row, Participant p) {
        this.players.add(row, p);
        super.fireTableRowsInserted(row, row);
    }
    
    @Override
    public void remove(int row) {
        
    }
}
