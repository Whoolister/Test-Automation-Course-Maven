package solvd.maven_assignments.ninth.battle;

import solvd.maven_assignments.ninth.inheritance.Animal;

@FunctionalInterface
public interface Conditions<E extends Animal> {
    void condition(E base);
}
