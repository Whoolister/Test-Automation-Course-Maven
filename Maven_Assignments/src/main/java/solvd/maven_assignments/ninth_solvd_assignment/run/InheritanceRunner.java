package ninth_solvd_assignment.run;

import java.util.Scanner;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;

import ninth_solvd_assignment.battle.Arena;
import ninth_solvd_assignment.genetics.Laboratory;
import ninth_solvd_assignment.inheritance.Facility;
import ninth_solvd_assignment.inheritance.WildlifeReserve;
import ninth_solvd_assignment.utilities.MyLogger;

public final class InheritanceRunner {
	static final MyLogger LOG = new MyLogger(InheritanceRunner.class.getName());

	public static void main(String[] args) {
		String entryLine = "What do you want to do?" + System.lineSeparator() + "\t>-> Type 1 to go to the Zoo"
				+ System.lineSeparator() + "\t>-> Type 2 to go to the Arena" + System.lineSeparator()
				+ "\t>-> Type 3 to go to the Laboratory" + System.lineSeparator() + "\t>-> Type 4 to read the last logs"
				+ System.lineSeparator() + "\t>-> Type 5 to exit the program" + System.lineSeparator();

		// CHOOSE YOUR OWN ADVENTURE
		System.out.print(StringUtils.center("I N H E R I T A N C E  R U N N E R", 48) + System.lineSeparator()
				+ "---<>===<o>=====<O>===---  <:>  ---===<O>===<o>===<>---" + System.lineSeparator() + entryLine
				+ System.lineSeparator());

		try (Scanner scan = new Scanner(System.in)) {
			while (scan.hasNext()) {
				if (scan.hasNextInt()) {
					int choice = scan.nextInt();
					if (choice == 1) {
						WildlifeReserve.tour(scan);
						LOG.logAndShow(Level.FINE, entryLine);
					} else if (choice == 2) {
						Arena.hostTournament(scan);
						LOG.logAndShow(Level.FINE, entryLine);
					} else if (choice == 3) {
						Laboratory.visit(scan);
						LOG.logAndShow(Level.FINE, entryLine);
					} else if (choice == 4) {
						LOG.readLog();
						LOG.logAndShow(Level.FINE, entryLine);
					} else if (choice == 5) {
						Facility.closeFacilities();
						LOG.logAndShow(Level.INFO, StringUtils.center("E N D   O F   R U N T I M E", 48)
								+ System.lineSeparator() + "---<>===<o>=====<O>===---  <:>  ---===<O>===<o>===<>---");
						System.exit(0);
					} else {
						LOG.logAndShow(Level.FINE, "ERRONEOUS INPUT (" + choice + ") Must input 1, 2, 3, 4, or 5."
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
