package solvd.maven_assignments.second.inheritance;

public abstract class Vertebrate extends Animal {

    public Vertebrate(String respiration, String locomotion, String intelligence, String diet) {
        super(respiration, locomotion, intelligence, diet);

        evolve("Vertebral Column");
        evolve("Protected Central Nervous System");
        evolve("Cranium");
    }
}
