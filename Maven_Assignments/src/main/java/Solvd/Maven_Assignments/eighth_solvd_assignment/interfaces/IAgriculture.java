package eighth_solvd_assignment.interfaces;

import eighth_solvd_assignment.exceptions.BadVariableException;

public interface IAgriculture {
	public String cultivate() throws BadVariableException;

	public String raiseAnimals() throws BadVariableException;
}
