package eighth_solvd_assignment.genetics;

import eighth_solvd_assignment.inheritance.Animal;

public interface IBreeding {
	public void mixGenes();

	public Animal offspring(Animal parent);
}
