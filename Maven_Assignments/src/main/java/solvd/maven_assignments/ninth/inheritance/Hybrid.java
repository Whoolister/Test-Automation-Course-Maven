package solvd.maven_assignments.ninth.inheritance;

public class Hybrid extends Animal {
    public Hybrid(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
                  CyrcadianRythm cyrcadianRythm, String geneSequence) {
        super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);
    }

    @Override
    public String toString() {
        return "Hybrid [Name: " + getName() + " | Respiration: " + getRespiration() + " | Locomotion: "
                + getLocomotion() + " | Intelligence: " + getIntelligence() + " | Diet: " + getDiet()
                + " | Cyrcadian Rythm: " + getCyrcadianRythm() + "]";
    }
}
