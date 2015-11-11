

import java.util.ArrayList;

public class Player {
	
	/// GLOBAL VARIABLES ///
	private String name;
	private int ap;
	private ArrayList<Loot> inventory;
	private ArrayList<Weapon> weapons;
	private ArrayList<Armor> armor;
	private int hp = 10;
	private int attack;
	private int hitchance = 8;

	
	/// CONSTRUCTOR ///
	public Player(String n) {
		name = n;
		inventory = new ArrayList<Loot>();
		inventory.add(new Loot("Torch"));
		
		weapons = new ArrayList<Weapon>();
		weapons.add(new Weapon("Stick", 1));
		attack = 1;
		
		armor = new ArrayList<Armor>();
		armor.add(new Armor("Rags", 0));
		ap = 0;
	}

	
	/// PRIVATE METHODS ///
	/* private void updateArmor() {
		if(armor.size() > 0) {
			int max=0;
			for(int i=0; i<armor.size(); i++) {
				if(max < armor.get(i).getAP()) {
					max = armor.get(i).getAP();
				}
			}
			ap = max;
			return;
		}
		ap = 0;
	} */
	
	/* private void updateWeapon() {
		if(weapons.size() > 0) {
			int max=0;
			for(int i=0; i<weapons.size(); i++) {
				if(max < weapons.get(i).getAttack()) {
					max = weapons.get(i).getAttack();
				}
			}
			attack = max;
			return;
		}
		attack = 0;
	} */

	
	/// PUBLIC METHODS ///
	//returns true if weapon is an upgrade, false if otherwise
	public boolean addWeapon(Weapon wep) {
		weapons.add(wep);
		if(wep.getAttack() > attack) {
			attack = wep.getAttack();
			return true;
		}
		return false;
	}
	
	//returns true if armor is an upgrade, false if otherwise
	public boolean addArmor(Armor arm) {
		armor.add(arm);
		if(arm.getAP() > ap) {
			ap = arm.getAP();
			return true;
		}
		return false;
	}
	
	public void addToInventory(Loot l) {
		inventory.add(l);
	}
	
	/// GETTERS AND SETTERS ///
	public int getAP() {
		return ap;
	}

	public int getAttack() {
		return attack;
	}

	public int getHP() {
		return hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}


	public int getHitChance() {
		return hitchance;
	}


	public void setHitChance(int hitchance) {
		this.hitchance = hitchance;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void getInventory() {
		System.out.println("");
		if(inventory.size() > 0) {
			String inv = "Inventory: ";
			for(int i = 0; i < inventory.size() - 1; i++) {
				inv = inv + inventory.get(i).getName() + ", ";
			}
			inv = inv + inventory.get(inventory.size() - 1).getName();
			System.out.println(inv);
		}
		else {
			System.out.println("Your inventory is empty.");
		}
		if(weapons.size() > 0) {
			String wep = "Weapon Stash(Attack): ";
			for(int i = 0; i < weapons.size() - 1; i++) {
				wep = wep + weapons.get(i).getName() + "(" + weapons.get(i).getAttack() + "), ";
			}
			wep = wep + weapons.get(weapons.size() - 1).getName() + "(" + weapons.get(weapons.size() - 1).getAttack() + ")";
			System.out.println(wep);
		}
		else {
			System.out.println("Your weapon stash is empty.");
		}
		if(armor.size() > 0) {
			String arm = "Armor Stash(Armor): ";
			for(int i = 0; i < armor.size() - 1; i++) {
				arm = arm + armor.get(i).getName() + "(" + armor.get(i).getAP() + "), ";
			}
			arm = arm + armor.get(armor.size() - 1).getName() + "(" + armor.get(armor.size() - 1).getAP() + ")";
			System.out.println(arm);
		}
		else {
			System.out.println("Your armor stash is empty.");
		}
	}
}
