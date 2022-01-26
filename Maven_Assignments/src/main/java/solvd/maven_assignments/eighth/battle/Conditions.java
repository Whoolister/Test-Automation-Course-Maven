package eighth_solvd_assignment.battle;

import eighth_solvd_assignment.inheritance.Animal;

@FunctionalInterface
public interface Conditions<E extends Animal> {
    void condition(E base);
}
