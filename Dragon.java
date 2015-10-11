import java.util.Hashtable;

public class Dragon extends Monster {

    public Dragon() {
        name = "Dragon";
        attack = 15;
        health = 120;
        loottable = new Hashtable<Integer, Loot>();
        loottable.put(9, new Loot("Dragon Head"));
        loottable.put(15, new Loot("Dragon Egg"));
        loottable.put(0, new Loot("Dragon Pickaxe"));
        loottable.put(99, new Loot("Dragon Bones"));
    }
}
