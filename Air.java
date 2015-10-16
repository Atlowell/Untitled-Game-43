import java.util.Hashtable;


public class Air extends Monster {
	
	public Air() {
		name = "Air";
		description = "The very air itself comes to life to attack you";
		attack = 1;
		health = 1;
		hitchance = 10;
		lootchance = 100;
		loottable = new Hashtable<Integer, Loot>();
	}
}
