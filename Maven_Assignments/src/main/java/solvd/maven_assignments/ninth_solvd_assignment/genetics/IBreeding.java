package ninth_solvd_assignment.genetics;

import ninth_solvd_assignment.inheritance.Animal;

public interface IBreeding {
	public Animal breed(Animal partner);

	public String splice();

	public String getGenes();
}
