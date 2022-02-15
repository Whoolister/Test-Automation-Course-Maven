package solvd.maven_assignments.third.run;


import solvd.maven_assignments.third.inheritance.*;

import java.util.ArrayList;
import java.util.Random;

public class AnimalRunner {
    static ArrayList<Animal> collection = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("S T A R T\n"
                + "==========\n"
                + "ANIMAL INHERITANCE\n");

        int limit = 3;
        for (int index = 0; index < limit; index++) {
            switch ((new Random()).nextInt(5)) {
                case 0:
                    collection.add(new Arthropod());
                    break;
                case 1:
                    collection.add(new Mollusk());
                    break;
                case 2:
                    collection.add(new Reptile());
                    break;
                case 3:
                    collection.add(new Mammal());
                    break;
                case 4:
                    collection.add(new Fish());
                    break;
                case 5:
                    collection.add(new Alien());
            }
        }

        for (int index = 0; index < limit; index++) {
            Animal animal = collection.get(index);
            System.out.println(animal.toString() + "\n" + animal.flex() + "\n");
            animal.breathe();
            animal.move();
            animal.eat();
            animal.think();
        }
    }
}
