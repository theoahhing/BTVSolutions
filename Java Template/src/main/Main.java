package main;
/*
    Some other possible utility classes to create:
        - ValidationUtil
        - CollectionUtil
        - RegexUtil
        - ThreadUtil
        - SystemUtil
        - NetworkUtil

    Some other possible service classes to create:
        - DirectoryService
        - ConfigService
        - LoggingService
        - ApiService/HttpService
        - AuthenticationService/SecurityService
        - ValidationService
        - SchedulerService/TaskService

    Just a refresher on Java Coding. Definitions to remember:
        01. K&R style (opening brace on same line) is used in Java. Personal preference is to use Allman style
            formatting.
        02. Stack memory follows last-in, first-out (LIFO) and:
            - Allocated automatically by compiler
            - Fast access.
            - Limited size.
        03. Heap is a large pool of memory used for dynamic allocation and:
            - Allocated manually.
            - Slow access.
            - Flexible size.
        04. Boxing is the process of storing a primitive type in the object and unboxing the reverse form of boxing.
        05. Wrapper classes are classes that hold objects and control how its actions are performed, often adding
            behaviour before or after those actions. In Laymen's terms: "I have an object and whenever I use my
            object, I can do extra things around what it normally does".
        06. Record is a special type of class designed to represent pure data (data carriers). Best explained as a
            compact, immutable class whose main purpose is to store values.
        07.
        08.
        09.
        10.
*/

import java.util.Scanner; // Package for accepting user imports
import main.misc.RouletteGenerator;
import main.misc.RangeGenerator;

public class Main
{
    public static void main(String[] args)
    {
        /* -------------> Uncomment for range generator <---------------------
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum value (x): ");
        int x = scanner.nextInt();

        System.out.print("Enter maximum value (y): ");
        int y = scanner.nextInt();

        while (true)
        {
            int z = RangeGenerator.generate(x, y);
            System.out.println("Generated: " + z);

            System.out.print("Press ENTER to generate again (or type exit): ");
            scanner.nextLine(); // clear buffer
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit"))
            {
                break;
            }
        }
        */

        /* -------------> Uncomment for roulette generator <---------------------
        RouletteGenerator.RouletteResult result = RouletteGenerator.generateSpin();

        System.out.println("=== Roulette Spin ===");
        System.out.println("Number   : " + result.number);
        System.out.println("Colour   : " + result.colour);
        System.out.println("Odd/Even : " + result.oddEven);
        System.out.println("Dozen    : " + result.dozen);
        System.out.println("Row      : " + result.row);
        */

    }
}