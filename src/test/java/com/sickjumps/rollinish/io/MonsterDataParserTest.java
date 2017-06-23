package com.sickjumps.rollinish.io;

import com.sickjumps.rollinish.campaign.character.Monster;
import com.sickjumps.rollinish.campaign.io.MonsterDataParser;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author Nathan
 */
public class MonsterDataParserTest {

    public static void main(String... args) {
        InputStream is = MonsterDataParserTest.class.getClassLoader().getResourceAsStream("monsters.csv");

        List<Monster> monsterData = MonsterDataParser.getMonsterData(is);

        monsterData.stream().forEach((x) -> System.out.println(x));
    }
}
