package ninth_solvd_assignment.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.io.FileUtils;

public class MyLogger extends Logger {
	private static final File file = new File("InheritanceLog.txt");
	private static FileHandler fh;

	public MyLogger(String name) {
		super(name, null);

		this.setLevel(Level.ALL);
	}

	public void setupLogger() {
		try {
			fh = new FileHandler(file.getName());
			fh.setFormatter(new SimpleFormatter());
			fh.setLevel(Level.INFO);

			file.createNewFile();

			addHandler(fh);
		} catch (Exception e) {
			this.log(Level.SEVERE, "File Logger not Working", e);
		}
	}

	public void turnOffLogger() {
		for (Handler handler : this.getHandlers()) {
			handler.close();
		}
	}

	public void readLog() {

		if (file.exists()) {
			try {
				this.finest(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
			} catch (IOException e) {
				this.log(Level.SEVERE, "ERROR OCURRED READING THE LAST LOG", e);
			}
		}
	}

	public void logAndShow(Level level, String message) {
		System.out.println(message);

		this.log(level, message);
	}
}
