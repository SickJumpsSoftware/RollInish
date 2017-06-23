package com.sickjumps.rollinish.gui.table;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.gui.TableFormat;
import com.sickjumps.rollinish.campaign.character.Monster;
import com.sickjumps.rollinish.campaign.character.Participant;

/**
 *
 * @author Nathan
 */

public class TableFormatGenerator {
    
    private static final String[] playerParams = new String[] {"characterName", "playerName", "initiative", "dexMod" };
    private static final String[] playerNames = new String[] {"Character Name", "Player Name", "Initiative", "Dex Mod" };

    public static TableFormat<Participant> getPlayerTableFormat() {
        return GlazedLists.tableFormat(Participant.class, playerParams, playerNames, new boolean[] { false, false, false, false });
    }
    
    public static TableFormat<Participant> getActivePlayerTableFormat() {
        return GlazedLists.tableFormat(Participant.class, playerParams, playerNames, new boolean[] { false, false, true, true });
    }
    
    public static TableFormat<Monster> getMonsterTableFormat() {
        String[] params = new String[] { "name", "size", "type", "tag", "alignment", "xp", "source" };
        String[] names = new String[] { "Name", "Size", "Type", "Tag", "Alignment", "XP", "Source" };
        
        return GlazedLists.tableFormat(Monster.class, params, names);
    }
}
