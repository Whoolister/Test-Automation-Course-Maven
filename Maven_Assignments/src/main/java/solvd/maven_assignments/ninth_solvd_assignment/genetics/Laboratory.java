package ninth_solvd_assignment.genetics;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Scanner;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;

import ninth_solvd_assignment.enums.CyrcadianRythm;
import ninth_solvd_assignment.enums.Diet;
import ninth_solvd_assignment.enums.Intelligence;
import ninth_solvd_assignment.enums.Locomotion;
import ninth_solvd_assignment.enums.Respiration;
import ninth_solvd_assignment.enums.SpecialTrait;
import ninth_solvd_assignment.inheritance.Animal;
import ninth_solvd_assignment.inheritance.Facility;
import ninth_solvd_assignment.utilities.Randomizer;

public class Laboratory extends Facility {
	public static void visit(Scanner scanner) {
		openFacilities();
		ArrayList<Animal> patients = null;

		LOG.logAndShow(Level.INFO,
				StringUtils.center("ENTERING THE LABORATORY", 48) + System.lineSeparator()
						+ "`-:-.   ,-;\"`-:-.   ,-;\"`-:-.   ,-;\"`-:-.   ,-;\"`-:-.\n"
						+ "   `=`,'=/     `=`,'=/     `=`,'=/     `=`,'=/     `=`\n"
						+ "     y==/        y==/        y==/        y==/\n"
						+ "   ,=,-<=`.    ,=,-<=`.    ,=,-<=`.    ,=,-<=`.    ,=,\n"
						+ ",-'-'   `-=_,-'-'   `-=_,-'-'   `-=_,-'-'   `-=_,-'-'" + System.lineSeparator());

		if (specimens.size() > 1) {
			LOG.logAndShow(Level.INFO,
					"What mode do you want to use?" + System.lineSeparator()
							+ "\t>-> Type 1 to mate a pair from the saved exhibits" + System.lineSeparator()
							+ "\t>-> Type 2 to mate randomly generated creatures" + System.lineSeparator()
							+ "\t>-> Type 3 to clone a specimen" + System.lineSeparator());

			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					int mode = scanner.nextInt();
					if (mode == 1) {
						patients = selectSpecimens(scanner);
						break;
					} else if (mode == 2) {
						LOG.logAndShow(Level.INFO, "Generating a random pair..." + System.lineSeparator());
						patients = new ArrayList<>(Randomizer.creatureCreator(2));

						display(patients, true);
						break;
					} else if (mode == 3) {
						cloningLab(scanner);
						break;
					} else {
						LOG.logAndShow(Level.SEVERE,
								"ERRONEOUS INPUT (" + mode + ") Must input 1, 2, or 3." + System.lineSeparator());
					}
				} else {
					LOG.logAndShow(Level.SEVERE, "ERRONEOUS INPUT: Must be an integer." + System.lineSeparator());
					scanner.next();
				}
			}
		} else {
			LOG.logAndShow(Level.INFO,
					"What mode do you want to use?" + System.lineSeparator()
							+ "\t>-> Type 1 to mate a randomly generated pair" + System.lineSeparator()
							+ "\t>-> Type 2 to clone a specimen" + System.lineSeparator());

			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					int mode = scanner.nextInt();
					if (mode == 1) {
						LOG.logAndShow(Level.INFO, "Generating a random pair..." + System.lineSeparator());
						patients = new ArrayList<>(Randomizer.creatureCreator(2));

						display(patients, true);
						break;
					} else if (mode == 2) {
						cloningLab(scanner);
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

		if (patients != null) {
			LOG.logAndShow(Level.INFO, "Press any key, and hit ENTER to merge the pair:");
			scanner.next();

			Animal offspring = patients.remove(0).breed(patients.remove(0));

			display(Collections.singletonList(offspring), false);
			LOG.logAndShow(Level.INFO, "This creature has the following genes active:" + System.lineSeparator()
					+ "--<>--<>--<>--<>--<>--<>--<>--<>--");
			// STREAM IMPLEMENTATION
			Arrays.stream(SpecialTrait.values()).filter(trait -> trait.getDecoder().decode(offspring.getGenes()))
					.forEach(trait -> LOG.logAndShow(Level.INFO, "\t>" + trait.name()));

			LOG.logAndShow(Level.INFO,
					">< >< >< >< >< >< >< >< >< ><" + System.lineSeparator() + "Do you want to save this creature?"
							+ System.lineSeparator() + "\t>-> Type 1 to save them" + System.lineSeparator()
							+ "\t>-> Type 2 to set them free" + System.lineSeparator());
			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					int operation = scanner.nextInt();
					if (operation == 1) {
						LOG.logAndShow(Level.INFO,
								"This animal has been saved in our specimens bay," + System.lineSeparator()
										+ "you may choose to retrieve them as fighters in the arena."
										+ System.lineSeparator());
						specimens.add(offspring);
						break;
					} else if (operation == 2) {
						LOG.logAndShow(Level.INFO, "Setting free " + offspring.getName());
						break;
					} else {
						LOG.logAndShow(Level.SEVERE,
								"ERRONEOUS INPUT (" + operation + ") Must input 1 or 2." + System.lineSeparator());
					}
				} else {
					LOG.logAndShow(Level.SEVERE, "ERRONEOUS INPUT: Must be an integer." + System.lineSeparator());
					scanner.next();

				}
			}
		}
		LOG.logAndShow(Level.INFO, StringUtils.center("L E A V I N G   T H E   L A B O R A T O R Y", 32)
				+ System.lineSeparator() + "__________________________________________");
	}

	private static void cloningLab(Scanner scanner) {
		ArrayList<Animal> vats = null;
		if (specimens.size() != 0) {
			LOG.logAndShow(Level.INFO,
					"What mode do you want to use?" + System.lineSeparator() + "\t>-> Type 1 to clone random specimens"
							+ System.lineSeparator() + "\t>-> Type 2 to select specimens to clone"
							+ System.lineSeparator());

			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					int mode = scanner.nextInt();
					if (mode == 1) {
						vats = rngSpecimens(scanner);
						break;
					} else if (mode == 2) {
						vats = selectSpecimens(scanner);
						break;
					} else {
						LOG.logAndShow(Level.SEVERE,
								"ERRONEOUS INPUT (" + mode + ") Must input 1, 2, or 3." + System.lineSeparator());
					}
				} else {
					LOG.logAndShow(Level.SEVERE, "ERRONEOUS INPUT: Must be an integer." + System.lineSeparator());
					scanner.next();
				}
			}
		} else {
			LOG.logAndShow(Level.INFO,
					"No specimens currently available to clone, head to the random generation wing:");

			vats = rngSpecimens(scanner);
		}

		ArrayList<Animal> clones = new ArrayList<>();
		for (Animal animal : vats) {
			try {
				// MAKES A PLACEHOLDER OBJECT
				Animal clone = animal.getClass().getConstructor().newInstance();
				for (Field field : animal.getClass().getDeclaredFields()) {
					field.setAccessible(true);
					// CHECKS TO SEE IF A FIELD IS NULL OR FINAL
					if (field.get(animal) == null || Modifier.isFinal(field.getModifiers())) {
						continue;
					}
					// CHECKS TO SEE IF THE FIELD IS PRIMITIVE, AN ENUM, OR AN ENUM MAP
					if (field.getType().isPrimitive() || field.getType().equals(String.class)
					// I SIMPLY CANNOT GET THE NAMES TO BE THE SAME
					// AND I THINK THAT'S DUE TO NAME GENERATION BEING RANDOM
					// I HAVE HOWEVER TRIED TO SET NAMES MANUALLY AND WOULDN'T BE ALLOWED
							|| field.getType().equals(Respiration.class) || field.getType().equals(Locomotion.class)
							|| field.getType().equals(Intelligence.class) || field.getType().equals(Diet.class)
							|| field.getType().equals(CyrcadianRythm.class)) {
						field.set(clone, field.get(animal));
					} else if (field.getType() == EnumMap.class) {
						Object map = field.getType().getConstructor(EnumMap.class).newInstance(field.get(animal));

						field.set(clone, map);
					}
				}
				clones.add(clone);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.logAndShow(Level.INFO, "Displaying ORIGINALS:");
		display(vats, false);
		LOG.logAndShow(Level.INFO, "Displaying COPIES:");
		display(clones, false);

		LOG.logAndShow(Level.INFO, StringUtils.center("L E A V I N G   T H E   C L O N I N G   B A Y", 32)
				+ System.lineSeparator() + "__________________________________________");
	}
}
