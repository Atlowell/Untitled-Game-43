import java.util.Hashtable;

public class Witch extends Monster {

    public Witch() {
        name = "Witch";
        attack = 3;
        health = 12;
        hitchance = 7;
        loottable = new Hashtable<Integer, Loot>();
        loottable.put(56, new Loot("Potion"));
        loottable.put(99, new Loot("Witch's Hat"));
    }
}
