package solvd.maven_assignments.ninth.genetics;

@FunctionalInterface
public interface Mutator<E extends CharSequence> {
    E mutate(E base);
}
