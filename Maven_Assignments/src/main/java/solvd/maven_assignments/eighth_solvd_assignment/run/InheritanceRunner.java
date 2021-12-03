package eighth_solvd_assignment.run;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;

import eighth_solvd_assignment.battle.Arena;
import eighth_solvd_assignment.genetics.Nursery;
import eighth_solvd_assignment.inheritance.Animal;
import eighth_solvd_assignment.inheritance.Zoo;
import eighth_solvd_assignment.safari.Safari;
import eighth_solvd_assignment.utilities.MyLogger;

public final class InheritanceRunner {
	static final MyLogger LOG = new MyLogger(InheritanceRunner.class.getName());
	static ArrayList<Animal> collection = new ArrayList<>();

	public static void main(String[] args) {
		String entryLine = new String("What do you want to do?" + System.lineSeparator()
				+ "\t>-> Type 1 to go to the Zoo" + System.lineSeparator() + "\t>-> Type 2 to go to the Arena"
				+ System.lineSeparator() + "\t>-> Type 3 to go on a Safari" + System.lineSeparator()
				+ "\t>-> Type 4 to go to the Nursery" + System.lineSeparator() + "\t>-> Type 5 to read the last logs"
				+ System.lineSeparator() + "\t>-> Type 6 to exit the program" + System.lineSeparator());

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
						LOG.logAndShow(Level.INFO, StringUtils.center("E N D   O F   R U N T I M E", 48)
								+ System.lineSeparator() + "╚═══━━━─── • ───━━━━━━─── • ───━━━━━━─── • ───━━━═══╝");
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
	}
}
