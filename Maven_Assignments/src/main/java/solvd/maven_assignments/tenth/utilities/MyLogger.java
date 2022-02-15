package solvd.maven_assignments.tenth.utilities;

import java.util.logging.*;

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
