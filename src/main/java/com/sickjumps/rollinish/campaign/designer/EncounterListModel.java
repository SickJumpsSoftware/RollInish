package com.sickjumps.rollinish.campaign.designer;

import com.sickjumps.rollinish.campaign.Encounter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Nathan
 */

public class EncounterListModel extends AbstractListModel<Encounter> {

    private final List<Encounter> encounters;
    
    public EncounterListModel(List<Encounter> encounters) {
        this.encounters = encounters;
    }
    
    @Override
    public int getSize() {
        return this.encounters.size();
    }

    @Override
    public Encounter getElementAt(int index) {
        return this.encounters.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.listenerList.add(ListDataListener.class, l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.listenerList.remove(ListDataListener.class, l);
    }
    
    public void addElement(Encounter e) {
        this.insertElement(e, this.getSize());
    }
    
    public void insertElement(Encounter e, int index) {
        this.encounters.add(index, e);
        super.fireIntervalAdded(this, index, index);
    }
    
    public void removeElementAt(int index) {
        this.encounters.remove(index);
        super.fireIntervalRemoved(this, index, index);
    }
}
