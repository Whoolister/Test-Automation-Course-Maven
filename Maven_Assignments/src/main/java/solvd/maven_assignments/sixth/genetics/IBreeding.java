package sixth_solvd_assignment.genetics;

import sixth_solvd_assignment.inheritance.Animal;

public interface IBreeding {
    void mixGenes();

    Animal offspring(Animal parent);
}
