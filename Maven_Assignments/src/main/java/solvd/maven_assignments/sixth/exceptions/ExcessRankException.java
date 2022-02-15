package solvd.maven_assignments.sixth.exceptions;

public class ExcessRankException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ExcessRankException() {
        super("More fights than are permitted were ocurring.");
    }
}
