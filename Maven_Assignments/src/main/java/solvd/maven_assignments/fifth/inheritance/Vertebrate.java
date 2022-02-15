package solvd.maven_assignments.fifth.inheritance;

import solvd.maven_assignments.fifth.enums.*;

public abstract class Vertebrate extends Animal {
    protected Vertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        super(respiration, locomotion, intelligence, diet);

        evolve(SpecialTrait.ENDOSKELETON);
    }
}
