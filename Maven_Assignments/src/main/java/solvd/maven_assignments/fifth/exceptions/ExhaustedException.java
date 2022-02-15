package solvd.maven_assignments.fifth.exceptions;

public class ExhaustedException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ExhaustedException() {
        super(" tried to throw just one. More. Hit... and succumbed to exhaustion. ");
    }
}
