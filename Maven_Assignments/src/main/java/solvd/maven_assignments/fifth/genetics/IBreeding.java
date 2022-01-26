package genetics;

import inheritance.Animal;

public interface IBreeding {
    void mixGenes();

    Animal offspring(Animal parent);
}
