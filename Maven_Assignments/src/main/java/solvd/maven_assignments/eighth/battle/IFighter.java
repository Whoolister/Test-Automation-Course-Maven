package eighth_solvd_assignment.battle;

import eighth_solvd_assignment.enums.Stat;
import eighth_solvd_assignment.exceptions.DefeatedException;
import eighth_solvd_assignment.exceptions.ExcessRankException;
import eighth_solvd_assignment.exceptions.ExhaustedException;
import eighth_solvd_assignment.exceptions.MissException;
import eighth_solvd_assignment.inheritance.Animal;

public interface IFighter {
    void rankUP() throws ExcessRankException;

    void generateBaseStatBlock();

    void resetStatBlock();

    int hit(Animal competitor) throws DefeatedException, ExhaustedException, MissException;

    int receiveHit(int damage) throws DefeatedException;

    int getRank();

    int getBaseStat(Stat baseStat);

    int getStat(Stat stat);

    void changeStat(Stat stat, int change);
}
