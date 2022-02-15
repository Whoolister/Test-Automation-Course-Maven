package solvd.maven_assignments.sixth.genetics;

import solvd.maven_assignments.sixth.inheritance.Animal;

public interface IBreeding {
    void mixGenes();

    Animal offspring(Animal parent);
}
