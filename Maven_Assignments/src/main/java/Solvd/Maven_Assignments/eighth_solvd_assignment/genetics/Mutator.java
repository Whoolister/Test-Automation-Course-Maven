package eighth_solvd_assignment.genetics;

@FunctionalInterface
public interface Mutator<E> {
	public String mutate(E base);
}
