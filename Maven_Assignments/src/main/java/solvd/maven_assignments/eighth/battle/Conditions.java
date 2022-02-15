package solvd.maven_assignments.eighth.battle;

import solvd.maven_assignments.eighth.inheritance.Animal;

@FunctionalInterface
public interface Conditions<E extends Animal> {
    void condition(E base);
}
