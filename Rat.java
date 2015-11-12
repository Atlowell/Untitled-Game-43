

import java.util.Hashtable;

public class Rat extends Monster {

	public Rat() {
		MAXHEALTH = 1;
		name = "Rat";
		description = "A harmless rat.";
		attack = 0;
		health = 1;
		hitchance = 10;
		lootchance = 70;
		loottable = new Hashtable<Integer, Loot>();
		loottable.put(99, new Loot("Rat Tail"));
	}
}
