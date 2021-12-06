package ninth_solvd_assignment.inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.stream.Collectors;

import ninth_solvd_assignment.utilities.MyLogger;
import ninth_solvd_assignment.utilities.Randomizer;

public class Facility {
	protected static ArrayList<Animal> specimens = new ArrayList<>(16);
	protected static final MyLogger LOG = new MyLogger(Facility.class.getName());
	protected static boolean isLogging = false;

	protected static void display(List<Animal> list, boolean numericalMode) {
		LOG.logAndShow(Level.INFO, ">< >< >< >< >< >< >< >< >< ><");
		if (numericalMode) {
			int id = 1;

			for (Animal animal : list) {
				LOG.logAndShow(Level.INFO,
						"Exhibit " + (id++) + "/" + list.size() + ": " + animal.getName() + "   ("
								+ animal.getClass().getSimpleName() + ")" + System.lineSeparator()
								+ "--<>--<>--<>--<>--<>--<>--<>--<>--" + System.lineSeparator() + animal.breathe()
								+ System.lineSeparator() + animal.move() + System.lineSeparator() + animal.eat()
								+ System.lineSeparator() + animal.think() + System.lineSeparator() + "["
								+ animal.getGenes() + "]" + System.lineSeparator());
			}
		} else {
			char id = 'A';

			for (Animal animal : list) {
				LOG.logAndShow(Level.INFO,
						"Exhibit " + (id++) + ": " + animal.getName() + "   (" + animal.getClass().getSimpleName() + ")"
								+ System.lineSeparator() + "--<>--<>--<>--<>--<>--<>--<>--<>--" + System.lineSeparator()
								+ animal.breathe() + System.lineSeparator() + animal.move() + System.lineSeparator()
								+ animal.eat() + System.lineSeparator() + animal.think() + System.lineSeparator()
								+ animal.sleep() + System.lineSeparator() + "[" + animal.getGenes() + "]"
								+ System.lineSeparator());
			}
		}
		LOG.logAndShow(Level.INFO, ">< >< >< >< >< >< >< >< >< ><" + System.lineSeparator());
	}

	protected static ArrayList<Animal> selectSpecimens(Scanner scanner) {
		Animal[] selections = new Animal[16];
		int pointer = 0;

		LOG.logAndShow(Level.INFO, "Displaying the specimens available:" + System.lineSeparator());

		display(specimens, true);

		LOG.logAndShow(Level.INFO, "Input the specimens you want to combine, or 0 if you're satisfied with the choices:"
				+ System.lineSeparator());
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				int selection = scanner.nextInt();
				if (selection > 0 && selection <= specimens.size()) {
					selections[pointer] = specimens.remove(selection - 1);
					pointer++;

					LOG.logAndShow(Level.INFO,
							"Specimen " + selection + " separated for breeding." + System.lineSeparator());
					display(specimens, true);
				} else if (selection == 0) {
					LOG.logAndShow(Level.INFO, "Returning the selected creatures." + System.lineSeparator());
					break;
				} else {
					LOG.logAndShow(Level.SEVERE,
							"ERRONEOUS INPUT (" + selection + ") Must input either 0, or a number between 1 and "
									+ specimens.size() + "." + System.lineSeparator());
				}
			} else {
				LOG.logAndShow(Level.SEVERE, "ERRONEOUS INPUT: Must be an integer." + System.lineSeparator());
				scanner.next();
			}
		}
		// STREAM IMPLEMENTATION
		return new ArrayList<>(Arrays.stream(selections)
				.sorted((first, second) -> first.getName().compareTo(second.getName())).collect(Collectors.toList()));
	}

	protected static ArrayList<Animal> rngSpecimens(Scanner scanner) {
		ArrayList<Animal> results = null;

		LOG.logAndShow(Level.INFO, "Input an amount (Up to 16) of creatures to generate:" + System.lineSeparator());

		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				int amount = scanner.nextInt();
				if (amount > 0 && amount <= 16) {
					LOG.logAndShow(Level.INFO, "Generating " + amount + " creatures..." + System.lineSeparator());
					// STREAM IMPLEMENTATION
					results = new ArrayList<>(Randomizer.creatureCreator(amount).stream()
							.sorted((first, second) -> first.getName().compareTo(second.getName()))
							.collect(Collectors.toList()));
					break;
				} else {
					LOG.logAndShow(Level.SEVERE, "ERRONEOUS INPUT (" + amount
							+ ") Must input either a number between 1 and 16" + System.lineSeparator());
				}
			} else {
				LOG.logAndShow(Level.SEVERE, "ERRONEOUS INPUT: Must be an integer." + System.lineSeparator());
				scanner.next();
			}
		}

		return results;
	}

	protected static void openFacilities() {
		if (!isLogging) {
			LOG.setupLogger();
		}
	}

	public static void closeFacilities() {
		LOG.turnOffLogger();
	}
}
