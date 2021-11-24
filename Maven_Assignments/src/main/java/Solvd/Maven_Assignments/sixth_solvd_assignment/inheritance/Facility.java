package sixth_solvd_assignment.inheritance;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

import sixth_solvd_assignment.utilities.MyLogger;

public class Facility {
	protected static ArrayList<Animal> specimens;

	static final MyLogger LOG = new MyLogger(Logger.GLOBAL_LOGGER_NAME);

	protected static final File zoo = new File("ZooLog.txt");
	protected static final File arena = new File("ArenaLog.txt");
	protected static final File nursery = new File("NurseryLog.txt");

	public static File getZooLog() {
		return zoo;
	}

	public static File getArenaLog() {
		return arena;
	}

	public static File getNurseryLog() {
		return nursery;
	}
}
