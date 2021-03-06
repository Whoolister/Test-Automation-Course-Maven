package solvd.maven_assignments.fifth.safari;

import solvd.maven_assignments.fifth.exceptions.BadVariableException;
import solvd.maven_assignments.fifth.inheritance.Animal;
import solvd.maven_assignments.fifth.inheritance.Facility;
import solvd.maven_assignments.fifth.utilities.CustomLinkedList;
import solvd.maven_assignments.fifth.utilities.Randomizer;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;

public class Safari extends Facility {
    private static final CustomLinkedList<Animal> wildlife = new CustomLinkedList<>();

    public static void expedition(Scanner scanner) {
        LOG.setupLogger();

        LOG.logAndShow(Level.INFO, "Commencing the expedition" + System.lineSeparator()
                + "==<O>===<0>===<O>===<0>===<O>==" + System.lineSeparator());

        int animalPopulation = new Random().nextInt(24) + 1;
        if (animalPopulation > 20) {
            LOG.logAndShow(Level.INFO,
                    "The hunting lands are teeming with life at this time, an excellent time to go on an expedition.");
        } else if (animalPopulation > 12) {
            LOG.logAndShow(Level.INFO,
                    "The day favors an expedition, there are plenty animal species, but just enough to not be bothersome.");
        } else if (animalPopulation > 4) {
            LOG.logAndShow(Level.INFO,
                    "Not many animals around today, it's gonna be very calm on the path... Maybe even boring.");
        } else {
            LOG.logAndShow(Level.INFO, "It's dead quiet, but who's to say there isn't a worthy find out there.");
        }

        for (Animal element : Randomizer.creatureCreator(animalPopulation)) {
            wildlife.insert(element);
        }

        char locale = 'A';
        boolean finished = false;
        while (wildlife.getLength() > 0 && !finished) {
            Animal wildFind = null;

            LOG.logAndShow(Level.INFO,
                    "Locale " + locale + System.lineSeparator() + Randomizer.randomPostcard() + System.lineSeparator()
                            + "---<O>===<O>===<O>===<O>---" + System.lineSeparator() + "What do you want to do?"
                            + System.lineSeparator() + "---<O>===<O>===<O>===<O>---" + System.lineSeparator()
                            + System.lineSeparator() + ">-> Type 1 to view the nearby specimen" + System.lineSeparator()
                            + ">-> Type 2 to go forward" + System.lineSeparator() + ">-> Type 3 to go backwards"
                            + System.lineSeparator() + ">-> Type 4 to finish the Safari" + System.lineSeparator());

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int action = scanner.nextInt();
                    if (action == 1) {
                        wildFind = wildlife.currentPointer();
                        break;
                    } else if (action == 2) {
                        if (wildlife.forwardPointer()) {
                            LOG.logAndShow(Level.INFO,
                                    "Roger that, heading toward the next locale . . ." + System.lineSeparator());
                            locale++;
                            break;
                        } else {
                            LOG.logAndShow(Level.INFO,
                                    "No can do, it's all uncharted territory up ahead, far too dangerous to keep advancing without proper equipment."
                                            + System.lineSeparator() + "What do you want to do?"
                                            + System.lineSeparator() + ">-> Type 1 to view the nearby specimen"
                                            + System.lineSeparator() + ">-> Type 3 to go backwards"
                                            + System.lineSeparator() + ">-> Type 4 to finish the Safari"
                                            + System.lineSeparator());
                        }
                    } else if (action == 3) {
                        if (wildlife.backwardPointer()) {
                            LOG.logAndShow(Level.INFO,
                                    "Roger that, coming back to the previous locale . . ." + System.lineSeparator());
                            locale--;
                            break;
                        } else {
                            finished = true;
                            break;
                        }
                    } else if (action == 4) {
                        finished = true;
                        break;
                    } else {
                        LOG.logAndShow(Level.SEVERE,
                                "ERRONEOUS INPUT: Must input 1, 2, or 3." + System.lineSeparator());
                    }
                } else {
                    LOG.logAndShow(Level.SEVERE, "ERRONEOUS INPUT: Must be an integer." + System.lineSeparator());
                    scanner.next();
                }
            }

            if (wildFind != null) {
                try {
                    LOG.logAndShow(Level.INFO, "That right there is a wild " + wildFind.getName()
                            + ", and let me nerd out over here for a minute... *ahem*" + System.lineSeparator()
                            + "--<>---<o>=====<o>---<>--" + System.lineSeparator() + wildFind.breathe()
                            + System.lineSeparator() + wildFind.move() + System.lineSeparator() + wildFind.think()
                            + System.lineSeparator() + wildFind.eat() + System.lineSeparator());
                } catch (BadVariableException e) {
                    LOG.logAndShow(Level.SEVERE,
                            "That... Uhhh... I thought animals weren't capable of doing that, to be honest . . ."
                                    + System.lineSeparator());
                }
                if (specimens.size() < 16) {
                    LOG.logAndShow(Level.INFO,
                            "So! What would you like to do with it?" + System.lineSeparator()
                                    + ">-> Type 1 to import the specimen into our reserves" + System.lineSeparator()
                                    + ">-> Type 2 to leave it be" + System.lineSeparator());

                    while (scanner.hasNext()) {
                        if (scanner.hasNextInt()) {
                            int action = scanner.nextInt();
                            if (action == 1) {
                                specimens.add(wildFind);
                                wildlife.deleteAtPointer();
                                LOG.logAndShow(Level.INFO,
                                        "Specimen successfully captured. Now, let's keep this expedition rolling.");
                                break;
                            } else if (action == 2) {
                                LOG.logAndShow(Level.INFO, "Fair enough.");
                                break;
                            } else {
                                LOG.logAndShow(Level.SEVERE,
                                        "ERRONEOUS INPUT: Must input 1 or 2." + System.lineSeparator());
                            }
                        } else {
                            LOG.logAndShow(Level.SEVERE,
                                    "ERRONEOUS INPUT: Must be an integer." + System.lineSeparator());
                            scanner.next();
                        }
                    }
                } else {
                    LOG.logAndShow(Level.INFO,
                            "I'm afraid our reserves back at HQ are full, so we have no choice but to leave this lil' fella to his own."
                                    + System.lineSeparator() + "Come on, let's keep going.");
                }
            }
        }

        LOG.logAndShow(Level.INFO, "E N D   O F   E X P E D I T I O N" + System.lineSeparator()
                + ">==<O>===<0>- -<0>===<O>==<" + System.lineSeparator());

        LOG.turnOffLogger();
    }
}
