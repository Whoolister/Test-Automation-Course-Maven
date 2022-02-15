package solvd.maven_assignments.fifth.genetics;

import solvd.maven_assignments.fifth.inheritance.Animal;

public interface IBreeding {
    void mixGenes();

    Animal offspring(Animal parent);
}
