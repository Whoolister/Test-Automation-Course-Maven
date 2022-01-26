package ninth_solvd_assignment.battle;

import ninth_solvd_assignment.inheritance.Animal;

@FunctionalInterface
public interface StatMutator<E extends Animal> {
    void mutateStat(E base);
}
