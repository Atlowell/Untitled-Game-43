import java.util.Hashtable;

public class Dragon extends Monster {

    public Dragon() {
        name = "Dragon";
        description = "The dragon's muscles flex under it's amethyst-like scales; a majestic creature, this one is.";
        attack = 15;
        health = 120;
        hitchance = 5;
        lootchance = 70;
        loottable = new Hashtable<Integer, Loot>();
        loottable.put(9, new Loot("Dragon Head"));
        loottable.put(15, new Loot("Dragon Egg"));
        loottable.put(0, new Loot("Dragon Pickaxe"));
        loottable.put(99, new Loot("Dragon Bones"));
    }
}
