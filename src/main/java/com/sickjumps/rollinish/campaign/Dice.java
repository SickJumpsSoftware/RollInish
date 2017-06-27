package com.sickjumps.rollinish.campaign;

import java.util.Random;

/**
 *
 * @author Nathan
 */

public class Dice {

    private final static Random rng = new Random();
    
    public static int rollD20(int mod) {
        return rng.nextInt(20) + 1 + mod;
    }
}
