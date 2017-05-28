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
public enum Type {
    ABERRATION("Aberration"),
    BEAST("Beast"),
    CELESTIAL("Celestial"),
    CONSTRUCT("Construct"),
    DRAGON("Dragon"),
    ELEMENTAL("Elemental"),
    FEY("Fey"),
    FIEND("Fiend"),
    GIANT("Giant"),
    HUMANOID("Humanoid"),
    MONSTROSITY("Monstrosity"),
    OOZE("Ooze"),
    PLANT("Plant"),
    UNDEAD("Undead");
    
    private final String name;
    private Type(String name) {
        this.name = name;        
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    public static Type fromString(String name) {
        if (name.equalsIgnoreCase("aberration")) return ABERRATION;
        if (name.equalsIgnoreCase("beast")) return BEAST;
        if (name.equalsIgnoreCase("celestial")) return CELESTIAL;
        if (name.equalsIgnoreCase("construct")) return CONSTRUCT;
        if (name.equalsIgnoreCase("dragon")) return DRAGON;
        if (name.equalsIgnoreCase("elemental")) return ELEMENTAL;
        if (name.equalsIgnoreCase("fey")) return FEY;
        if (name.equalsIgnoreCase("fiend")) return FIEND;
        if (name.equalsIgnoreCase("giant")) return GIANT;
        if (name.equalsIgnoreCase("humanoid")) return HUMANOID;
        if (name.equalsIgnoreCase("monstrosity")) return MONSTROSITY;
        if (name.equalsIgnoreCase("ooze")) return OOZE;
        if (name.equalsIgnoreCase("plant")) return PLANT;
        if (name.equalsIgnoreCase("undead")) return UNDEAD;
        
        throw new IllegalArgumentException(String.format("Invalid string parameter passed for Type: {}", name));
    }
}
