package solvd.maven_assignments.fourth.genetics;

import solvd.maven_assignments.fourth.inheritance.Animal;

public interface IBreeding {
    void mixGenes();

    Animal offspring(Animal parent);
}
