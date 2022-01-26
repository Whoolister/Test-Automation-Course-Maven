package eighth_solvd_assignment.inheritance;

import eighth_solvd_assignment.utilities.Randomizer;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;

public class Zoo extends Facility {
    private static final LinkedList<Animal> exhibits = new LinkedList<>();

    public static void tour(Scanner scanner) {
        openFacilities();

        LOG.logAndShow(Level.INFO,
                StringUtils.center("ENTERING THE ZOO", 48) + System.lineSeparator()
                        + "_|___|___|___|___|___|___|___|___|___|___|___|___|___|_\n"
                        + "___|___|___|___|___|___|___|___|___|___|___|___|___|___\n"
                        + "_|___|___|___|___|___|___|___|___|___|___|___|___|___|_" + System.lineSeparator());

        boolean useRNG = true;
        if (specimens.size() != 0) {
            LOG.logAndShow(Level.INFO,
                    "What mode do you want to use?" + System.lineSeparator()
                            + "\t>-> Type 1 to check the saved exhibits" + System.lineSeparator()
                            + "\t>-> Type 2 to randomly generate exhibits" + System.lineSeparator());

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int mode = scanner.nextInt();
                    if (mode == 1) {
                        useRNG = false;
                        exhibits.addAll(specimens);

                        display(exhibits, false);
                        break;
                    } else if (mode == 2) {
                        break;
                    } else {
                        LOG.logAndShow(Level.SEVERE,
                                "ERRONEOUS INPUT (" + mode + ") Must input 1 or 2." + System.lineSeparator());
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
                        LOG.logAndShow(Level.INFO, StringUtils.center("Generating " + amount + " animals...", 30));
                        exhibits.addAll(Randomizer.creatureCreator(amount));

                        display(exhibits, false);

                        break;
                    } else {
                        LOG.logAndShow(Level.INFO,
                                "ERRONEOUS INPUT (" + amount + "): Must input a number between 1 and 16.");
                    }
                } else {
                    LOG.logAndShow(Level.INFO, "ERRONEOUS INPUT: Must be an integer.");
                    scanner.next();
                }
            }
            LOG.logAndShow(Level.INFO,
                    "Do you want to save these creatures?" + System.lineSeparator() + "\t>-> Type 1 to save them"
                            + System.lineSeparator() + "\t>-> Type 2 to discard them, you monster..."
                            + System.lineSeparator());
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int operation = scanner.nextInt();
                    if (operation == 1) {
                        LOG.logAndShow(Level.INFO, "The generated exhibits have been saved to our specimens lab,"
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
        }

        LOG.logAndShow(Level.INFO, StringUtils.center("E N D   O F   T H E   T O U R", 32) + System.lineSeparator()
                + "__________________________________________");
    }
}
