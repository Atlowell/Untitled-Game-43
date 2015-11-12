import java.util.Hashtable;

public class Slime extends Monster {

    public Slime() {
    	MAXHEALTH = 8;
        name = "Slime";
        description = "A gross looking heap of slime; let's hope it doesn't merge with anymore slimes that happen to\nbe lurking about...";
        attack = 2;
        health = 8;
        hitchance = 7;
        lootchance = 70;
        loottable = new Hashtable<Integer, Loot>();
        loottable.put(99, new Loot("Jelly"));
    }
}
