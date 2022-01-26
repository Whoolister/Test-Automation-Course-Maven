package run;

import inheritance.*;
import utilities.Randomizer;

import java.util.ArrayList;
import java.util.Arrays;

public class Runner {
    static ArrayList<Animal> collection = new ArrayList<>();
    static String staticVariable = Randomizer.randomizeString(20);

    static {
        System.out.println("S T A R T\n"
                + "==========\n"
                + "Static Block Testing...\n"
                + "This will run as the class is loaded, without even paying heed to main(), although they work in a very similar fashion.\n"
                + "Neat!\n"
                + "==========");
    }

    public static void main(String[] args) {
        System.out.println("ENTERING MAIN\n\n"
                + "A non-static variable will not exist unless an instance of the class is created, which isn't the case for this main().\n"
                + "But since staticVariable is static, it belongs to a class, and will exist with a value already: " + staticVariable + "\n"
                + "Success!");

        System.out.println("==========\n"
                + "STATIC METHOD\n\n"
                + "Sieve of Erathostenes with a limit of 10k:");
        testStaticMethod(10000);
        System.out.println("==========");
    }

    static void testStaticMethod(int limit) {
        boolean[] primes = new boolean[limit];
        Arrays.fill(primes, true);

        for (int index = 2; index < Math.sqrt(limit); index++) {
            if (primes[index] == true) {
                for (int pointer = index * index; pointer < limit; pointer += index) {
                    primes[pointer] = false;
                }
            }
        }

        System.out.print('[');
        for (int index = 0; index < primes.length; index++) {
            if (primes[index] == true) {
                System.out.print(index + " ");
            }
        }
        System.out.println(']');
    }
}
