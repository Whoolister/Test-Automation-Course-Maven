package ninth_solvd_assignment.battle;

import ninth_solvd_assignment.enums.Stat;
import ninth_solvd_assignment.exceptions.DefeatedException;
import ninth_solvd_assignment.exceptions.ExcessRankException;
import ninth_solvd_assignment.exceptions.ExhaustedException;
import ninth_solvd_assignment.exceptions.MissException;
import ninth_solvd_assignment.inheritance.Animal;

public interface IFighter {
    void rankUP() throws ExcessRankException;

    void generateBaseStatBlock();

    void resetStatBlock();

    int hit(Animal competitor) throws DefeatedException, ExhaustedException, MissException;

    int receiveHit(int damage) throws DefeatedException;

    int getRank();

    int getBaseStat(Stat baseStat);

    int getStat(Stat stat);

    void changeBaseStat(Stat stat, int change);

    void changeStat(Stat stat, int change);
}
