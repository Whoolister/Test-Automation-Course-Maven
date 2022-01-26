package ninth_solvd_assignment.genetics;

import ninth_solvd_assignment.inheritance.Animal;

public interface IBreeding {
    Animal breed(Animal partner);

    String splice();

    String getGenes();
}
