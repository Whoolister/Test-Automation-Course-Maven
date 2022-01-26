package battle;

import exceptions.DepletedHealthException;
import exceptions.NegativeStaminaException;
import inheritance.Animal;

public interface IFighter {
    void rankUP();

    boolean hit(Animal competitor) throws DepletedHealthException, NegativeStaminaException;

    boolean getHit(int damage) throws DepletedHealthException;
}
