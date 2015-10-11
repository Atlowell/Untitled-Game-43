package net.spearmanstudios;

public class Combat {
	
	private Player pl;
	private Monster mo;
	
	public Combat(Player p, Monster m) {
		pl = p;
		mo = m;
	}
	
	
	
	//returns true if there is a winner, false if the fight still goes on - getWinner should be called if true
	public boolean fight() {
		if(Math.random() % 10 < pl.getHitChance()) {
			mo.setHP(mo.getHP()-pl.getAttack());
		}
		if(mo.getHP() <= 0) {
			return true;
		}
		if(Math.random() % 10 < mo.getHitChance()) {
			pl.setHP(pl.getHP()-mo.getAttack());
		}
		if(pl.getHP() <= 0) {
			return true;
		}
		return false;
	}
	
	//returns true if flee is successful, false if flee is failed - getWinner should be called if false
	public boolean flee() {
		if(Math.random() % 2 < 1) {
			return true;
		}
		else {
			if(Math.random() % 10 < mo.getHitChance()) {
				pl.setHP(pl.getHP()-mo.getAttack());
			}
			return false;
		}
	}
	
	//returns true if player won, false if monster won - do not call unless fight returns true or a flee fails
	public boolean getWinner() {
		if(mo.getHP() <= 0) {
			return true;
		}
		return false;
	}
	
	public Loot retrieveLoot() {
		return mo.getLoot();
	}

	public Monster getMonster() {
		return mo;
	}

	public Player getPlayer() {
		return pl;
	}
	
}
