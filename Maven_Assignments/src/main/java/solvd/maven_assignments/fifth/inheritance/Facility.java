package solvd.maven_assignments.fifth.inheritance;

import solvd.maven_assignments.fifth.utilities.MyLogger;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Facility {
    protected static final MyLogger LOG = new MyLogger(Logger.GLOBAL_LOGGER_NAME);
    protected static ArrayList<Animal> specimens = new ArrayList<>();
}
