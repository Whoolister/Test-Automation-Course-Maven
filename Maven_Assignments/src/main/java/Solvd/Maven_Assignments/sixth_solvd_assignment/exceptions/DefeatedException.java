package sixth_solvd_assignment.exceptions;

public class DefeatedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int damage;

	public DefeatedException(int damage) {
		super(" ne final blow, and it was over for this creature. ");
		this.damage = damage;
	}

	public int getDamage() {
		return this.damage;
	}
}
