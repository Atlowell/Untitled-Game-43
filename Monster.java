

import java.util.Hashtable;

public class Monster {
	
	public int MAXHEALTH;
	protected int health;
	protected String name;
	protected String description;
	protected int attack;
	protected int hitchance;
	protected int lootchance; //out of 100 (1-100)
	public Hashtable<Integer, Loot> loottable; //also based in 100, add lowest to highest 0-99
	
	
	public Loot getLoot() { //returns loot if you get it, or null if you don't
		if(loottable.isEmpty()) {
			return null;
		}
		int val = (int)Math.random() * 100;
		if(val < lootchance) {
			int j = (int)Math.random() * 100;
			while(loottable.get(j) == null) {
				j++;
			}
			return loottable.get(j);
		}
		return null;
	}

	public int getHP() { return health; }

	public void setHP(int health) { this.health = health; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getHitChance() {
		return hitchance;
	}

	public void setHitChance(int hitchance) {
		this.hitchance = hitchance;
	}

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }
}
