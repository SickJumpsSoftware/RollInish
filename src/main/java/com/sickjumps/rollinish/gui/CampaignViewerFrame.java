package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.Campaign;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Nathan
 */
public class CampaignViewerFrame extends JFrame {

    private Campaign campaign;

    public CampaignViewerFrame(Campaign campaign) {
        this.campaign = campaign;
        this.addComponentListener(new ResizeListener());

        this.initializeComponents();

        this.pack();
        this.resizeComponents();
    }

    private void initializeComponents() {
        this.setTitle("RollInish");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.logArea = new JTextArea();
        this.logPane = new JScrollPane(this.logArea);
        this.encounterPane = new EncounterPane(campaign.getEncounters());

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(encounterPane);
        this.add(logPane);
    }

    // sets the height of the encounter pane to 2/3 the window height and the log pane to 1/3
    private void resizeComponents() {
        final int HEIGHT = this.getHeight();

        this.logPane.setPreferredSize(new Dimension(HEIGHT / 3, this.logPane.getPreferredSize().width));
        this.encounterPane.setPreferredSize(new Dimension(HEIGHT * 2 / 3, this.encounterPane.getPreferredSize().width));
    }

    private class ResizeListener extends ComponentAdapter {

        @Override
        public void componentResized(ComponentEvent e) {
            final CampaignViewerFrame outer = CampaignViewerFrame.this;
            outer.resizeComponents();
        }
    }

    private EncounterPane encounterPane;
    private JScrollPane logPane;
    private JTextArea logArea;
}
