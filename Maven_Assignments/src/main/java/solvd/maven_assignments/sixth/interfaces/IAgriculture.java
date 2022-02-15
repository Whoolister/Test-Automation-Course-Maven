package solvd.maven_assignments.sixth.interfaces;

import solvd.maven_assignments.sixth.exceptions.BadVariableException;

public interface IAgriculture {
    String cultivate() throws BadVariableException;

    String raiseAnimals() throws BadVariableException;
}
