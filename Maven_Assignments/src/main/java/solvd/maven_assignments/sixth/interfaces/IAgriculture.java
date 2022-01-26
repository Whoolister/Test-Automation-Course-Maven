package sixth_solvd_assignment.interfaces;

import sixth_solvd_assignment.exceptions.BadVariableException;

public interface IAgriculture {
    String cultivate() throws BadVariableException;

    String raiseAnimals() throws BadVariableException;
}
