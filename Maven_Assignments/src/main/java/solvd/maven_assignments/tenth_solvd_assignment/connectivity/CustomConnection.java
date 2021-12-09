package tenth_solvd_assignment.connectivity;

import tenth_solvd_assignment.utilities.MyLogger;

public class CustomConnection {
	// MOCK DB CONNECTION CLASS
	private static final MyLogger LOG = new MyLogger(CustomConnection.class.getName());
	static {
		LOG.setupLogger();
	}

	public void ping(String threadName) {
		LOG.info("Pinging " + threadName);
	}

	public void authorize(String threadName) {
		LOG.info("Authorizing entry for " + threadName);
	}

	public void status(String threadName) {
		LOG.info("Entry succesful for " + threadName);
	}
}
