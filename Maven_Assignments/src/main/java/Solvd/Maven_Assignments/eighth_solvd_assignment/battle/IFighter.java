package eighth_solvd_assignment.battle;

import eighth_solvd_assignment.exceptions.DefeatedException;
import eighth_solvd_assignment.exceptions.ExcessRankException;
import eighth_solvd_assignment.exceptions.ExhaustedException;
import eighth_solvd_assignment.exceptions.MissException;
import eighth_solvd_assignment.inheritance.Animal;

public interface IFighter {
	public void rankUP() throws ExcessRankException;

	public void generateStatBlock();

	public int hit(Animal competitor) throws DefeatedException, ExhaustedException, MissException;

	public int receiveHit(int damage) throws DefeatedException;
}
