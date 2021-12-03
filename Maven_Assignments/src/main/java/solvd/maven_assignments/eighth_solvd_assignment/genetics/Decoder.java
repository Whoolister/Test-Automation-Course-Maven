package eighth_solvd_assignment.genetics;

@FunctionalInterface
public interface Decoder<E extends CharSequence> {
	public boolean decode(E base);
}
