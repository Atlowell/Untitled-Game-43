


public class Combat {
	
	private Player pl;
	private Monster mo;
	
	public Combat(Player p, Monster m) {
		pl = p;
		mo = m;
	}
	
	
	
	//returns true if there is a winner, false if the fight still goes on - getWinner should be called if true
	public boolean fight() {
		if(Math.random() * 10 < pl.getHitChance()) {
			mo.setHP(mo.getHP()-pl.getAttack());
			System.out.println("You swing at the " + mo.getName() + " and hit!");
			if(mo.getHP() <= 0) {
				return true;
			}
			if((float)mo.getHP()/(float)mo.MAXHEALTH > .7) {
				System.out.println("The " + mo.getName() + " does not look very harmed");
			}
			else if((float)mo.getHP()/(float)mo.MAXHEALTH > .3) {
				System.out.println("The " + mo.getName() + " looks fairly roughed up");
			}
			else {
				System.out.println("The " + mo.getName() + " looks badly injured");
			}
		}
		else {
			System.out.println("You swing at the " + mo.getName() + " but miss!");
		}
		if(Math.random() * 10 < mo.getHitChance()) {
			if(pl.getAP() >= mo.getAttack() + 2) {
				System.out.println("The " + mo.getName() + "'s attacks bounce off your armor harmlessly");
			}
			else if(pl.getAP() >= mo.getAttack() - 1) {
				pl.setHP(pl.getHP() - 1);
				System.out.println("The " + mo.getName() + " swings at you and hits, but your armor blocks the brunt of the attack");
			}
			else {
				pl.setHP(pl.getHP() + pl.getAP() - mo.getAttack());
				System.out.println("The " + mo.getName() + " swings at you and hits!");
			}
		}
		else {
			System.out.println("The " + mo.getName() + " swings at you but misses!");
		}
		if(pl.getHP() <= 0) {
			return true;
		}
		System.out.println("Your health is now " + pl.getHP());
		return false;
	}
	
	//returns true if flee is successful, false if flee is failed - getWinner should be called if false
	public boolean flee() {
		if(Math.random() * 2 < 1) {
			return true;
		}
		else {
			if(Math.random() * 10 < mo.getHitChance()) {
				if(pl.getAP() >= mo.getAttack() + 4) {
					System.out.println("You attempt to flee but fail.  The " + mo.getName() + " attacks you but his attacks bounce off your armor harmlessly.");
				}
				else if(pl.getAP() >= mo.getAttack() - 1) {
					pl.setHP(pl.getHP() - 1);
					System.out.println("You attempt to flee but fail.  The " + mo.getName() + " attacks you, but your armor blocks the brunt of the attack.");
				}
				else {
					pl.setHP(pl.getHP() + pl.getAP() - mo.getAttack());
					System.out.println("You attempt to flee but fail.  The " + mo.getName() + " attacks you while you flee and hits!");
				}
			}
			else {
				System.out.println("You attempt to flee but fail.  The " + mo.getName() + " attacks you while you flee but misses.");
			}
			return false;
		}
	}
	
	//returns true if player won, false if monster won - do not call unless fight returns true or a flee fails
	public Boolean getWinner() {
		if(mo.getHP() <= 0) {
			return true;
		}
		else if(pl.getHP() <= 0) {
			return false;
		}
		return null;
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
