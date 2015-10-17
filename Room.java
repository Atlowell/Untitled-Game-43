
public class Room {

	private int number;
	private Loot loot = null;
	private Monster monster = null;
	public String[] map;
	
	public Room(int num) {
		number = num;
		map = new String[17];
		initMap();
	}

	private void initMap() {
		map[0] = "*********************************";
		map[1] = "*       *       *       *       *";
	    map[2] = "*       *       *       *       *";
	    map[3] = "*       *       *       *       *";
	    map[4] = "*********************************";
	    map[5] = "*       *       *       *       *";
	    map[6] = "*       *       *       *       *";
	    map[7] = "*       *       *       *       *";
	    map[8] = "*********************************";
	    map[9] = "*       *       *       *       *";
	    map[10] = "*       *       *       *       *";
	    map[11] = "*       *       *       *       *";
	    map[12] = "*********************************";
	    map[13] = "*       *       *       *       *";
	    map[14] = "*       *       *       *       *";
	    map[15] = "*       *       *       *       *";
	    map[16] = "*********************************";
	}
	
	public void printMap() {
		System.out.println("");
		for(int i = 0; i<17;i++) {
			System.out.println(map[i]);
		}
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
