package eighth_solvd_assignment.genetics;

import eighth_solvd_assignment.inheritance.Animal;

public interface IBreeding {
	public Animal breed(Animal partner);

	public String splice();

	public String getGenes();
}
