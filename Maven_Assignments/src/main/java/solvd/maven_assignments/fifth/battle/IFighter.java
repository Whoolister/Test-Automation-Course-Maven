package solvd.maven_assignments.fifth.battle;

import solvd.maven_assignments.fifth.exceptions.DefeatedException;
import solvd.maven_assignments.fifth.exceptions.ExcessRankException;
import solvd.maven_assignments.fifth.exceptions.ExhaustedException;
import solvd.maven_assignments.fifth.exceptions.MissException;
import solvd.maven_assignments.fifth.inheritance.Animal;

public interface IFighter {
    void rankUP() throws ExcessRankException;

    void generateStatBlock();

    int hit(Animal competitor) throws DefeatedException, ExhaustedException, MissException;

    int receiveHit(int damage) throws DefeatedException;
}
