package eighth_solvd_assignment.genetics;

import eighth_solvd_assignment.inheritance.Animal;

public interface IBreeding {
    Animal breed(Animal partner);

    String splice();

    String getGenes();
}
