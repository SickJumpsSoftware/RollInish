package com.sickjumps.rollinish.gui;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import com.sickjumps.rollinish.gui.table.PlayerTableModel;
import com.sickjumps.rollinish.gui.transfer.ImportTransferHandler;
import com.sickjumps.rollinish.campaign.character.Monster;
import com.sickjumps.rollinish.campaign.character.Participant;
import com.sickjumps.rollinish.campaign.io.MonsterDataParser;
import com.sickjumps.rollinish.gui.table.PlayerTableFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 *
 * @author Nathan
 */

public class PlayerTableAndMonsterPaneTest {

    private JFrame frame;
    private final EventList<Participant> players;
    private EventList<Monster> monsterData;
    
    private PlayerTableAndMonsterPaneTest() {
        frame = new JFrame();
        players = GlazedLists.eventList(
            Arrays.asList(new Participant[] {
                new Participant("test name", "nathan", 3),
                new Participant("test name", "jay", 2),
                new Participant("test name", "jo", 3),
                new Participant("test name", "jake", 4),
                new Participant("test name", "andy", 3),
                new Participant("test name", "eddie", 3)
            })
        );
        
        monsterData = new BasicEventList<>();
        
        try (InputStream is = PlayerTableAndMonsterPaneTest.class.getClassLoader().getResourceAsStream("monsters.csv")) {
            monsterData = MonsterDataParser.getMonsterData(is);
        } catch (IOException ioe) {
            
        }
    }
    
    public static void main(String... args) {
        PlayerTableAndMonsterPaneTest test = new PlayerTableAndMonsterPaneTest();
        test.run();
    }
    
    private void run() {
        createGUI();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createGUI() {
        JPanel rightPanel = new JPanel();
        JTable table = new JTable(new PlayerTableModel(players, new PlayerTableFormat()));
        table.setDragEnabled(true);
        table.setTransferHandler(new ImportTransferHandler());
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        
        rightPanel.add(scrollPane);
        
        JPanel leftPanel = new JPanel();
        JTabbedPane monsterPane = PaneCreator.createMonsterPane(monsterData);
        
        leftPanel.add(monsterPane);
        
        JPanel outerPanel = new JPanel();
        outerPanel.add(leftPanel);
        outerPanel.add(rightPanel);
        
        frame.add(outerPanel);
    }
}
