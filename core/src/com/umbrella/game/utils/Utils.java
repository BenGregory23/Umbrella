package com.umbrella.game.utils;

public class Utils {

    /**
     * Generates a random number between two bounds.
     * @param min Minimum bound.
     * @param max Maximum Bound.
     * @return A random number between the two bounds entered.
     * Exception - IllegalArgumentException if the min is greater than the max.
     */
    public static int randomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min.");
        }
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

}
