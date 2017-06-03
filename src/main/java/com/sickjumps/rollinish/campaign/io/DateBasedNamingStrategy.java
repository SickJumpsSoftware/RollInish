package com.sickjumps.rollinish.campaign.io;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Encapsulates an algorithm for generating names based on the current date.
 * @author Nathan
 */

public class DateBasedNamingStrategy implements NamingStrategy {

    @Override
    public String getName(String prefix, String suffix) {
        LocalDateTime now = LocalDateTime.now();
        String dateString = DateTimeFormatter.ofPattern("MM-dd-yyyy").format(now);
        return String.format("%s - %s.%s", prefix, dateString, suffix);
    }

}
