package solvd.maven_assignments.sixth.battle;

import solvd.maven_assignments.sixth.exceptions.DefeatedException;
import solvd.maven_assignments.sixth.exceptions.ExcessRankException;
import solvd.maven_assignments.sixth.exceptions.ExhaustedException;
import solvd.maven_assignments.sixth.exceptions.MissException;
import solvd.maven_assignments.sixth.inheritance.Animal;

public interface IFighter {
    void rankUP() throws ExcessRankException;

    void generateStatBlock();

    int hit(Animal competitor) throws DefeatedException, ExhaustedException, MissException;

    int receiveHit(int damage) throws DefeatedException;
}
