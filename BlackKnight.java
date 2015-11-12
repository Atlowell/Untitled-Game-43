import java.util.Hashtable;


public class BlackKnight extends Monster {

	public BlackKnight() {
		MAXHEALTH = 15;
		name = "Black Knight";
		description = "'Tis but a flesh wound!";
		attack = 5;
		health = 15;
		hitchance = 7;
		lootchance = 80;
		loottable = new Hashtable<Integer, Loot>();
		loottable.put(99, new Weapon("Severed Arm", 3));
	}

}
