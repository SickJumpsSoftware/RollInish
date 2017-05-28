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
package com.sickjumps.rollinish.character;

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
    CE("Chaotic Evil");
    
    private String alignment;
    private Alignment(String alignment) {
        this.alignment = alignment;
    }
    
    @Override
    public String toString() {
        return alignment;
    }
    
    public static Alignment fromString(String alignment) {
        if (alignment.equalsIgnoreCase("lawful good")) return LG;
        if (alignment.equalsIgnoreCase("neutral good")) return NG;
        if (alignment.equalsIgnoreCase("chaotic good")) return CG;
        if (alignment.equalsIgnoreCase("lawful neutral")) return LN;
        if (alignment.equalsIgnoreCase("true neutral")) return NN;
        if (alignment.equalsIgnoreCase("chaotic neutral")) return CN;
        if (alignment.equalsIgnoreCase("lawful evil")) return LE;
        if (alignment.equalsIgnoreCase("true evil")) return NE;
        if (alignment.equalsIgnoreCase("chaotic evil")) return CE;
        
        throw new IllegalArgumentException(String.format("Illegal alignment string: {}", alignment));
    }
}
