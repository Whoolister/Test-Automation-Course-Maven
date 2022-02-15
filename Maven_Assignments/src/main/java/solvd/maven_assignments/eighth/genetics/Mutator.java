package solvd.maven_assignments.eighth.genetics;

@FunctionalInterface
public interface Mutator<E extends CharSequence> {
    E mutate(E base);
}
