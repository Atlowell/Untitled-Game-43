

import java.util.Hashtable;

public class Rat extends Monster {

	public Rat() {
		name = "Rat";
		attack = 0;
		health = 1;
		hitchance = 10;
		loottable = new Hashtable<Integer, Loot>();
		loottable.put(99, new Loot("Rat Tail"));
	}
}
