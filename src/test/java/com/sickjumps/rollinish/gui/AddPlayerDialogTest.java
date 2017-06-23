package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.character.Participant;

/**
 *
 * @author Nathan
 */
public class AddPlayerDialogTest {

    public static void main(String[] args) {
        AddNewPlayerDialog dialog = new AddNewPlayerDialog(null, true);
        Participant p = dialog.getResult();

        System.out.println(p);
    }
}
