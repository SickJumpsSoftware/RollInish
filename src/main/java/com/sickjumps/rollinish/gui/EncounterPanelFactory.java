package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.character.Monster;
import com.sickjumps.rollinish.gui.table.MonsterTableModel;
import com.sickjumps.rollinish.gui.table.ParticipantTableModel;
import com.sickjumps.rollinish.character.Participant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Nathan
 */

public class EncounterPanelFactory {

    private List<Participant> participants;
    private List<Monster> monsters;
    private List<Participant> active;
    private final List<String> columnNames;
    private final List<String> monsterColumnNames;
    
    public EncounterPanelFactory() {
        this.participants = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.active = new ArrayList<>();
        this.columnNames = new ArrayList<>();
        this.monsterColumnNames = new ArrayList<>();
    }
    
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
    
    public void setMonsterInfo(List<Monster> monsters) {
        this.monsters = monsters;
    }
    
    public void setActiveParticipants(List<Participant> active) {
        this.active = active;
    }
    
    public EncounterPanel buildPanel() {
        EncounterPanel panel = new EncounterPanel();
        
        getColumnNames();
        monsterColumnNames();
        
        ParticipantTableModel playerModel = new ParticipantTableModel(participants);
        MonsterTableModel monsterModel = new MonsterTableModel(monsters);
        ParticipantTableModel activeModel = new ParticipantTableModel(active);
        
        panel.setMonsterTableModel(monsterModel);
        panel.setPlayerTableModel(playerModel);
        panel.setActiveTableModel(activeModel);
        
        return panel;
    }
    
    private void getColumnNames() {
        Collections.addAll(columnNames, "Character Name", "Player Name", "Initiative");
    }
    
    private void monsterColumnNames() {
        Collections.addAll(monsterColumnNames, "Name", "Size", "Type", "Tag", "Alignment", "XP", "Source");
    }
}
