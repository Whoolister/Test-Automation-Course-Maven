package run;

import battle.Arena;
import inheritance.*;
import utilities.MyLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BattleRunner {
    static final MyLogger LOG = new MyLogger(Logger.GLOBAL_LOGGER_NAME);
    static final File file = new File("BattleLog.txt");
    static ArrayList<Animal> fighters = new ArrayList<>();


    public static void main(String[] args) {
        //CHOOSE YOUR OWN ADVENTURE
        LOG.fine("T O U R N A M E N T\n"
                + "==========\n"
                + "What do you want to do?\n"
                + "\t♦ Type 1 to go to the Arena\n"
                + "\t♦ Type 2 to read the last log\n");

        try (Scanner scan = new Scanner(System.in)) {
            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    int choice = scan.nextInt();
                    if (choice == 1) {
                        LOG.setupLogger(file);
                        tournament();
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

    static void tournament() {
        LOG.info("ENTERING THE TOURNAMENT\n"
                + "==========");
        LOG.fine("Input an amount of animals for the competiotion, up to 16, and press enter:\n");

        int limit;
        //ROUNDS OUT THE NUMBER, AND MAKES SURE IT'S A POSITIVE
        try (Scanner scan = new Scanner(System.in)) {
            limit = Math.round(Math.abs(scan.nextInt()));
        }

        LOG.info("Generating " + limit + " animals...\n");

        for (int index = 0; index < limit; index++) {
            switch ((new Random()).nextInt(6)) {
                case 0:
                    fighters.add(new Arthropod());
                    break;
                case 1:
                    fighters.add(new Mollusk());
                    break;
                case 2:
                    fighters.add(new Reptile());
                    break;
                case 3:
                    fighters.add(new Mammal());
                    break;
                case 4:
                    fighters.add(new Fish());
                    break;
                case 5:
                    fighters.add(new Cnidarian());
                    break;
            }
        }

        LOG.info("INITIAL BRACKET\n"
                + "==========\n"
                + Arena.bracketMaker(fighters));

        int fights = 1;
        for (int index = 0; index < limit; index += 2) {
            try {
                LOG.info(fights + "° Encounter: " + fighters.get(index).getName() + " Vs " + fighters.get(index + 1).getName() + "\n"
                        + Arena.hostFight(fighters.get(index), fighters.get(index + 1)));
            } catch (IndexOutOfBoundsException e) {
                LOG.severe("There's no fighter to put up against " + fighters.get(index).getName() + "! They'll climb up to the second tier of fights, but won't rank up.\n");
            }

            fights++;
        }
        //INCOMPLETE
        LOG.info("SEMIFINAL BRACKET\n"
                + "==========\n"
                + "");
    }

    static void archives() {
        try (BufferedReader reader = new BufferedReader(new FileReader("BattleLog.txt"))) {
            StringBuilder content = new StringBuilder();
            String line = "";

            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }

            LOG.fine(content.toString());
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "ERROR OCURRED WHILE READING THE LOG FILE", e);
            System.exit(0);
        }
    }
}
