package interfaces;

import exceptions.BadVariableException;

public interface IAgriculture {
    String cultivate() throws BadVariableException;

    String raiseAnimals() throws BadVariableException;
}
