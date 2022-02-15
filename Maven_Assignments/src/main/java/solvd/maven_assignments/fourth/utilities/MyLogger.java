package solvd.maven_assignments.fourth.utilities;

import java.io.File;
import java.util.logging.*;

public class MyLogger extends Logger {

    public MyLogger(String name) {
        super(name, null);

        LogManager.getLogManager().reset();
        this.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);

        this.addHandler(ch);
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
}
