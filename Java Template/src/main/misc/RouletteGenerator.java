/*
     This Roulette generator was quickly made for my mate that gambles.
*/

package main.misc;

import java.util.Random;
import java.util.Set;

public class RouletteGenerator {
    private static final Random RANDOM = new Random();

    private static final Set<Integer> RED_NUMBERS = Set.of(
            1, 3, 5, 7, 9,
            12, 14, 16, 18,
            19, 21, 23, 25, 27,
            30, 32, 34, 36
    );

    public static RouletteResult generateSpin() {
        int number = RANDOM.nextInt(37); // 0–36

        String colour = getColour(number);
        String oddEven = getOddEven(number);
        String dozen = getDozen(number);
        String row = getRow(number);

        return new RouletteResult(number, colour, oddEven, dozen, row);
    }

    private static String getColour(int number)
    {
        if (number == 0) return "Green";
        return RED_NUMBERS.contains(number) ? "Red" : "Black";
    }

    private static String getOddEven(int number)
    {
        if (number == 0) return "N/A";
        return (number % 2 == 0) ? "Even" : "Odd";
    }

    private static String getDozen(int number)
    {
        if (number == 0) return "N/A";
        if (number <= 12) return "1st 12";
        if (number <= 24) return "2nd 12";
        return "3rd 12";
    }

    private static String getRow(int number)
    {
        if (number == 0) return "N/A";

        int remainder = number % 3;

        if (remainder == 1) return "1st row";
        if (remainder == 2) return "2nd row";
        return "3rd row";
    }

    public static class RouletteResult
    {
        public int number;
        public String colour;
        public String oddEven;
        public String dozen;
        public String row;

        public RouletteResult(int number, String colour, String oddEven, String dozen, String row)
        {
            this.number = number;
            this.colour = colour;
            this.oddEven = oddEven;
            this.dozen = dozen;
            this.row = row;
        }
    }
}