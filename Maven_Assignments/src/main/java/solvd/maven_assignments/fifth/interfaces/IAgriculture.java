package solvd.maven_assignments.fifth.interfaces;

import solvd.maven_assignments.fifth.exceptions.BadVariableException;

public interface IAgriculture {
    String cultivate() throws BadVariableException;

    String raiseAnimals() throws BadVariableException;
}
