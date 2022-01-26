package eighth_solvd_assignment.inheritance;

import eighth_solvd_assignment.enums.*;

public class Hybrid extends Animal {
    public Hybrid(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
                  CyrcadianRythm cyrcadianRythm, String geneSequence) {
        super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);
    }

    @Override
    public String toString() {
        return "Hybrid [Name: " + this.name + " | Respiration: " + this.respiration + " | Locomotion: "
                + this.locomotion + " | Intelligence: " + this.intelligence + " | Diet: " + this.diet + "]";
    }
}
