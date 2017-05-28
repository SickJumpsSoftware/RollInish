package com.sickjumps.rollinish.gui.table;

import com.sickjumps.rollinish.character.Participant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */

public class ParticipantTableModel extends AbstractTableModel 
                                   implements ObjectRowTableModel<Participant> {
    
    private final List<String> columns;
    private final List<TableModelListener> listeners;
    private final List<Participant> players;
    
    private final static Logger logger = LoggerFactory.getLogger(ParticipantTableModel.class);
    
    public ParticipantTableModel() {
        this(new ArrayList<Participant>());
    }
    
    public ParticipantTableModel(List<Participant> participants) {
        this.columns = Arrays.asList("Character Name", "Player Name", "Initiative");
        this.listeners = new ArrayList<>();
        this.players = participants;
    }

    @Override
    public int getRowCount() {
        logger.trace("getting row count");
        return this.players.size();
    }

    @Override
    public int getColumnCount() {
        logger.trace("getting column count");
        return this.columns.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        String s = this.columns.get(columnIndex);
        
        logger.trace("Getting column at {}: {}", columnIndex, s);
        
        return s;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        logger.trace("getting column class at {}", columnIndex);
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
        logger.trace("is cell editable");
        return (columnIndex == 2);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        logger.trace("get value at {}, {}", rowIndex, columnIndex);
        Participant p = this.players.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getCharacterName();
            case 1: return p.getPlayerName();
            case 2: return p.getDexMod();
            default: throw new IndexOutOfBoundsException("Column index not supported: " + columnIndex);
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        logger.trace("got new initiative value");
        if (!(aValue instanceof Integer)) return;
        
        if (isCellEditable(rowIndex, columnIndex)) {
            Participant p = this.players.get(rowIndex);
            
            p.setDexMod((int) aValue);
            
            super.fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        this.listeners.add(l);
        logger.trace("added TableModelListener");
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        this.listeners.removeIf((x) -> x.equals(l));
        logger.trace("removed TableModelListeners");
    }
    
    @Override
    public Participant getRow(int row) {
        Participant p = this.players.get(row);
        
        logger.trace("got participant at {}: {}", row, p);
        
        return p;
    }

    @Override
    public void add(Participant p) {
        logger.trace("adding participant to end of model");
        this.insert(this.getRowCount(), p);
        super.fireTableDataChanged();
    }
    
    @Override
    public void insert(int row, Participant p) {
        logger.trace("inserting participant at index {}", row);
        
        this.players.add(row, p);
        super.fireTableRowsInserted(row, row);
    }
    
    @Override
    public void remove(int row) {
        logger.trace("removing row at index {}", row);
        this.players.remove(row);
        super.fireTableRowsDeleted(row, row);
    }
}
