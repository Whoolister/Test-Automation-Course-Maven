package solvd.maven_assignments.ninth.battle;

import solvd.maven_assignments.ninth.inheritance.Animal;

@FunctionalInterface
public interface StatMutator<E extends Animal> {
    void mutateStat(E base);
}
