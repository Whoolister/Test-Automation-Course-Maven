package solvd.maven_assignments.fourth.run;

import solvd.maven_assignments.fourth.exceptions.BadVariableException;
import solvd.maven_assignments.fourth.inheritance.*;
import solvd.maven_assignments.fourth.utilities.MyLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AnimalRunner {
    static final MyLogger LOG = new MyLogger(Logger.GLOBAL_LOGGER_NAME);
    static final File file = new File("AnimalLog.txt");
    static ArrayList<Animal> collection = new ArrayList<>();

    public static void main(String[] args) {
        //CHOOSE YOUR OWN ADVENTURE
        LOG.fine("A N I M A L  R U N N E R\n"
                + "==========\n"
                + "What do you want to do?\n"
                + "\t♦ Type 1 to go to the Zoo\n"
                + "\t♦ Type 2 to read the last log\n");

        try (Scanner scan = new Scanner(System.in)) {
            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    int choice = scan.nextInt();
                    if (choice == 1) {
                        LOG.setupLogger(file);
                        zooTour();
                        break;
                    } else if (choice == 2) {
                        archives();
                        break;
                    } else {
                        LOG.fine("ERRONEOUS INPUT: Must input 1 or 2.");
                    }
                } else {
                    LOG.fine("ERRONEOUS INPUT: Must be an integer.");
                    scan.next();
                }
            }
            LOG.finest("END OF THE LINE\n"
                    + "==========");
        }
    }

    static void zooTour() {
        LOG.info("ENTERING THE ZOO\n"
                + "==========");
        LOG.fine("Input an amount of animals for the collection, and press enter:\n");

        int limit;
        //ROUNDS OUT THE NUMBER, AND MAKES SURE IT'S A POSITIVE
        try (Scanner scan = new Scanner(System.in)) {
            limit = Math.round(Math.abs(scan.nextInt()));
        }

        LOG.info("Generating " + limit + " animals...\n");

        for (int index = 0; index < limit; index++) {
            switch ((new Random()).nextInt(6)) {
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
                    collection.add(new Cnidarian());
            }
        }

        for (int index = 0; index < limit; index++) {
            try {
                Animal animal = collection.get(index);
                LOG.info(animal.toString() + '\n');
                LOG.info(animal.breathe() + '\n' +
                        animal.move() + '\n' +
                        animal.eat() + '\n' +
                        animal.think() + '\n');
            } catch (BadVariableException e) {
                LOG.log(Level.SEVERE, "Problem Ocurred in Animal Collection Examination: ", e);
            }
        }
    }

    static void archives() {
        try (BufferedReader reader = new BufferedReader(new FileReader("AnimalLog.txt"))) {
            StringBuilder content = new StringBuilder();
            String line = "";

            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }

            LOG.fine(content.toString());
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "ERROR OCURRED WHILE READING THE LOG FILE:", e);
            System.exit(0);
        }
    }
}
