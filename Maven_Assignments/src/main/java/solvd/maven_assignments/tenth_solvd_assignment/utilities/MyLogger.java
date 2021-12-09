package tenth_solvd_assignment.utilities;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger extends Logger {
	public MyLogger(String name) {
		super(name, null);

		LogManager.getLogManager().reset();
		this.setLevel(Level.ALL);
	}

	public void setupLogger() {
		ConsoleHandler ch = new ConsoleHandler();
		ch.setFormatter(new SimpleFormatter());
		ch.setLevel(Level.ALL);
		this.addHandler(ch);
	}
}
