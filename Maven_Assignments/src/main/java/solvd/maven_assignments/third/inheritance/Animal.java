package solvd.maven_assignments.third.inheritance;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Animal {
    protected ArrayList<String> specialTraits;
    protected String respiration;
    protected String locomotion;
    protected String intelligence;
    protected String diet;

    public Animal(String respiration, String locomotion, String intelligence, String diet) {
        this.specialTraits = new ArrayList<>();
        this.respiration = respiration;
        this.locomotion = locomotion;
        this.intelligence = intelligence;
        this.diet = diet;
    }

    protected void evolve(String trait) {
        specialTraits.add(trait);
    }

    public void breathe() {
        switch (this.respiration) {
            case "Lungs":
                System.out.println("This being takes air into their lungs, to then extract molecular oxygen from the atmoshpere.");
                break;
            case "Gills":
                System.out.println("This being filters the water for oxygen, the stronger the water flow, the more efficient the oxygen intake,");
                break;
            case "Skin Diffusion":
                System.out.println("This being takes in air from the air through their skin, letting oxygen diffuse straight into their cells.");
                break;
        }
    }

    public void move() {
        switch (this.locomotion) {
            case "Bipedal":
                System.out.println("This being walks on two legs, and a mostly upright posture.");
                break;
            case "Quadrupedal":
                System.out.println("This being walks on four legs, possibly the most efficient method of terrestrial locomotion.");
                break;
            case "Multi-Legged":
                System.out.println("This being walks on a myriad of legs, allowing them to both walk and grip onto surfaces at the same time.");
                break;
            case "Winged":
                System.out.println("This being can lift off the ground and soar!");
                break;
            case "Finned":
                System.out.println("This being swims through the water, using their fins.");
                break;
            case "Tentacles":
                System.out.println("This being moves through the use of several prehensile arms; granting them incredible versatility, but leaving them frail.");
                break;
            case "None":
                System.out.println("This being just... sorta stays there...");
        }
    }

    public void eat() {
        switch (this.diet) {
            case "Omnivorous":
                System.out.println("This being can feast on every type of organic matter, it's likely to have evolved with resilience as it's main strength.");
                break;
            case "Carnivorous":
                System.out.println("This being only eats the remains of other animals.");
                break;
            case "Herbivorous":
                System.out.println("This being gets it's meals from plant matter.");
        }
    }

    public void think() {
        switch (this.intelligence) {
            case "Population Based":
                System.out.println("This being is as smart as their kin are numerous, working off an eusocial network of pheromones and chemical trails.");
                break;
            case "None":
                System.out.println("*Elevator Music*");
                break;
            case "Some":
                System.out.println("This being is concerned only with matters of acquiring food, and staying away from predators.");
                break;
            case "Intermediate":
                System.out.println("This being can form social bonds, and even learn through trial and error.");
                break;
            case "High":
                System.out.println("This being is a natural at complex problem solving, even going out of their way to satisfy a primal sense of curiosity.");
                break;
            case "Sapient":
                System.out.println("This being has no limit to their potential, and is capable of surpassing their biology, and start creating or advancing technology.");
                break;
            case "Eldritch":
                System.out.println("This being is, by all means, incomprehensible to mere creatures of the flesh.");
        }
    }

    public final String flex() {
        String result = "This being has acquired some very unique and helpful characteristics, including:";
        for (int index = 0; index < specialTraits.size(); index++) {
            result += "\n>->-> " + specialTraits.get(index) + "!";
        }

        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diet, intelligence, locomotion, respiration, specialTraits);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Animal))
            return false;
        Animal other = (Animal) obj;
        return Objects.equals(diet, other.diet) && Objects.equals(intelligence, other.intelligence)
                && Objects.equals(locomotion, other.locomotion) && Objects.equals(respiration, other.respiration)
                && Objects.equals(specialTraits, other.specialTraits);
    }
}
