package ninth_solvd_assignment.genetics;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;

import eighth_solvd_assignment.inheritance.Animal;
import eighth_solvd_assignment.inheritance.Facility;
import eighth_solvd_assignment.utilities.Randomizer;

public class Nursery extends Facility {
	private static LinkedList<Animal> patients = new LinkedList<>();

	public static void visit(Scanner scanner) {
		openFacilities();

		LOG.logAndShow(Level.INFO,
				StringUtils.center("ENTERING THE NURSERY", 48) + System.lineSeparator()
						+ "`-:-.   ,-;\"`-:-.   ,-;\"`-:-.   ,-;\"`-:-.   ,-;\"`-:-.\n"
						+ "   `=`,'=/     `=`,'=/     `=`,'=/     `=`,'=/     `=`\n"
						+ "     y==/        y==/        y==/        y==/\n"
						+ "   ,=,-<=`.    ,=,-<=`.    ,=,-<=`.    ,=,-<=`.    ,=,\n"
						+ ",-'-'   `-=_,-'-'   `-=_,-'-'   `-=_,-'-'   `-=_,-'-'" + System.lineSeparator());

		boolean useRNG = true, selectPair = false;
		if (specimens.size() != 0) {
			LOG.logAndShow(Level.INFO,
					"What mode do you want to use?" + System.lineSeparator()
							+ ">-> Type 1 to select a pair from the saved exhibits" + System.lineSeparator()
							+ ">-> Type 2 to randomly generate a pair" + System.lineSeparator());

			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					int mode = scanner.nextInt();
					if (mode == 1) {
						useRNG = false;
						selectPair = true;
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
			LOG.logAndShow(Level.INFO,
					"Generating a random pair..." + System.lineSeparator() + "Press any key, and hit ENTER to begin:");
			scanner.next();

			patients.addAll(Randomizer.creatureCreator(2));

			display(patients, true);
		} else if (selectPair) {
			LOG.logAndShow(Level.INFO, "Displaying the specimens available:" + System.lineSeparator());

			display(specimens, true);

			LOG.logAndShow(Level.INFO, "Choose a specimen to pair:" + System.lineSeparator());
			while (scanner.hasNext() && patients.size() < 2) {
				if (scanner.hasNextInt()) {
					int selection = scanner.nextInt();
					if (selection > 0 && selection < 16) {
						patients.add(specimens.remove(selection - 1));
						break;
					} else {
						LOG.logAndShow(Level.SEVERE,
								"ERRONEOUS INPUT (" + selection + ") Must input a number between 1 and "
										+ specimens.size() + "." + System.lineSeparator());
					}
				} else {
					LOG.logAndShow(Level.SEVERE, "ERRONEOUS INPUT: Must be an integer." + System.lineSeparator());
					scanner.next();
				}
			}
		}

		LOG.logAndShow(Level.INFO, "Press any key, and hit ENTER to merge the pair:");
		scanner.next();

		Animal offspring = breedingPen(patients.peekFirst(), patients.peekLast());

		LOG.logAndShow(Level.INFO,
				offspring.toString() + System.lineSeparator() + offspring.breathe() + System.lineSeparator()
						+ offspring.move() + System.lineSeparator() + offspring.think() + System.lineSeparator()
						+ offspring.eat() + System.lineSeparator() + offspring.sleep() + System.lineSeparator() + "["
						+ offspring.getGenes() + "]" + System.lineSeparator());

		if (selectPair) {
			specimens.addAll(patients);
		}

		LOG.logAndShow(Level.INFO, StringUtils.center("E N D   O F   T H E   N U R S E R Y", 32)
				+ System.lineSeparator() + "__________________________________________");
	}

	public static Animal breedingPen(Animal firstParent, Animal secondParent) {
		return firstParent.breed(secondParent);
	}
}
