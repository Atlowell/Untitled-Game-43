/**
 * Created by Wesley LaFleur, David Burgos, and Austin Lowell on 10/10/15.
 * Witch Class (Type: Monster) for Untitled Game #43
 * @author David Burgos, N/A
 * @author Austin Lowell, N/A
 * @author Wesley LaFleur, wlafleur@purdue.edu
 * @since October 10, 2015
 */

//Update: David created Witch class and assigned values to variables name, attack, health, and loottable; also added two
//loot items. - 10/10/15
//Update: Austin added variable hitchance and assigned it a value. - 10/12/15
//Update: Wesley added variable description and gave a description for Witch monster. - 10/12/15

import java.util.Hashtable;

public class Witch extends Monster {

    public Witch() {
        name = "Witch";
        description = "A ghastly looking individual with teeth like broken glass; she seems to be staring into your\nsoul...";
        attack = 3;
        health = 12;
        hitchance = 7;
        lootchance = 70;
        loottable = new Hashtable<Integer, Loot>();
        loottable.put(56, new Loot("Potion"));
        loottable.put(99, new Loot("Witch's Hat"));
    }
}
