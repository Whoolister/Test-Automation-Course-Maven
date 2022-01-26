package eighth_solvd_assignment.genetics;

@FunctionalInterface
public interface Mutator<E extends CharSequence> {
    E mutate(E base);
}
