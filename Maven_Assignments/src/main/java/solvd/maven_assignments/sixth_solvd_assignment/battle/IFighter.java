package sixth_solvd_assignment.battle;

import sixth_solvd_assignment.exceptions.DefeatedException;
import sixth_solvd_assignment.exceptions.ExcessRankException;
import sixth_solvd_assignment.exceptions.ExhaustedException;
import sixth_solvd_assignment.exceptions.MissException;
import sixth_solvd_assignment.inheritance.Animal;

public interface IFighter {
	public void rankUP() throws ExcessRankException;

	public void generateStatBlock();

	public int hit(Animal competitor) throws DefeatedException, ExhaustedException, MissException;

	public int receiveHit(int damage) throws DefeatedException;
}
