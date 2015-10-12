import java.util.Hashtable;

public class WildDog extends Monster {

    public WildDog() {
        name = "Wild Dog";
        attack = 1;
        health = 4;
        hitchance = 9;
        loottable = new Hashtable<Integer, Loot>();
        loottable.put(99, new Loot("Dog Bones"));
    }
}
