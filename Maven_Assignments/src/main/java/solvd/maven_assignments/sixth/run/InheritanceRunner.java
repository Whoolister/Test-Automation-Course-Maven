package solvd.maven_assignments.sixth.run;

import solvd.maven_assignments.sixth.battle.Arena;
import solvd.maven_assignments.sixth.inheritance.Animal;
import solvd.maven_assignments.sixth.inheritance.Zoo;
import solvd.maven_assignments.sixth.safari.Safari;
import solvd.maven_assignments.sixth.utilities.MyLogger;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

public final class InheritanceRunner {
    static final MyLogger LOG = new MyLogger(InheritanceRunner.class.getName());
    static ArrayList<Animal> collection = new ArrayList<>();

    public static void main(String[] args) {
        String entryLine = "What do you want to do?" + System.lineSeparator() + ">-> Type 1 to go to the Zoo"
                + System.lineSeparator() + ">-> Type 2 to go to the Arena" + System.lineSeparator()
                + ">-> Type 3 to go on a Safari" + System.lineSeparator() + ">-> Type 4 to go to the Nursery"
                + System.lineSeparator() + ">-> Type 5 to read the last logs" + System.lineSeparator()
                + ">-> Type 6 to exit the program" + System.lineSeparator();

        // CHOOSE YOUR OWN ADVENTURE
        System.out.print("I N H E R I T A N C E  R U N N E R" + System.lineSeparator()
                + ">==<O>===<0>===<OO>===<0>===<O>==<" + System.lineSeparator() + entryLine + System.lineSeparator());

        try (Scanner scan = new Scanner(System.in)) {
            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    int choice = scan.nextInt();
                    if (choice == 1) {
                        Zoo.tour(scan);
                        LOG.logAndShow(Level.FINE, entryLine);
                    } else if (choice == 2) {
                        Arena.hostTournament(scan);
                        LOG.logAndShow(Level.FINE, entryLine);
                    } else if (choice == 3) {
                        Safari.expedition(scan);
                        LOG.logAndShow(Level.FINE, entryLine);
                    } else if (choice == 4) {
                        LOG.logAndShow(Level.FINE, "Feature Unavailable, choose another." + System.lineSeparator()
                                + entryLine + System.lineSeparator());
                    } else if (choice == 5) {
                        LOG.readLog();
                        LOG.logAndShow(Level.FINE, entryLine);
                    } else if (choice == 6) {
                        LOG.logAndShow(Level.SEVERE, "Bye Bye!");
                        System.exit(0);
                    } else {
                        LOG.logAndShow(Level.FINE,
                                "ERRONEOUS INPUT: Must input 1, 2, 3, 4, or 5." + System.lineSeparator());
                    }
                } else {
                    System.out.print("ERRONEOUS INPUT: Must be an integer." + System.lineSeparator());
                    scan.next();
                }
            }
        }
        LOG.turnOffLogger();
    }
}
