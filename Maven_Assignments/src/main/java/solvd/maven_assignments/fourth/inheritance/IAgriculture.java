package solvd.maven_assignments.fourth.inheritance;

import solvd.maven_assignments.fourth.exceptions.BadVariableException;

public interface IAgriculture {
    String cultivate() throws BadVariableException;

    String raiseAnimals() throws BadVariableException;
}
