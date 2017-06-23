/*
 * Copyright (C) 2017 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.sickjumps.rollinish.campaign.character;

/**
 *
 * @author Nathan
 */
public enum Alignment {
    LG("Lawful Good"),
    NG("Neutral Good"),
    CG("Chaotic Good"),
    LN("Lawful Neutral"),
    NN("True Neutral"),
    CN("Chaotic Neutral"),
    LE("Lawful Evil"),
    NE("Neutral Evil"),
    CE("Chaotic Evil"),
    UN("Unaligned");

    private final String alignment;

    private Alignment(String alignment) {
        this.alignment = alignment;
    }

    @Override
    public String toString() {
        return alignment;
    }

    public static Alignment fromString(String alignment) {
        if (alignment.equalsIgnoreCase("lg")) {
            return LG;
        }
        if (alignment.equalsIgnoreCase("ng")) {
            return NG;
        }
        if (alignment.equalsIgnoreCase("cg")) {
            return CG;
        }
        if (alignment.equalsIgnoreCase("ln")) {
            return LN;
        }
        if (alignment.equalsIgnoreCase("n")) {
            return NN;
        }
        if (alignment.equalsIgnoreCase("cn")) {
            return CN;
        }
        if (alignment.equalsIgnoreCase("le")) {
            return LE;
        }
        if (alignment.equalsIgnoreCase("ne")) {
            return NE;
        }
        if (alignment.equalsIgnoreCase("ce")) {
            return CE;
        }
        if (alignment.equalsIgnoreCase("unaligned")) {
            return UN;
        }

        throw new IllegalArgumentException(String.format("Illegal alignment string: %s", alignment));
    }
}
