package sixth_solvd_assignment.utilities;

import java.util.ArrayList;
import java.util.Random;

import sixth_solvd_assignment.inheritance.*;

public final class Randomizer {
	private static String[] sampleNames = { "Wobbegong", "Boops", "Plumbus", "Imp", "Kelpie", "Selket", "Karkinos",
			"Barghest", "Vukodlak", "Bunyip", "Apophis", "Longma", "Pomberito", "Tuyango", "Carbunco", "Okpe",
			"Pira-Nu", "Younik", "Zlydzen", "Dzik", "Valasen" };
	private static String[] sizes = { "Titanic", "Small", "Herculean", "Pigmy", "Jumbo", "Miniature" };
	private static String[] colors = { "Azure", "Scarlet", "Indigo", "Brown", "Black", "Silver", "Gold", "Rainbow",
			"White", "Purple" };
	private static String[] features = { "Fluffy", "Shaggy", "Prickly", "Bristly", "Sharp", "Slick", "Sticky" };

	private static String[] hitAdjectives = { "Brutal", "Astounding", "Measly", "Awe-Inducing", "Dissapointing",
			"Incredible", "Boring", "Scrum-diddly-umptious", "Depressing", "Adequate", "Teeny-Weeny" };

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
			return components[0] + " " + components[1] + " " + features[new Random().nextInt(features.length)] + " "
					+ components[2];
		}

		return animal.getName();
	}

	public static ArrayList<Animal> creatureCreator(int amount) {
		ArrayList<Animal> list = new ArrayList<>();

		for (int index = 0; index < amount; index++) {
			switch ((new Random()).nextInt(6)) {
			case 0:
				list.add(new Arthropod());
				break;
			case 1:
				list.add(new Mollusk());
				break;
			case 2:
				list.add(new Reptile());
				break;
			case 3:
				list.add(new Mammal());
				break;
			case 4:
				list.add(new Fish());
				break;
			case 5:
				list.add(new Cnidarian());
				break;
			}
		}

		return list;
	}

	public static String hitAdjectiveGenerator() {
		return hitAdjectives[new Random().nextInt(hitAdjectives.length)];
	}
}
