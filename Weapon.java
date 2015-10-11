package net.spearmanstudios;

public class Weapon extends Loot {

	private int attack;
	
	public Weapon(String name, int attack) {
		super(name);
		setAttack(attack);
	}
	
	public String checkType() {
		return "Weapon";
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
}
