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
package com.sickjumps.rollinish.io;

/**
 * Encapsulates an algorithm for automatically generating names for files, players, etc.
 * 
 * @author Nathan
 */
public interface NamingStrategy {
    /**
     * Algorithm for automatically generating names for files, players, et al
     * with an optional prefix and suffix.
     * 
     * @param prefix A String to be pre-pended to the generated name
     * @param suffix A String to be appended to the generated name
     * @return The generated name with affixes affixed
     */
    public String getName(String prefix, String suffix);
}
