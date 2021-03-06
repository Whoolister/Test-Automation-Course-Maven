package solvd.maven_assignments.eighth.run;

import org.apache.commons.lang3.StringUtils;
import solvd.maven_assignments.eighth.battle.Arena;
import solvd.maven_assignments.eighth.genetics.Nursery;
import solvd.maven_assignments.eighth.inheritance.Animal;
import solvd.maven_assignments.eighth.inheritance.Facility;
import solvd.maven_assignments.eighth.inheritance.Zoo;
import solvd.maven_assignments.eighth.safari.Safari;
import solvd.maven_assignments.eighth.utilities.MyLogger;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

public final class InheritanceRunner {
    static final MyLogger LOG = new MyLogger(InheritanceRunner.class.getName());
    static ArrayList<Animal> collection = new ArrayList<>();

    public static void main(String[] args) {
        String entryLine = "What do you want to do?" + System.lineSeparator()
                + "\t>-> Type 1 to go to the Zoo" + System.lineSeparator() + "\t>-> Type 2 to go to the Arena"
                + System.lineSeparator() + "\t>-> Type 3 to go on a Safari" + System.lineSeparator()
                + "\t>-> Type 4 to go to the Nursery" + System.lineSeparator() + "\t>-> Type 5 to read the last logs"
                + System.lineSeparator() + "\t>-> Type 6 to exit the program" + System.lineSeparator();

        // CHOOSE YOUR OWN ADVENTURE
        System.out.print(StringUtils.center("I N H E R I T A N C E  R U N N E R", 48) + System.lineSeparator()
                + "╔═══━━━─── • ───━━━━━━─── • ───━━━━━━─── • ───━━━═══╗" + System.lineSeparator() + entryLine
                + System.lineSeparator());

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
                        Nursery.visit(scan);
                        LOG.logAndShow(Level.FINE, entryLine);
                    } else if (choice == 5) {
                        LOG.readLog();
                        LOG.logAndShow(Level.FINE, entryLine);
                    } else if (choice == 6) {
                        Facility.closeFacilities();
                        LOG.logAndShow(Level.INFO, StringUtils.center("E N D   O F   R U N T I M E", 48)
                                + System.lineSeparator() + "╚═══━━━─── • ───━━━━━━─── • ───━━━━━━─── • ───━━━═══╝");
                        System.exit(0);
                    } else {
                        LOG.logAndShow(Level.FINE, "ERRONEOUS INPUT (" + choice + ") Must input 1, 2, 3, 4, 5, or 6."
                                + System.lineSeparator());
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
