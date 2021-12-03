package sixth_solvd_assignment.genetics;

import sixth_solvd_assignment.inheritance.Animal;

public interface IBreeding {
	public void mixGenes();

	public Animal offspring(Animal parent);
}
