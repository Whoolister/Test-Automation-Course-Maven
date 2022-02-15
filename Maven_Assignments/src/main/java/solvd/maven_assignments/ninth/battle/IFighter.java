package solvd.maven_assignments.ninth.battle;

import solvd.maven_assignments.ninth.enums.Stat;
import solvd.maven_assignments.ninth.exceptions.DefeatedException;
import solvd.maven_assignments.ninth.exceptions.ExcessRankException;
import solvd.maven_assignments.ninth.exceptions.ExhaustedException;
import solvd.maven_assignments.ninth.exceptions.MissException;
import solvd.maven_assignments.ninth.inheritance.Animal;

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
