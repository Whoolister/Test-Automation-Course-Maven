package eighth_solvd_assignment.exceptions;

public class ExcessRankException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcessRankException() {
		super("More fights than are permitted were ocurring.");
	}
}