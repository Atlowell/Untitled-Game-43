
public class Room {

	private int number;
	private Loot loot = null;
	private Monster monster = null;
	
	
	public Room(int num) {
		number = num;
	}

	public Monster getMonster() {
		return monster;
	}

	public void addMonster(Monster monster) {
		this.monster = monster;
	}

	public Loot getLoot() {
		return loot;
	}

	public void addLoot(Loot loot) {
		this.loot = loot;
	}

	public int getNumber() {
		return number;
	}	
}
