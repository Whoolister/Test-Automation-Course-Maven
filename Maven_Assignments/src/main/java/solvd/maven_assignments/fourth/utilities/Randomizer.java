package utilities;

import inheritance.*;

import java.util.Random;

public final class Randomizer {
    private static final String[] sampleNames = {"Wobbegong", "Sparklemuffing", "Boops", "Sprongle", "Plumbus", "Fleeb", "Schleem", "Water Fly", "Imp", "Zombie", "Nidhogg", "Pomberito", "Tuyango", "Carbuncle", "Okpe", "Pira-Nu", "Amphitere"};
    private static final String[] sizes = {"Titanic", "Small", "Herculean", "Pigmy", "Jumbo", "Miniature"};
    private static final String[] colors = {"Azure", "Scarlet", "Indigo", "Brown", "Black", "Silver", "Gold", "Rainbow", "White", "Purple"};
    private static final String[] features = {"Fluffy", "Shaggy", "Prickly", "Bristly", "Sharp", "Slick", "Sticky"};

    public static String trueRandomString(int length) {
        StringBuilder result = new StringBuilder(length);

        String characters = "ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghijklmnopqrstuvxyz";

        for (int index = 0; index < length; index++) {
            int position = (int) (characters.length() * Math.random());

            result.append(characters.charAt(position));
        }

        return result.toString();
    }

    public static String animalNameGenerator(Animal animal) {
        String name = animal.getName();
        int rank = animal.getRank();

        String[] components = name.split(" ");

        switch (rank) {
            case 0:
                return sampleNames[new Random().nextInt(sampleNames.length)];
            case 1:
                return sizes[new Random().nextInt(sizes.length)] + " " + name;
            case 2:
                return components[0] + " " + colors[new Random().nextInt(colors.length)] + " " + components[1];
            case 3:
                return components[0] + " " + components[1] + " " + features[new Random().nextInt(features.length)] + components[2];
        }

        return animal.getName();
    }
}
