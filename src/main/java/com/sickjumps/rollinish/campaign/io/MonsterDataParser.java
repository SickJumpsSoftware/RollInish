package com.sickjumps.rollinish.campaign.io;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import com.opencsv.CSVParser;
import com.sickjumps.rollinish.campaign.character.Alignment;
import com.sickjumps.rollinish.campaign.character.Monster;
import com.sickjumps.rollinish.campaign.character.Size;
import com.sickjumps.rollinish.campaign.character.Type;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */
public class MonsterDataParser {

    private final static Logger logger = LoggerFactory.getLogger(MonsterDataParser.class);

    public static EventList<Monster> getMonsterData(InputStream csvData) {
        EventList<Monster> monsterData = new BasicEventList<>();
        CSVParser parser = new CSVParser();

        String line = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(csvData))) {
            while (br.ready()) {
                line = br.readLine();
                if (!line.startsWith("#")) {
                    String[] fields = parser.parseLine(line);
                    Monster m = csvRecordToMonster(fields);
                    monsterData.add(m);
                }
            }
        } catch (IOException ex) {
            logger.error("Unable to parse CSV data", ex);
            logger.error(String.format("Current line: %s", line));
        }

        return monsterData;
    }

    private static Monster csvRecordToMonster(String[] record) {
        // Name,Size,Type,Tags,Alignment,Challenge,XP,Source
        
        String name = record[0];
        Size size = Size.fromString(record[1]);
        Type type = Type.fromString(record[2]);
        String tag = record[3];
        Alignment alignment = Alignment.fromString(record[4]);
        String challenge = record[5];
        int xp = Integer.valueOf(record[6]);
        String source = record[7];
        
        return new Monster(name, size, type, alignment, challenge, xp, source, tag);
    }
}
