package solvd.maven_assignments.eighth.inheritance;

import solvd.maven_assignments.eighth.enums.*;

public abstract class Vertebrate extends Animal {
    protected Vertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
                         CyrcadianRythm cyrcadianRythm) {
        super(respiration, locomotion, intelligence, diet, cyrcadianRythm);

        evolve(SpecialTrait.ENDOSKELETON);
    }

    protected Vertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
                         CyrcadianRythm cyrcadianRythm, String geneSequence) {
        super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);
    }
}
