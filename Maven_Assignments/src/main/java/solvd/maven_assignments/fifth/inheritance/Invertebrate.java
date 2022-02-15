package solvd.maven_assignments.fifth.inheritance;

import solvd.maven_assignments.fifth.enums.*;

public abstract class Invertebrate extends Animal {
    protected Invertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        super(respiration, locomotion, intelligence, diet);

        evolve(SpecialTrait.FLEXIBLE_BODY_PLAN);
    }
}
