package solvd.maven_assignments.eighth.battle;


import solvd.maven_assignments.eighth.enums.Stat;
import solvd.maven_assignments.eighth.exceptions.DefeatedException;
import solvd.maven_assignments.eighth.exceptions.ExcessRankException;
import solvd.maven_assignments.eighth.exceptions.ExhaustedException;
import solvd.maven_assignments.eighth.exceptions.MissException;
import solvd.maven_assignments.eighth.inheritance.Animal;

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
