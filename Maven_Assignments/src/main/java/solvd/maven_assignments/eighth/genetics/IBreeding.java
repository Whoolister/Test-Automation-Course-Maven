package solvd.maven_assignments.eighth.genetics;

import solvd.maven_assignments.eighth.inheritance.Animal;

public interface IBreeding {
    Animal breed(Animal partner);

    String splice();

    String getGenes();
}
