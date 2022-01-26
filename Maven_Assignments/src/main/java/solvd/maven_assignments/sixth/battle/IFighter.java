package sixth_solvd_assignment.battle;

import sixth_solvd_assignment.exceptions.DefeatedException;
import sixth_solvd_assignment.exceptions.ExcessRankException;
import sixth_solvd_assignment.exceptions.ExhaustedException;
import sixth_solvd_assignment.exceptions.MissException;
import sixth_solvd_assignment.inheritance.Animal;

public interface IFighter {
    void rankUP() throws ExcessRankException;

    void generateStatBlock();

    int hit(Animal competitor) throws DefeatedException, ExhaustedException, MissException;

    int receiveHit(int damage) throws DefeatedException;
}
