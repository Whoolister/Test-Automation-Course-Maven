package eighth_solvd_assignment.inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import eighth_solvd_assignment.utilities.MyLogger;

public class Facility {
	protected static ArrayList<Animal> specimens;
	protected static final MyLogger LOG = new MyLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void display(List<Animal> list, boolean numericalMode) {
		LOG.logAndShow(Level.INFO, ">< >< >< >< >< >< >< >< >< ><");
		if (numericalMode) {
			int id = 1;

			for (Animal animal : list) {
				LOG.logAndShow(Level.INFO,
						"Exhibit " + (id++) + "/" + list.size() + ": " + animal.getName() + System.lineSeparator()
								+ "--<>--<>--<>--<>--<>--<>--<>--<>--" + System.lineSeparator() + animal.breathe()
								+ System.lineSeparator() + animal.move() + System.lineSeparator() + animal.eat()
								+ System.lineSeparator() + animal.think() + System.lineSeparator());
			}
		} else {
			char id = 'A';

			for (Animal animal : list) {
				LOG.logAndShow(Level.INFO,
						"Exhibit " + (id++) + ": " + animal.getName() + System.lineSeparator()
								+ "--<>--<>--<>--<>--<>--<>--<>--<>--" + System.lineSeparator() + animal.breathe()
								+ System.lineSeparator() + animal.move() + System.lineSeparator() + animal.eat()
								+ System.lineSeparator() + animal.think() + System.lineSeparator());
			}
		}
		LOG.logAndShow(Level.INFO, ">< >< >< >< >< >< >< >< >< ><" + System.lineSeparator());
	}
}
