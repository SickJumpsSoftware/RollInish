package com.sickjumps.rollinish.gui;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Nathan
 */

public class ParticpantListModel<T> implements ListModel<T> {
    
    private ObservableList<T> playerList;
    private List<ListDataListener> listeners;
    
    public ParticpantListModel(ObservableList<T> ol) {
        this.playerList = ol;
        this.listeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return this.playerList.size();
    }

    @Override
    public T getElementAt(int index) {
        return this.playerList.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.listeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.listeners.remove(l);
    }
}
