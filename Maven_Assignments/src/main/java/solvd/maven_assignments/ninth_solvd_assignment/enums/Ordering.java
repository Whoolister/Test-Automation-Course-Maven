package ninth_solvd_assignment.enums;

import java.util.Comparator;

import ninth_solvd_assignment.inheritance.Animal;

public enum Ordering {
	ENDURING("The creatures that can tank the most damage go first", (Animal first, Animal second) -> {
		return Integer.compare(first.getBaseStat(Stat.HEALTH_POINTS), second.getBaseStat(Stat.HEALTH_POINTS));
	}), TIRELESS("The creatures that can endure the longest battles go first", (first, second) -> {
		return Integer.compare(first.getBaseStat(Stat.ENERGY_POINTS), second.getBaseStat(Stat.ENERGY_POINTS));
	}), MACH("The creatures with the most graceful movements go first", (first, second) -> {
		return Integer.compare(first.getBaseStat(Stat.SPEED), second.getBaseStat(Stat.SPEED));
	}), FLURRY("The creatures that combine the most attacks go first", (first, second) -> {
		return Integer.compare(first.getBaseStat(Stat.HIT_ROLLS), second.getBaseStat(Stat.HIT_ROLLS));
	}), AGGRESSIVE("The creatures with the deadliest of hits go first", (first, second) -> {
		return Integer.compare(first.getBaseStat(Stat.HIT_DAMAGE), second.getBaseStat(Stat.HIT_DAMAGE));
	}), PRECISE("The creatures with pinpoint accuracy go first", (first, second) -> {
		return Integer.compare(first.getBaseStat(Stat.CRITICAL_CHANCE), second.getBaseStat(Stat.CRITICAL_CHANCE));
	}), DEFENSIVE("The creatures that can brush off the strongest hits go first", (first, second) -> {
		return Integer.compare(first.getBaseStat(Stat.DEFENSE), second.getBaseStat(Stat.DEFENSE));
	});

	private String description;
	private Comparator<Animal> comparator;

	private Ordering(String description, Comparator<Animal> comparator) {
		this.description = description;
		this.comparator = comparator;
	}

	public String getDescription() {
		return this.description;
	}

	public Comparator<Animal> getComparator() {
		return this.comparator;
	}
}
