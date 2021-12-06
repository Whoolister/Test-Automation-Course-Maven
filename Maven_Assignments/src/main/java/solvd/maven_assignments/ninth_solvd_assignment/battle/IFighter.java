package ninth_solvd_assignment.battle;

import ninth_solvd_assignment.enums.Stat;
import ninth_solvd_assignment.exceptions.DefeatedException;
import ninth_solvd_assignment.exceptions.ExcessRankException;
import ninth_solvd_assignment.exceptions.ExhaustedException;
import ninth_solvd_assignment.exceptions.MissException;
import ninth_solvd_assignment.inheritance.Animal;

public interface IFighter {
	public void rankUP() throws ExcessRankException;

	public void generateBaseStatBlock();

	public void resetStatBlock();

	public int hit(Animal competitor) throws DefeatedException, ExhaustedException, MissException;

	public int receiveHit(int damage) throws DefeatedException;

	public int getRank();

	public int getBaseStat(Stat baseStat);

	public int getStat(Stat stat);

	public void changeBaseStat(Stat stat, int change);

	public void changeStat(Stat stat, int change);
}
