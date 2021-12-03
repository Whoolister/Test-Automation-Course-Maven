package ninth_solvd_assignment.genetics;

@FunctionalInterface
public interface Mutator<E extends CharSequence> {
	public E mutate(E base);
}
