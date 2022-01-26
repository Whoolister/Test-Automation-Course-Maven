package sixth_solvd_assignment.inheritance;

import sixth_solvd_assignment.exceptions.BadVariableException;
import sixth_solvd_assignment.utilities.Randomizer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;

public class Zoo extends Facility {
    private static final LinkedList<Animal> exhibits = new LinkedList<>();

    public static void tour(Scanner scanner) {
        LOG.setupLogger();

        LOG.logAndShow(Level.INFO, "ENTERING THE ZOO" + System.lineSeparator() + "==<O>===<0>===<O>===<0>===<O>=="
                + System.lineSeparator());

        boolean useRNG = true;
        if (specimens != null) {
            LOG.logAndShow(Level.INFO,
                    "What mode do you want to use?" + System.lineSeparator() + ">-> Type 1 to check the saved exhibits"
                            + System.lineSeparator() + ">-> Type 2 to randomly generate exhibits"
                            + System.lineSeparator());

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int mode = scanner.nextInt();
                    if (mode == 1) {
                        useRNG = false;
                        exhibits.addAll(specimens);
                        break;
                    } else if (mode == 2) {
                        break;
                    } else {
                        LOG.logAndShow(Level.SEVERE, "ERRONEOUS INPUT: Must input 1 or 2." + System.lineSeparator());
                    }
                } else {
                    LOG.logAndShow(Level.SEVERE, "ERRONEOUS INPUT: Must be an integer." + System.lineSeparator());
                    scanner.next();
                }
            }
        }

        if (useRNG) {
            LOG.logAndShow(Level.INFO, "Input an amount of animals for the collection (Up to 16), and press enter:"
                    + System.lineSeparator());
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int amount = scanner.nextInt();
                    if (amount > 0 && amount <= 16) {
                        LOG.logAndShow(Level.INFO, "Generating " + amount + " animals..." + System.lineSeparator());
                        exhibits.addAll(Randomizer.creatureCreator(amount));

                        char id = 'A';

                        for (Animal animal : exhibits) {
                            try {
                                LOG.logAndShow(Level.INFO,
                                        "Exhibit " + (id++) + ":" + System.lineSeparator() + animal.toString()
                                                + System.lineSeparator() + animal.breathe() + System.lineSeparator()
                                                + animal.move() + System.lineSeparator() + animal.eat()
                                                + System.lineSeparator() + animal.think() + System.lineSeparator());
                            } catch (BadVariableException e) {
                                LOG.logAndShow(Level.SEVERE, "Problem Ocurred in Animal Collection Examination: "
                                        + e.getMessage() + System.lineSeparator() + animal.toString());
                            }

                        }
                        break;
                    } else {
                        LOG.logAndShow(Level.INFO,
                                "ERRONEOUS INPUT (" + amount + "): Must input a number between 1 and 100.");
                    }
                } else {
                    LOG.logAndShow(Level.INFO, "ERRONEOUS INPUT: Must be an integer.");
                    scanner.next();
                }
            }
        }

        LOG.logAndShow(Level.INFO,
                "Do you want to save these creatures?" + System.lineSeparator() + ">-> Type 1 to save them"
                        + System.lineSeparator() + ">-> Type 2 to discard them, you monster..."
                        + System.lineSeparator());
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int operation = scanner.nextInt();
                if (operation == 1) {
                    LOG.logAndShow(Level.INFO, "The saved exhibits have been saved to our specimens lab,"
                            + System.lineSeparator() + "you may choose to retrieve them as fighters in the arena.");
                    specimens = new ArrayList<>();
                    specimens.addAll(exhibits);
                    break;
                } else if (operation == 2) {
                    for (Animal animal : exhibits) {
                        LOG.logAndShow(Level.INFO, "Goodbye " + animal.getName() + "... You *might* be missed.");
                    }
                    break;
                }
            } else {
                LOG.logAndShow(Level.SEVERE, "ERRONEOUS INPUT: Must input YES or NO." + System.lineSeparator());
            }
        }

        LOG.turnOffLogger();
    }
}
