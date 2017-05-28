package com.sickjumps.rollinish.gui.table;

import com.sickjumps.rollinish.character.Alignment;
import com.sickjumps.rollinish.character.Monster;
import com.sickjumps.rollinish.character.Size;
import com.sickjumps.rollinish.character.Type;
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

public class MonsterTableModel extends AbstractTableModel implements ObjectRowTableModel<Monster>{

    private final static Logger logger = LoggerFactory.getLogger(MonsterTableModel.class);
    private final List<TableModelListener> listeners;
    private final List<String> columnNames;
    private final List<Monster> monsterData;
    
    public MonsterTableModel() {
        this(new ArrayList<Monster>());
    }
    
    public MonsterTableModel(List<Monster> monsters) {
        logger.trace("MonsterTableModel constructor");
        this.columnNames = Arrays.asList("Name", "Size", "Type", "Tag", "Alignment", "XP", "Source");
        this.monsterData = monsters;
        this.listeners = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        logger.trace("MonsterTableModel::getRowCount");
        return this.monsterData.size();
    }

    @Override
    public int getColumnCount() {
        logger.trace("MonsterTableModel::getColumnCount");
        return this.columnNames.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        logger.trace("MonsterTableModel::getColumnName:{}", columnIndex);
        return this.columnNames.get(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        logger.trace("MonsterTableModel::getColumnClass:{}", columnIndex);
        switch(columnIndex) {
            case 0: return String.class;
            case 1: return Size.class;
            case 2: return Type.class;
            case 3: return String.class;
            case 4: return Alignment.class;
            case 5: return Integer.class;
            case 6: return String.class;
            default: throw new ArrayIndexOutOfBoundsException(String.format("Illegal column index for MonsterTableModel: {}", columnIndex));
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        logger.trace("MonsterTableModel::getValueAt:{}, {}", rowIndex, columnIndex);
        
        Monster m = this.monsterData.get(rowIndex);
        switch(columnIndex) {
            case 0: return m.getCharacterName();
            case 1: return m.getSize();
            case 2: return m.getType();
            case 3: return m.getTag();
            case 4: return m.getAlignment();
            case 5: return m.getXp();
            case 6: return m.getSource();
            default: throw new ArrayIndexOutOfBoundsException(String.format("Illegal column index for getValueAt: {}", columnIndex));
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        logger.trace("MonsterTableModel::setValueAt:{}, {} - {}", rowIndex, columnIndex, aValue);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        logger.trace("MonsterTableModel::addTableModelListener");
        this.listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        logger.trace("MonsterTableModel::removeTableModelListener");
        this.listeners.removeIf(x -> x.equals(l));
    }

    @Override
    public Monster getRow(int row) {
        logger.trace("ObjectRowTableModel::MonsterTableModel::getRow:{}", row);
        return this.monsterData.get(row);
    }

    @Override
    public void add(Monster t) {
        logger.trace("ObjectRowTableModel::MonsterTableModel::add:{}", t);
        this.monsterData.add(t);
        super.fireTableDataChanged();
    }

    @Override
    public void insert(int row, Monster t) {
        logger.trace("ObjectRowTableModel::MonsterTableModel::insert:{} @ {}", t, row);
        this.monsterData.add(row, t);
        super.fireTableRowsInserted(row, row);
    }

    @Override
    public void remove(int row) {
        logger.trace("ObjectRowTableModel::MonsterTableModel::remove:{}", row);
        this.monsterData.remove(row);
        super.fireTableRowsDeleted(row, row);
    }
}
