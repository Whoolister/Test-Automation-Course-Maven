package solvd.maven_assignments.first;

import java.util.Random;
import java.util.Scanner;

public class Homework {

    public static void main(String[] args) {
        System.out.println("'Hello Wolrd!'\n"
                + "'What is my purpose?'\n"
                + ">You do my Homework\n"
                + "'...'\n"
                + "'Oh my god...'");

        Homework object = new Homework();

        System.out.println("\n\nF I R S T   T A S K");
        System.out.println("===================");
        object.firstTask();
        // ALTERNATIVELY
        object.firstTask(args);

        System.out.println("\n\nS E C O N D   T A S K");
        System.out.println("===================");
        int[] input = new int[100];
        for (int i = 0; i < 100; i++) {
            input[i] = (new Random()).nextInt(10000);
        }
        object.secondTask(input);

        System.out.println("\n\nT H I R D   T A S K");
        System.out.println("===================");
        object.thirdTask(input);

        System.out.println("\n\nAu Revoir");
    }

    void firstTask() {
        // INPUT SOMETHING TO PRINT
        Scanner scan = new Scanner(System.in);
        System.out.println(scan.nextLine());
        scan.close();
    }

    void firstTask(String[] arguments) {
        // PRINT EVERY ELEMENT OF ARGS
        for (String element : arguments) {
            System.out.print(element + " ");
        }
    }

    void secondTask(int[] array) {
        int biggest = 0, smallest = array[0], index = 0;

        // OPEN CYCLE
        while (index < array.length) {
            // CHECK FOR BIGGEST & SMALLEST
            if (array[index] < smallest) {
                smallest = array[index];
            } else if (array[index] > biggest) {
                biggest = array[index];
            }
            index++;
        }

        // PRINT RESULT
        System.out.println("Biggest Number: " + biggest);
        System.out.println("Smallest Number: " + smallest);
    }

    void thirdTask(int[] array) {
        // SELECTION SORT
        int auxiliary;
        for (int index = 0; index < array.length; index++) {
            // FOR EVERY VALUE
            for (int secondary = index + 1; secondary < array.length; secondary++) {
                // CHECK AGAINST EVERY ELEMENT
                if (array[secondary] < array[index]) {
                    // SWAP
                    auxiliary = array[secondary];
                    array[secondary] = array[index];
                    array[index] = auxiliary;
                }
            }
        }
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
