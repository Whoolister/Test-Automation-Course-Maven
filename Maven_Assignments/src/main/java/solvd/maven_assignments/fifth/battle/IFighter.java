package battle;

import exceptions.DefeatedException;
import exceptions.ExcessRankException;
import exceptions.ExhaustedException;
import exceptions.MissException;
import inheritance.Animal;

public interface IFighter {
    void rankUP() throws ExcessRankException;

    void generateStatBlock();

    int hit(Animal competitor) throws DefeatedException, ExhaustedException, MissException;

    int receiveHit(int damage) throws DefeatedException;
}
