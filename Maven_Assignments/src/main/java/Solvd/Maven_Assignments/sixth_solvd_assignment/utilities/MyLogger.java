package sixth_solvd_assignment.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
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

	public void setupLogger(File file) {
		try {
			file.createNewFile();

			FileHandler fh = new FileHandler(file.getName());
			fh.setFormatter(new SimpleFormatter());
			fh.setLevel(Level.INFO);

			this.addHandler(fh);
		} catch (Exception e) {
			this.log(Level.SEVERE, "File Logger not Working", e);
		}
	}

	public void turnOffLogger(File file) {
		try {
			removeHandler(new FileHandler(file.getName()));
		} catch (SecurityException e) {

		} catch (IOException e) {

		}
	}

	public void readLog(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			StringBuilder content = new StringBuilder();
			String line = "";

			while ((line = reader.readLine()) != null) {
				content.append(line);
				content.append(System.lineSeparator());
			}

			this.fine(content.toString());
		} catch (IOException e) {
			this.log(Level.SEVERE, "ERROR OCURRED WHILE READING THE LOG FILE", e);
			System.exit(0);
		}
	}

	public void logAndShow(Level level, String message) {
		System.out.println(message);

		this.log(level, message);
	}
}
