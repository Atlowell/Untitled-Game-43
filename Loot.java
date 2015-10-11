package net.spearmanstudios;

public class Loot {

	private String name;
	
	public Loot(String n) {
		setName(n);
	}
	
	public String checkType() {
		return "Loot";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
