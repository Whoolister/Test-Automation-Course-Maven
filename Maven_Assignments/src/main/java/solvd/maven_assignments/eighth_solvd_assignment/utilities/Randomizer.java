package eighth_solvd_assignment.utilities;

import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import eighth_solvd_assignment.inheritance.Animal;
import eighth_solvd_assignment.inheritance.Arthropod;
import eighth_solvd_assignment.inheritance.Cnidarian;
import eighth_solvd_assignment.inheritance.Fish;
import eighth_solvd_assignment.inheritance.Mammal;
import eighth_solvd_assignment.inheritance.Mollusk;
import eighth_solvd_assignment.inheritance.Reptile;

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
	// INCOMING MESS
	private static String[] postcards = { "              .\n" + "               					\n"
			+ "              |					\n" + "     .               /				\n"
			+ "      \\       I     				\n" + "                  /\n" + "        \\  ,g88R_\n"
			+ "          d888(`  ).                   _\n" + " -  --==  888(     ).=--           .+(`  )`.\n"
			+ ")         Y8P(       '`.          :(   .    )\n" + "        .+(`(      .   )     .--  `.  (    ) )\n"
			+ "       ((    (..__.:'-'   .=(   )   ` _`  ) )\n" + "`.     `(       ) )       (   .  )     (   )  ._\n"
			+ "  )      ` __.:'   )     (   (   ))     `-'.:(`  )\n"
			+ ")  )  ( )       --'       `- __.'         :(      ))\n"
			+ ".-'  (_.'          .')                    `(    )  ))\n"
			+ "                  (_  )                     ` __.:'\n" + "                                        	\n"
			+ "--..,___.--,--'`,---..-.--+--.,,-,,..._.--..-._.-.:.--.",
			"              ,.  _~-.,               .\n" + "           ~'`_ \\/,_. \\_\n"
					+ "          / ,\"_>@`,__`~.)             |           .\n"
					+ "          | |  @@@@'  \",! .           .          '\n"
					+ "          |/   ^^@     .!  \\          |         /\n"
					+ "          `' .^^^     ,'    '         |        .             .\n"
					+ "           .^^^   .          \\                /          .\n"
					+ "          .^^^       '  .     \\       |      /       . '\n"
					+ ".,.,.     ^^^             ` .   .,+~'`^`'~+,.     , '\n"
					+ "&&&&&&,  ,^^^^.  . ._ ..__ _  .'             '. '_ __ ____ __ _ .. .  .\n"
					+ "%%%%%%%%%^^^^^^%%&&;_,.-=~'`^`'~=-.,__,.-=~'`^`'~=-.,__,.-=~'`^`'~=-.,\n"
					+ "&&&&&%%%%%%%%%%%%%%%%%%&&;,.-=~'`^`'~=-.,__,.-=~'`^`'~=-.,__,.-=~'`^`'~=\n"
					+ "%%%%%&&&&&&&&&&&%%%%&&&_,.;^`'~=-.,__,.-=~'`^`'~=-.,__,.-=~'`^`'~=-.,__,\n"
					+ "%%%%%%%%%&&&&&&&&&-=~'`^`'~=-.,__,.-=~'`^`'~=-.,__,.-==--^'~=-.,__,.-=~'\n"
					+ "##mjy#####*\"'\r\n"
					+ "_,.-=~'`^`'~=-.,__,.-=~'`^`'~=-.,__,.-=~'`^`'~=-.,.-=~'`^`'~=-.,__,.-=~'\n" + "\n"
					+ "~`'^`'~=-.,__,.-=~'`^`'~=-.,__,.-=~'`^`'~=-.,__,.-=~'`^`'~=-.,__,.-=~'`^",
			"                      _\n" + "                     /#\\\n" + "                    /###\\     /\\\n"
					+ "                   /  ###\\   /##\\  /\\\n" + "                  /      #\\ /####\\/##\\\n"
					+ "                 /  /      /   # /  ##\\             _       /\\\n"
					+ "               // //  /\\  /    _/  /  #\\ _         /#\\    _/##\\    /\\\n"
					+ "              // /   /  \\     /   /    #\\ \\      _/###\\_ /   ##\\__/ _\\\n"
					+ "             /  \\   / .. \\   / /   _   { \\ \\   _/       / //    /    \\\\\n"
					+ "     /\\     /    /\\  ...  \\_/   / / \\   } \\ | /  /\\  \\ /  _    /  /    \\ /\\\n"
					+ "  _ /  \\  /// / .\\  ..%:.  /... /\\ . \\ {:  \\\\   /. \\     / \\  /   ___   /  \\\n"
					+ " /.\\ .\\.\\// \\/... \\.::::..... _/..\\ ..\\:|:. .  / .. \\\\  /.. \\    /...\\ /  \\ \\\n"
					+ "/...\\.../..:.\\. ..:::::::..:..... . ...\\{:... / %... \\\\/..%. \\  /./:..\\__   \\\n"
					+ " .:..\\:..:::....:::;;;;;;::::::::.:::::.\\}.....::%.:. \\ .:::. \\/.%:::.:..\\\n"
					+ "::::...:::;;:::::;;;;;;;;;;;;;;:::::;;::{:::::::;;;:..  .:;:... ::;;::::..\n"
					+ ";;;;:::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;];;;;;;;;;;::::::;;;;:.::;;;;;;;;:..\n"
					+ ";;;;;;;;;;;;;;ii;;;;;;;;;;;;;;;;;;;;;;;;[;;;;;;;;;;;;;;;;;;;;;;:;;;;;;;;;;;;;\n"
					+ ";;;;;;;;;;;;;;;;;;;iiiiiiii;;;;;;;;;;;;;;};;ii;;iiii;;;;i;;;;;;;;;;;;;;;ii;;;\n"
					+ "iiii;;;iiiiiiiiiiIIIIIIIIIIIiiiiiIiiiiii{iiIIiiiiiiiiiiiiiiii;;;;;iiiilliiiii\n"
					+ "IIIiiIIllllllIIlllIIIIlllIIIlIiiIIIIIIIIIIIIlIIIIIllIIIIIIIIiiiiiiiillIIIllII\n"
					+ "IIIiiilIIIIIIIllTIIIIllIIlIlIIITTTTlIlIlIIIlIITTTTTTTIIIIlIIllIlIlllIIIIIIITT\n"
					+ "IIIIilIIIIITTTTTTTIIIIIIIIIIIIITTTTTIIIIIIIIITTTTTTTTTTIIIIIIIIIlIIIIIIIITTTT\n"
					+ "IIIIIIIIITTTTTTTTTTTTTIIIIIIIITTTTTTTTIIIIIITTTTTTTTTTTTTTIIIIIIIIIIIIIITTTTT",
			"    .                  .-.    .  _   *     _   .\n"
					+ "           *          /   \\     ((       _/ \\       *    .\n"
					+ "         _    .   .--'\\/\\_ \\     `      /    \\  *    ___\n"
					+ "     *  / \\_    _/ ^      \\/\\'__        /\\/\\  /\\  __/   \\ *\n"
					+ "       /    \\  /    .'   _/  /  \\  *' /    \\/  \\/ .`'\\_/\\   .\n"
					+ "  .   /\\/\\  /\\/ :' __  ^/  ^/    `--./.'  ^  `-.\\ _    _:\\ _\n"
					+ "     /    \\/  \\  _/  \\-' __/.' ^ _   \\_   .'\\   _/ \\ .  __/ \\\n"
					+ "   /\\  .-   `. \\/     \\ / -.   _/ \\ -. `_/   \\ /    `._/  ^  \\\n"
					+ "  /  `-.__ ^   / .-'.--'    . /    `--./ .-'  `-.  `-. `.  -  `.\n"
					+ "@/        `.  / /      `-.   /  .-'   / .   .'   \\    \\  \\  .-  \\%\n"
					+ "@&8jgs@@%% @)&@&(88&@.-_=_-=_-=_-=_-=_.8@% &@&&8(8%@%8)(8@%8 8%@)%\n"
					+ "@88:::&(&8&&8:::::%&`.~-_~~-~~_~-~_~-~~=.'@(&%::::%@8&8)::&#@8::::\n"
					+ "`::::::8%@@%:::::@%&8:`.=~~-.~~-.~~=..~'8::::::::&@8:::::&8:::::'\n"
					+ " `::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::.'",
			"  ` : | | | |:  ||  :     `  :  |  |+|: | : : :|   .        `              .\n"
					+ "      ` : | :|  ||  |:  :    `  |  | :| : | : |:   |  .                    :\n"
					+ "         .' ':  ||  |:  |  '       ` || | : | |: : |   .  `           .   :.\n"
					+ "                `'  ||  |  ' |   *    ` : | | :| |*|  :   :               :|\n"
					+ "        *    *       `  |  : :  |  .      ` ' :| | :| . : :         *   :.||\n"
					+ "             .`            | |  |  : .:|       ` | || | : |: |          | ||\n"
					+ "      '          .         + `  |  :  .: .         '| | : :| :    .   |:| ||\n"
					+ "         .                 .    ` *|  || :       `    | | :| | :      |:| |\n"
					+ " .                .          .        || |.: *          | || : :     :|||\n"
					+ "        .            .   . *    .   .  ` |||.  +        + '| |||  .  ||`\n"
					+ "     .             *              .     +:`|!             . ||||  :.||`\n"
					+ " +                      .                ..!|*          . | :`||+ |||`\n"
					+ "     .                         +      : |||`        .| :| | | |.| ||`     .\n"
					+ "       *     +   '               +  :|| |`     :.+. || || | |:`|| `\n"
					+ "                            .      .||` .    ..|| | |: '` `| | |`  +\n"
					+ "  .       +++                      ||        !|!: `       :| |\n"
					+ "              +         .      .    | .      `|||.:      .||    .      .    `\n"
					+ "          '                           `|.   .  `:|||   + ||'     `\n"
					+ "  __    +      *                         `'       `'|.    `:\n"
					+ "\"'  `---\"\"\"----....____,..^---`^``----.,.___          `.    `.  .    ____,.,-\n"
					+ "    ___,--'\"\"`---\"'   ^  ^ ^        ^       \"\"\"'---,..___ __,..---\"\"'\n"
					+ "--\"'                           ^                         ``--..,__",
			"            .   :  ;   ,          ___\n" + "\"\"------.__  \\.      ,/    .----'\"   \"\"`--.\n"
					+ "____.------'-   ,--.  -    \"\"-------'\"\"\"\"\n"
					+ "\\_______-_-=___/____\\__=-_-_______/\";\\.____\n"
					+ "`\\.              --           .--'   \\\"-.\n"
					+ ". `\\._          \"\" --          \"\"\"\\\"\"/\"\"\n"
					+ " `    `\"--..    _--                \"\n" + "     --',.---'   - \"\n"
					+ "----'\"\"\"         \"_-\n" + "  /                                ____,,....__\n"
					+ "/                   ___..------'\"\"\"            `\"\"",
			"     .    _    +     .  ______   .          .\n" + "  (      /|\\      .    |      \\      .   +\n"
					+ "      . |||||     _    | |   | | ||         .\n" + " .      |||||    | |  _| | | | |_||    .\n"
					+ "    /\\  ||||| .  | | |   | |      |       .\n"
					+ " __||||_|||||____| |_|_____________\\__________\n"
					+ " . |||| |||||  /\\   _____      _____  .   .\n"
					+ "   |||| ||||| ||||   .   .  .         ________\n"
					+ "  . \\|`-'|||| ||||    __________       .    .\n"
					+ "     \\__ |||| ||||      .          .     .\n" + "  __    ||||`-'|||  .       .    __________\n"
					+ " .    . |||| ___/  ___________             .\n"
					+ "    . _ ||||| . _               .   _________\n"
					+ " _   ___|||||__  _ \\\\--//    .          _\n"
					+ "      _ `---'    .)=\\oo|=(.   _   .   .    .\n" + " _  ^      .  -    . \\.|" };

	public static String trueRandomString(int length) {
		StringBuilder result = new StringBuilder(length);

		String characters = "ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghijklmnopqrstuvxyz";

		for (int index = 0; index < length; index++) {
			int position = (int) (characters.length() * Math.random());

			result.append(characters.charAt(position));
		}

		return result.toString();
	}

	public static String randomPostcard() {
		return postcards[new Random().nextInt(postcards.length)];
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

	public static String nucleotideRandomizer(String geneSequence) {
		while (geneSequence.length() < 32) {
			geneSequence += new Random().nextInt(10) < 5 ? new Random().nextInt(10) < 5 ? "A" : "C"
					: new Random().nextInt(10) < 5 ? "T" : "G";
		}

		return StringUtils.rotate(geneSequence, new Random().nextInt(16) + 1);
	}
}
