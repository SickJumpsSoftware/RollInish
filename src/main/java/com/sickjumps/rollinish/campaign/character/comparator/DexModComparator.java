package com.sickjumps.rollinish.campaign.character.comparator;

import com.sickjumps.rollinish.campaign.character.Participant;
import java.util.Comparator;

/**
 *
 * @author Nathan
 */
public class DexModComparator implements Comparator<Participant> {

    @Override
    public int compare(Participant o1, Participant o2) {
        return o1.getDexMod() - o2.getDexMod();
    }

}
