package ninth_solvd_assignment.enums;

import ninth_solvd_assignment.battle.Conditions;
import ninth_solvd_assignment.inheritance.Animal;

public enum Weather {
	// THESE ARE ALL GOOD ICONS, TRUST ME
	CLEAR_DAY("The sun graces the land with a delicate warmth.",
			"                             |\n" + "      ;   :   ;\n" + "   .   \\_,!,_/   ,\n" + "    `.,'     `.,'\n"
					+ "     /         \\\n" + "~ -- :         : -- ~\n" + "     \\         /\n" + "    ,'`._   _.'`.\n"
					+ "   '   / `!` \\   `\n" + "      ;   :   ;  ",
			(base) -> {
				base.changeStat(Stat.ENERGY_POINTS, 2);
			}),
	NIGHT("Under the moonlight, the predators still see bright as day.",
			"                         ___---___\n" + "                      .--         --.\n"
					+ "                    ./   ()      .-. \\.\n" + "                   /   o    .   (   )  \\\n"
					+ "                  / .            '-'    \\\n" + "                 | ()    .  O         .  |\n"
					+ "                |                         |\n" + "                |    o           ()       |\n"
					+ "                |       .--.          O   |\n" + "                 | .   |    |            |\n"
					+ "                  \\    `.__.'    o   .  /\n" + "                   \\                   /\n"
					+ "                    `\\  o    ()      /'\n" + "                      `--___   ___--'\n"
					+ "                            ---"
					+ ".'                                                                           `",
			(base) -> {
				if (base.getEnum(CyrcadianRythm.class) == CyrcadianRythm.CREPUSCULAR
						|| base.getEnum(CyrcadianRythm.class) == CyrcadianRythm.NOCTURNAL) {
					base.changeStat(Stat.CRITICAL_CHANCE, 8);
					base.changeStat(Stat.SPEED, 8);
				} else {
					base.changeStat(Stat.CRITICAL_CHANCE, -15);
					base.changeStat(Stat.SPEED, -12);
				}
			}),
	HARSH_SUNLIGHT("The sun strikes is scorching the earth with all it's might.", "                        |\n"
			+ "                    .   |\n" + "                        |\n"
			+ "          \\    *        |     *    .  /\n" + "            \\        *  |  .        /\n"
			+ "         .    \\     ___---___     /    .\n" + "                \\.--         --./\n"
			+ "     ~-_    *  ./               \\.   *   _-~\n" + "        ~-_   /                   \\   _-~     *\n"
			+ "   *       ~-/                     \\-~\n" + "     .      |                       |      .\n"
			+ "         * |                         | *\n" + "-----------|                         |-----------\n"
			+ "  .        |                         |        .\n" + "        *   |                       | *\n"
			+ "           _-\\                     /-_    *\n" + "     .  _-~ . \\                   /   ~-_\n"
			+ "     _-~       `\\               /'*      ~-_\n" + "    ~           /`--___   ___--'\\           ~\n"
			+ "           *  /        ---     .  \\\n" + "            /     *     |           \\\n"
			+ "          /             |   *         \\\n" + "                     .  |        .\n"
			+ "                        |\n" + "                        |", (base) -> {
				if (base.getEnum(Respiration.class) != Respiration.LUNGS) {
					base.changeStat(Stat.HEALTH_POINTS, -15);
					base.changeStat(Stat.ENERGY_POINTS, -2);
					base.changeStat(Stat.SPEED, -5);
				}
				if (base.getEnum(Locomotion.class) == Locomotion.SLITHERING
						|| base.getEnum(Locomotion.class) == Locomotion.TENTACLES) {
					base.changeStat(Stat.ENERGY_POINTS, -2);
					base.changeStat(Stat.SPEED, -5);
				}
			}),
	HEAVY_RAIN("An unrelenting downpour, to most it's an inconvenience, but not all.",
			"        ------               _____\n" + "       /      \\ ___\\     ___/    ___\n"
					+ "    --/-  ___  /    \\/  /  /    /   \\\n" + "   /     /           \\__     //_     \\\n"
					+ "  /                     \\   / ___     |\n" + "  |           ___       \\/+--/        /\n"
					+ "   \\__           \\       \\           /\n" + "      \\__                 |          /\n"
					+ "     \\     /____      /  /       |   /\n" + "      _____/         ___       \\/  /\\\n"
					+ "           \\__      /      /    |    |\n" + "         /    \\____/   \\       /   //\n"
					+ "     // / / // / /\\    /-_-/\\//-__-\n" + "      /  /  // /   \\__// / / /  //\n"
					+ "     //   / /   //   /  // / // /\n" + "      /// // / /   /  //  / //\n"
					+ "   //   //       //  /  // / /\n" + "     / / / / /     /  /    /\n"
					+ "  ///  / / /  //  // /  // //\n" + "     ///    /    /    / / / /\n"
					+ "///  /    // / /  // / / /  /\n" + "   // ///   /      /// / /",
			(base) -> {
				if (base.getEnum(Respiration.class) == Respiration.GILLS
						|| base.getEnum(Respiration.class) == Respiration.SKIN_DIFFUSION) {
					base.changeStat(Stat.ENERGY_POINTS, 3);
				} else {
					base.changeStat(Stat.ENERGY_POINTS, -1);
					base.changeStat(Stat.SPEED, -8);
					base.changeStat(Stat.CRITICAL_CHANCE, -8);
				}
				if (base.getEnum(Locomotion.class) != Locomotion.SLITHERING
						|| base.getEnum(Locomotion.class) != Locomotion.TENTACLES) {
					base.changeStat(Stat.SPEED, -4);
				} else {
					base.changeStat(Stat.SPEED, 4);
				}
			}),
	FLOOD("The balance has been broken, and the land can't contain the currents any longer.",
			"                              _____,,,\\//,,\\\\,/,\n" + "                             /-- --- --- -----\n"
					+ "                            ///--- --- -- - ----\n"
					+ "                           o////- ---- --- --\n"
					+ "                           !!//o/---  -- --\n"
					+ "                         o*) !///,~,,\\\\,\\/,,/,//,,\n"
					+ "                           o!*!o'(\\          /\\\n"
					+ "                         | ! o \",) \\/\\  /\\  /  \\/\\\n"
					+ "                        o  !o! !!|    \\/  \\/     /\n"
					+ "                       ( * (  o!'; |\\   \\       /\n"
					+ "                        o o ! * !` | \\  /       \\\n"
					+ "                       o  |  o 'o| | :  \\       /\n"
					+ "                        *  o !*!': |o|  /      /\n"
					+ "                            (o''| `| : /      /\n"
					+ "                            ! *|'`  \\|/       \\\\\n"
					+ "                           ' !o!':\\  \\\\        \\\n"
					+ "                            ( ('|  \\  `._______/\n"
					+ "////\\\\\\,,\\///,,,,\\,/oO._*  o !*!'`  `.________/\n"
					+ "  ---- -- ------- - -oO*OoOo (o''|           /\n"
					+ "    --------  ------ 'oO*OoO!*|'o!!          \\\n"
					+ "-------  -- - ---- --* oO*OoO *!'| '         /\n"
					+ " ---  -   -----  ---- - oO*OoO!!':o!'       /\n"
					+ " - -  -----  -  --  - *--oO*OoOo!`         /\n"
					+ "   \\\\\\\\\\,,,\\\\,//////,\\,,\\\\\\/,,,\\,,",
			(base) -> {
				if (base.getEnum(Locomotion.class) == Locomotion.FINNED) {
					base.changeStat(Stat.SPEED, 10);
					base.changeStat(Stat.CRITICAL_CHANCE, 12);
				} else if (base.getEnum(Locomotion.class) != Locomotion.WINGED) {
					base.changeStat(Stat.HEALTH_POINTS, -25);
					base.changeStat(Stat.ENERGY_POINTS, -3);
					base.changeStat(Stat.SPEED, -15);
					base.changeStat(Stat.DEFENSE, -2);
				}
			}),
	SANDSTORM("Raging winds against the arid surface have kicked up a sandstorm.",
			"         .        .                  --_-_-_-_---\n" + "         .        .    `#####@@!$$`     -_-_-_\n"
					+ "    .    _    +    ((  \"####@@!!$$    ))-_-_- .\n"
					+ " (      /|\\      .     `#####@@!$$`  )) -__-\n"
					+ "     . |||||     _   ((  '####@!!$:     _-_  .\n"
					+ ".      |||||    | | ((  ,####@!!$:   )) _-\n" + "   /\\  ||||| .  | |    .###@!!$:       -_ .\n"
					+ "__||||_|||||____| |____`##@@!$:___\\__ _-______\n"
					+ ". |||| |||||  /\\   ____`#@!!$ _____  .   .\n"
					+ "  |||| ||||| ||||   .   .`#@!$:       ________\n"
					+ " . \\|`-'|||| ||||    ____`#@!$:       .    .\n" + "    \\__ |||| ||||   '`\\   \"!$: /`'  .  \n"
					+ " __    ||||`-'|||  .    '\\  '!: /'  _____\n"
					+ ".    . |||| ___/  ________\"\\ : /\"         .\n"
					+ "   . _ ||||| . _               .   _________\n" + "_   ___|||||__  _ \\\\--//    .          _\n"
					+ "     _ `---'    .)=\\oo|=(.   _   .   .    .\n" + "_  ^      .  -    . \\.|",
			(base) -> {
				base.changeStat(Stat.HEALTH_POINTS, -10);
				base.changeStat(Stat.SPEED, -12);
			}),
	HAIL("Frigid projectiles rain down from the sky.",
			"                ()\n" + "                /\\\n" + "               //\\\\\n" + "              <<  >>\n"
					+ "          ()   \\\\//   ()\n" + "()._____   /\\   \\\\   /\\   _____.()\n"
					+ "   \\.--.\\ //\\\\ //\\\\ //\\\\ /.--./\n" + "    \\\\__\\\\/__\\//__\\//__\\\\/__//\n"
					+ "     '--/\\\\--//\\--//\\--/\\\\--'\n" + "        \\\\\\\\///\\\\//\\\\\\////\n"
					+ "    ()-= >>\\\\< <\\\\> >\\\\<< =-()\n" + "        ////\\\\\\//\\\\///\\\\\\\\\n"
					+ "     .--\\\\/--\\//--\\//--\\//--.\n" + "    //\"\"/\\\\\"\"//\\\"\"//\\\"\"//\\\"\"\\\\\n"
					+ "   /'--'/ \\\\// \\\\// \\\\// \\'--'\\\n" + " ()`\"\"\"`   \\/   //   \\/   `\"\"\"\"`()\n"
					+ "          ()   //\\\\   ()\n" + "              <<  >>\n" + "               \\\\//\n"
					+ "                \\/\n" + "                ()",
			(base) -> {
				base.changeStat(Stat.HEALTH_POINTS, -15);
				base.changeStat(Stat.ENERGY_POINTS, -3);
				base.changeStat(Stat.SPEED, -8);
			}),
	STRONG_WINDS("Local air currents have picked up plenty of speed, and proceed to slam against the land.",
			"   ((  \"####@@!!$$    ))\n" + "       `#####@@!$$`  ))\n" + "    ((  '####@!!$:\n"
					+ "   ((  ,####@!!$:   ))\n" + "       .###@!!$:\n" + "       `##@@!$:\n" + "        `#@!!$\n"
					+ "  !@#    `#@!$:       @#$\n" + "   #$     `#@!$:       !@!\n" + "            '@!$:\n"
					+ "        '`\\   \"!$: /`'\n" + "           '\\  '!: /'\n" + "             \"\\ : /\"\n"
					+ "  -.\"-/\\\\\\-.\"//.-\"/:`\\.\"-.-//\".\"-=_\\\\\n"
					+ "\" -.\"-.\\\\\"-.\"//.-\".`-.\"_\\\\-.\".-\\\".-//",
			(base) -> {
				if (base.getEnum(Locomotion.class) == Locomotion.WINGED) {
					base.changeStat(Stat.SPEED, 20);
					base.changeStat(Stat.HIT_DAMAGE, 2);
					base.changeStat(Stat.CRITICAL_CHANCE, 10);
				} else {
					base.changeStat(Stat.SPEED, -15);
				}
			});

	private String description;
	private String icon;
	private Conditions<Animal> condition;

	private Weather(String description, String icon, Conditions<Animal> condition) {
		this.description = description;
		this.icon = icon;
		this.condition = condition;
	}

	public String getDescription() {
		return this.description;
	}

	public String getIcon() {
		return this.icon;
	}

	public Conditions<Animal> getCondition() {
		return this.condition;
	}
}
