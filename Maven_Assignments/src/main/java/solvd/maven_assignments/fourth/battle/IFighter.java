package solvd.maven_assignments.fourth.battle;

import solvd.maven_assignments.fourth.exceptions.DepletedHealthException;
import solvd.maven_assignments.fourth.exceptions.NegativeStaminaException;
import solvd.maven_assignments.fourth.inheritance.Animal;

public interface IFighter {
    void rankUP();

    boolean hit(Animal competitor) throws DepletedHealthException, NegativeStaminaException;

    boolean getHit(int damage) throws DepletedHealthException;
}
