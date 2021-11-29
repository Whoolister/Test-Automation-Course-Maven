package eighth_solvd_assignment.exceptions;

public class MissException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissException() {
		super(" tried to land a hit, but the foe dodged the blow... ");
	}
}
