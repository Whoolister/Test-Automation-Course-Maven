package solvd.maven_assignments.sixth.inheritance;

import solvd.maven_assignments.sixth.enums.Diet;
import solvd.maven_assignments.sixth.enums.Intelligence;
import solvd.maven_assignments.sixth.enums.Locomotion;
import solvd.maven_assignments.sixth.enums.Respiration;

public class Hybrid extends Animal {
    public Hybrid(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        super(respiration, locomotion, intelligence, diet);
    }
}
