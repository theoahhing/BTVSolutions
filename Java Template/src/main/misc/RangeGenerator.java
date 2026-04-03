/*
     This range generator was quickly made for my mate that gambles.
*/

package main.misc;

import java.util.Random;

public class RangeGenerator
{
    private static final Random RANDOM = new Random();

    public static int generate(int min, int max)
    {
        if (min > max)
        {
            throw new IllegalArgumentException("min must be <= max");
        }

        return RANDOM.nextInt((max - min) + 1) + min;
    }
}