package solvd.maven_assignments.ninth.genetics;

import solvd.maven_assignments.ninth.inheritance.Animal;

public interface IBreeding {
    Animal breed(Animal partner);

    String splice();

    String getGenes();
}
