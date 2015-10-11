package net.spearmanstudios;

import java.util.ArrayList;

public class Player {
	
	/// GLOBAL VARIABLES ///
	public String name;
	private int ap;
	private ArrayList<Loot> inventory;
	private ArrayList<Weapon> weapons;
	private ArrayList<Armor> armor;
	private int hp = 10;
	private int attack;

	
	/// CONSTRUCTOR ///
	public Player(String n) {
		name = n;
		inventory = new ArrayList<Loot>();
		inventory.add(new Loot("Torch"));
		
		weapons = new ArrayList<Weapon>();
		weapons.add(new Weapon("Stick", 1));
		updateWeapon();
		
		armor = new ArrayList<Armor>();
		armor.add(new Armor("Rags", 0));
		updateArmor();	
	}

	
	/// PRIVATE METHODS ///
	private void updateArmor() {
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
	}
	
	private void updateWeapon() {
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
	}

	
	/// PUBLIC METHODS ///
	//returns true if weapon is an upgrade, false if otherwise
	public boolean addWeapon(Weapon wep) {
		weapons.add(wep);
		int temp = attack;
		updateWeapon();
		if(attack > temp) {
			return true;
		}
		return false;
	}
	
	//returns true if armor is an upgrade, false if otherwise
	public boolean addArmor(Armor arm) {
		armor.add(arm);
		int temp = ap;
		updateWeapon();
		if(ap > temp) {
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

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}	
}
