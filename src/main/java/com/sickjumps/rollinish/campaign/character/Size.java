package com.sickjumps.rollinish.campaign.character;

/**
 *
 * @author Nathan
 */
public enum Size {
    TINY("Tiny"),
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large"),
    HUGE("Huge"),
    GARGANTUAN("Gargantuan");

    private final String name;

    private Size(String displayName) {
        name = displayName;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Size fromString(String size) {
        if (size.equalsIgnoreCase("tiny")) {
            return TINY;
        }
        if (size.equalsIgnoreCase("small")) {
            return SMALL;
        }
        if (size.equalsIgnoreCase("medium")) {
            return MEDIUM;
        }
        if (size.equalsIgnoreCase("large")) {
            return LARGE;
        }
        if (size.equalsIgnoreCase("huge")) {
            return HUGE;
        }
        if (size.equalsIgnoreCase("gargantuan")) {
            return GARGANTUAN;
        }

        throw new IllegalArgumentException(String.format("Invalid string parameter passed: {}", size));
    }
}
