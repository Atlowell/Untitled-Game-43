
public class RoomInit {
	
	public static Room[] initRooms() {
		Room[] rooms = new Room[16];
		rooms[0] = initRoom1();
		rooms[1] = initRoom2();
		rooms[2] = initRoom3();
		rooms[3] = initRoom4();
		rooms[4] = initRoom5();
		rooms[5] = initRoom6();
		rooms[6] = initRoom7();
		rooms[7] = initRoom8();
		rooms[8] = initRoom9();
		rooms[9] = initRoom10();
		rooms[10] = initRoom11();
		rooms[11] = initRoom12();
		rooms[12] = initRoom13();
		rooms[13] = initRoom14();
		rooms[14] = initRoom15();
		rooms[15] = initRoom16();
		return rooms;
	}
	
	private static Room initRoom1() {
		Room room1 = new Room(1);
		return room1;
	}
	
	private static Room initRoom2() {
		Room room2 = new Room(2);
		room2.addMonster(new Rat());
		room2.addLoot(new Weapon("David", 999));
		return room2;
	}
	
	private static Room initRoom3() {
		Room room3 = new Room(3);
		room3.addMonster(new WildDog());
		room3.addLoot(new Armor("Wes", 999));
		return room3;
	}
	
	private static Room initRoom4() {
		Room room4 = new Room(4);
		return room4;
	}
	
	private static Room initRoom5() {
		Room room5 = new Room(5);
		room5.addMonster(new Air());
		return room5;
	}
	
	private static Room initRoom6() {
		Room room6 = new Room(6);
		return room6;
	}
	
	private static Room initRoom7() {
		Room room7 = new Room(7);
		return room7;
	}
	
	private static Room initRoom8() {
		Room room8 = new Room(8);
		return room8;
	}
	
	private static Room initRoom9() {
		Room room9 = new Room(9);
		return room9;
	}
	
	private static Room initRoom10() {
		Room room10 = new Room(10);
		return room10;
	}
	
	private static Room initRoom11() {
		Room room11 = new Room(11);
		return room11;
	}
	
	private static Room initRoom12() {
		Room room12 = new Room(12);
		return room12;
	}
	
	private static Room initRoom13() {
		Room room13 = new Room(13);
		return room13;
	}
	
	private static Room initRoom14() {
		Room room14 = new Room(14);
		return room14;
	}
	
	private static Room initRoom15() {
		Room room15 = new Room(15);
		return room15;
	}
	
	private static Room initRoom16() {
		Room room16 = new Room(16);
		return room16;
	}
}
