package solvd.maven_assignments.second.run;

import solvd.maven_assignments.second.inheritance.*;
import solvd.maven_assignments.third.utilities.Randomizer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Runner {
    static ArrayList<Animal> collection = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("F I R S T   T A S K");
        System.out.println("===================");
        Runner.firstTask(5);

        System.out.println("\nS E C O N D   T A S K");
        System.out.println("===================");
        Runner.secondTask();

        System.out.println("\nT H I R D  T A S K");
        System.out.println("===================");
        int[] input = new int[100];
        for (int i = 0; i < 100; i++) {
            input[i] = (new Random()).nextInt(10000);
        }
        System.out.println("Unsorted: " + Arrays.toString(input) + '\n');
        Runner.thirdTask(input);
        System.out.println("Sorted: " + Arrays.toString(input));
    }

    static void firstTask(int limit) {
        for (int index = 0; index < limit; index++) {
            switch ((new Random()).nextInt(5)) {
                case 0:
                    collection.add(new Arthropod());
                    break;
                case 1:
                    collection.add(new Mollusk());
                    break;
                case 2:
                    collection.add(new Reptile());
                    break;
                case 3:
                    collection.add(new Mammal());
                    break;
                case 4:
                    collection.add(new Fish());
                    break;
                case 5:
                    collection.add(new Alien());
            }
        }

        for (int index = 0; index < collection.size(); index++) {
            Animal test = collection.get(index);

            System.out.println("String: " + test.toString());
            System.out.println("Equal to itself? " + test.equals(test));
            System.out.println("Equal to random object? " + test.equals(new Alien()));
            System.out.println("HashCode: " + test.hashCode() + '\n');
        }
    }

    static void secondTask() {
        String one = Randomizer.randomizeString(30);
        String two = Randomizer.randomizeString(30);

        System.out.println("|First String: " + one);
        System.out.println("|First letter: " + one.charAt(0));
        System.out.println("|Last letter: " + one.charAt(one.length() - 1));
        System.out.println("|All lowercase: " + one.toLowerCase());
        System.out.println("|All uppercase: " + one.toUpperCase());
        System.out.println("|Position of character 'd': " + one.indexOf('d') + '\n');

        System.out.println("|Second String: " + two);
        System.out.println("|First String: " + two);
        System.out.println("|First letter: " + two.charAt(0));
        System.out.println("|Last letter: " + two.charAt(two.length() - 1));
        System.out.println("|All lowercase: " + two.toLowerCase());
        System.out.println("|All uppercase: " + two.toUpperCase());
        System.out.println("|Position of character 'd': " + two.indexOf('d'));
    }

    static void thirdTask(int[] array, int index, int length) {
        //FIND THE SMALLEST ELEMENT IN THE UNSORTED ARRAY AND SWAP IT WITH THE VALUE AT 'index'
        int minimum = index;
        for (int search = index + 1; search < length; search++) {
            //IF 'search' IS SMALLER THAN THE CURRENT MINIMUM, UPDATE 'minimum'
            if (array[search] < array[minimum]) {
                minimum = search;
            }
        }

        //SWAP THE SMALLEST ELEMENT WITH ITS PROPER POSITION
        int auxiliary = array[minimum];
        array[minimum] = array[index];
        array[index] = auxiliary;

        //IF THE SORTING HASN'T SCANNED THE WHOLE ARRAY, KEEP GOING
        if (index + 1 < length) {
            thirdTask(array, index + 1, length);
        }
    }

    static void thirdTask(int[] array) {
        //SET STARTING CONDITIONS
        int index = 0, length = array.length;
        //FIND THE SMALLEST ELEMENT IN THE UNSORTED ARRAY AND SWAP IT WITH THE VALUE AT 'index'
        int minimum = index;
        for (int search = index + 1; search < length; search++) {
            //IF 'search' IS SMALLER THAN THE CURRENT MINIMUM, UPDATE 'minimum'
            if (array[search] < array[minimum]) {
                minimum = search;
            }
        }

        //SWAP THE SMALLEST ELEMENT WITH ITS PROPER POSITION
        int auxiliary = array[minimum];
        array[minimum] = array[index];
        array[index] = auxiliary;

        //IF THE SORTING HASN'T SCANNED THE WHOLE ARRAY, KEEP GOING
        if (index + 1 < length) {
            thirdTask(array, index + 1, length);
        }
    }
}
