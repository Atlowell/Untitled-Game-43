import java.util.Hashtable;

public class Slime extends Monster {

    public Slime() {
        name = "Slime";
        attack = 2;
        health = 8;
        loottable = new Hashtable<Integer, Loot>();
        loottable.put(99, new Loot("Jelly"));
    }
}
