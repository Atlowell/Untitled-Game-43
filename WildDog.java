import java.util.Hashtable;

public class WildDog extends Monster {

    public WildDog() {
        name = "Wild Dog";
        description = "Foam appears to be forming around it's mouth...perhaps we shouldn't agitate it?";
        attack = 1;
        health = 4;
        hitchance = 9;
        lootchance = 70;
        loottable = new Hashtable<Integer, Loot>();
        loottable.put(99, new Loot("Dog Bones"));
    }
}
