package solvd.maven_assignments.ninth.genetics;

@FunctionalInterface
public interface Decoder<E extends CharSequence> {
    boolean decode(E base);
}
