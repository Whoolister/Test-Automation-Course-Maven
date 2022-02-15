package solvd.maven_assignments.third.inheritance;

public abstract class Invertebrate extends Animal {
    public Invertebrate(String respiration, String locomotion, String intelligence, String diet) {
        super(respiration, locomotion, intelligence, diet);

        evolve("Flexible Body Plan");
    }
}
