package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.character.Participant;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Nathan
 */

public class PlayerTableModelTest {

    private final static List<Participant> players = new ArrayList<>(
        Arrays.asList(
            new Participant[] {
                new Participant("test name", "nathan", 3),
                new Participant("test name", "jay", 2),
                new Participant("test name", "jo", 3),
                new Participant("test name", "jake", 4),
                new Participant("test name", "andy", 3),
                new Participant("test name", "eddie", 3)
            }
        )
    );
    
    public static void main(String... args) {
        JFrame test = new JFrame();
        JPanel panel = new JPanel();
        JScrollPane jsp = new JScrollPane();
        JTable table = new JTable();
        
        table.setModel(new PlayerTableModel(players));
        table.setDragEnabled(true);
        table.setFillsViewportHeight(true);
        table.setMinimumSize(new Dimension(500, 400));
        
        jsp.setViewportView(table);
        panel.add(jsp);
        test.add(panel);
        
        test.pack();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }
}