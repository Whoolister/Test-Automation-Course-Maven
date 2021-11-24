package sixth_solvd_assignment.interfaces;

import sixth_solvd_assignment.exceptions.BadVariableException;

public interface IAgriculture {
	public String cultivate() throws BadVariableException;

	public String raiseAnimals() throws BadVariableException;
}
