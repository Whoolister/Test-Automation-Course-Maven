package solvd.maven_assignments.eighth.genetics;

@FunctionalInterface
public interface Decoder<E extends CharSequence> {
    boolean decode(E base);
}
