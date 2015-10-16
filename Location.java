import java.util.Scanner;

/**
 * [Untitled Game]
 * [Description of game goes here, including objectives, backstory, etc.]
 * @author Wesley LaFleur, wlafleur@purdue.edu
 * @author Austin Lowell, N/A
 * @author David Burgos, N/A
 * @version October 10, 2015
 */
public class Location {

    //GLOBAL VARIABLES
    private String s;
    private  Scanner in;
    private int room = 1;
 
    private Room[] rooms;
    
    private Player p;
    
    public Location(Player pl, Scanner sc) {
    	p = pl;
    	in = sc;
    	rooms = RoomInit.initRooms();
    }
    		
    private void fleeroom(int num) {
    	switch(num) {
    		case 1:
    			square1();
    			return;
    		case 2:
    			square2();
    			return;
    		case 3:
    			square3();
    			return;
    		case 4:
    			square4();
    			return;
    		case 5:
    			square5();
    			return;
    		case 6:
    			square6();
    			return;
    		case 7:
    			square7();
    			return;
    		case 8:
    			square8();
    			return;
    		case 9:
    			square9();
    			return;
    		case 10:
    			square10();
    			return;
    		case 11:
    			square11();
    			return;
    		case 12:
    			square12();
    			return;
    		case 13:
    			square13();
    			return;
    		case 14:
    			square14();
    			return;
    		case 15:
    			square15();
    			return;
    		case 16:
    			square16();
    			return;
    		default:
    			return;
    	}
    }
    
    
    
    private void combat(Monster m) {
    	System.out.println("You have encounted a " + m.name + "!");
    	Combat c = new Combat(p, m);
    	while(true) {
    		System.out.println("Fight or flee?");
    		s = in.nextLine();
    		if(s.equalsIgnoreCase("fight")) {
    			if(c.fight()) {
    				if(c.getWinner()) {
    					System.out.println("You have defeated the " + m.getName() + "!");
    					Loot l = c.retrieveLoot();
    					p = c.getPlayer();
    					if(l != null) {
    						System.out.println("You looted a " + l.getName() + " from the " + m.getName() + "!");
    						if(l.checkType().equals("Loot")) {
    							p.addToInventory(l);
    						}
    						else if(l.checkType().equals("Armor")) {
    							if(p.addArmor((Armor)l)) {
    								System.out.println("Armor upgrade attained! Your armor is now " + p.getAP() + "!");
    							}
    							else {
    								System.out.println("The armor was not an upgrade.");
    							}
    						}
    						else if(l.checkType().equals("Weapon")) {
    							if(p.addWeapon((Weapon)l)) {
    								System.out.println("Weapon upgrade attained! Your attack is now " + p.getAttack() + "!");
    							}
    							else {
    								System.out.println("The weapon was not an upgrade.");
    							}
    						}
    					}
    					else {
    						System.out.println("You found nothing of interest.");
    					}
    					return;
    				}
    				else {
    					System.out.println("You fought in vain but in the end, the monsters of this strange realm were too much for you.\nYou have died.  Game over.");
    					in.close();
    					System.exit(0);
    				}
    			}
    		}
    		else if(s.equalsIgnoreCase("flee")) {
    			if(c.flee()) {
    				p = c.getPlayer();
    				System.out.println("You have successfully fled back to room " + room);
    				fleeroom(room);
    			}
    			else {
    				if(c.getWinner() == null) {
    					System.out.println("You could not escape!  The monster hits you!  Your health is now " + c.getPlayer().getHP());
    				}
    				else if(c.getWinner() == false) {
    					System.out.println("As you attempt to flee, the Monster strikes you and you fall.  Your life draws to a close.\nGame over.");
    					in.close();
    				}
    			}
    		}
    	}
    }
    
    private void lootRoom(Loot l) {
    	System.out.println("You looted a " + l.getName() + " from the room!");
    	if(l.checkType().equals("Loot")) {
    		p.addToInventory(l);
    	}
    	else if(l.checkType().equals("Armor")) {
    		if(p.addArmor((Armor)l)) {
    			System.out.println("Armor upgrade attained! Your armor is now " + p.getAP() + "!");
			}
			else {
				System.out.println("The armor was not an upgrade.");
    		}
    	}
    	else if(l.checkType().equals("Weapon")) {
			if(p.addWeapon((Weapon)l)) {
				System.out.println("Weapon upgrade attained! Your attack is now " + p.getAttack() + "!");
			}
			else {
				System.out.println("The weapon was not an upgrade.");
			}
		}
    	
    }
    
    private boolean checkMonster(Monster m) {
    	if(m == null) {
    		return false;
    	}
    	return true;
    }
    
    private boolean checkLoot(Loot l) {
    	if(l == null) {
    		return false;
    	}
    	return true;
    }
    
    public void square1() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*   x   *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[0].getMonster())) {
        	combat(rooms[0].getMonster());
       		rooms[0].addMonster(null);
       	}
       	if(checkLoot(rooms[0].getLoot())) {
       		lootRoom(rooms[0].getLoot());
       		rooms[0].addLoot(null);
       	}
       	else {
       		System.out.println("You find nothing of interest in the room.");
        }
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("d")) {
        	System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
        	room = 1;
        	square2();
        } else if (s.equalsIgnoreCase("s")) {
        	System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
        	room = 1;
        	square5();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
        	System.out.println("\033[31;1mThanks for playing!\033[0m");
        	in.close();
        	System.exit(0);
        }
        else {
        	System.out.println("\033[31;1mWhat?\033[0m");
        	square1();
        }
    }

    public void square2() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *   x   *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[1].getMonster())) {
        	combat(rooms[1].getMonster());
        	rooms[1].addMonster(null);
        }
        if(checkLoot(rooms[1].getLoot())) {
        	lootRoom(rooms[1].getLoot());
        	rooms[1].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("d")) {
        	System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
        	room = 2;
           	square3();
        } else if (s.equalsIgnoreCase("s")) {
           	System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
           	room = 2;
           	square6();
        } else if (s.equalsIgnoreCase("a")) {
        	System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
        	room = 2;
        	square1();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
           	in.close();
           	System.exit(0);
        }
        else {
       		System.out.println("What?");
       		square2();
       	}
    }

    public void square3() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *   x   *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[2].getMonster())) {
        	combat(rooms[2].getMonster());
        	rooms[2].addMonster(null);
        }
        if(checkLoot(rooms[2].getLoot())) {
        	lootRoom(rooms[2].getLoot());
        	rooms[2].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        	
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("d")) {
        	System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
        	room = 3;
        	square4();
        } else if (s.equalsIgnoreCase("s")) {
        	System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
        	room = 3;
        	square7();
        } else if (s.equalsIgnoreCase("a")) {
        	System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
        	room = 3;
        	square2();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
        	System.out.println("\033[31;1mThanks for playing!\033[0m");
        	in.close();
        	System.exit(0);
        }
        else {
        	System.out.println("What?");
            square3();
        }
    }

    public Location square4() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *   x   *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[3].getMonster())) {
        	combat(rooms[3].getMonster());
        	rooms[3].addMonster(null);
        }
        if(checkLoot(rooms[3].getLoot())) {
        	lootRoom(rooms[3].getLoot());
        	rooms[3].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }

        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            room = 4;
            square3();
        } else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            room = 4;
            square8();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("What?");
            square4();
        }
        return null;
    }

    public Location square5() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*   x   *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[4].getMonster())) {
        	combat(rooms[4].getMonster());
        	rooms[4].addMonster(null);
        }
        if(checkLoot(rooms[4].getLoot())) {
        	lootRoom(rooms[4].getLoot());
        	rooms[4].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            room = 5;
            square1();
        } else if (s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            room = 5;
            square6();
        } else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            room = 6;
            square9();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("What?");
            square5();
        }
        return null;
    }

    public Location square6() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *   x   *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[5].getMonster())) {
        	combat(rooms[5].getMonster());
        	rooms[5].addMonster(null);
        }
        if(checkLoot(rooms[5].getLoot())) {
        	lootRoom(rooms[5].getLoot());
        	rooms[5].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            room = 6;
            square2();
        } else if (s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            room = 6;
            square7();
        } else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            room = 6;
            square10();
        } else if (s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            room = 6;
            square5();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("What?");
            square6();
        }
        return null;
    }

    public Location square7() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *   x   *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[6].getMonster())) {
        	combat(rooms[6].getMonster());
        	rooms[6].addMonster(null);
        }
        if(checkLoot(rooms[6].getLoot())) {
        	lootRoom(rooms[6].getLoot());
        	rooms[6].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            room = 7;
            square3();
        } else if (s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            room = 7;
            square8();
        } else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            room = 7;
            square11();
        } else if (s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            room = 7;
            square6();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("What?");
            square5();
        }
        return null;
    }

    public Location square8() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *   x   *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[7].getMonster())) {
        	combat(rooms[7].getMonster());
        	rooms[7].addMonster(null);
        }
        if(checkLoot(rooms[7].getLoot())) {
        	lootRoom(rooms[7].getLoot());
        	rooms[7].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            room = 8;
            square4();
        }
        else if(s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            room = 8;
            square12();
        }
        else if(s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            room = 8;
            square7();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("What?");
            square8();
        }
        return null;
    }
    
    public Location square9() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*   x   *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[8].getMonster())) {
        	combat(rooms[8].getMonster());
        	rooms[8].addMonster(null);
        }
        if(checkLoot(rooms[8].getLoot())) {
        	lootRoom(rooms[8].getLoot());
        	rooms[8].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            room = 9;
            square10();
        }
        else if(s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            room = 9;
            square13();
        }
        else if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            room = 9;
            square5();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("What?");
            square9();
        }
        return null;
    }

    public Location square10() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *   x   *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[9].getMonster())) {
        	combat(rooms[9].getMonster());
        	rooms[9].addMonster(null);
        }
        if(checkLoot(rooms[9].getLoot())) {
        	lootRoom(rooms[9].getLoot());
        	rooms[9].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            room = 10;
            square11();
        }
        else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            room = 10;
            square14();
        }
        else if (s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            room = 10;
            square6();
        }
        else if (s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            room = 10;
            square9();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("What?");
            square10();
        }
        return null;
    }

    public Location square11() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *   x   *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[10].getMonster())) {
        	combat(rooms[10].getMonster());
        	rooms[10].addMonster(null);
        }
        if(checkLoot(rooms[10].getLoot())) {
        	lootRoom(rooms[10].getLoot());
        	rooms[10].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }	
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            room = 11;
            square12();
        }
        else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            room = 11;
            square15();
        }
        else if (s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            room = 11;
            square7();
        }
        else if (s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            room = 11;
            square10();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("What?");
            square11();
        }
        return null;
    }

    public Location square12() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *   x   *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[11].getMonster())) {
        	combat(rooms[11].getMonster());
        	rooms[11].addMonster(null);
        }
        if(checkLoot(rooms[11].getLoot())) {
        	lootRoom(rooms[11].getLoot());
        	rooms[11].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            room = 12;
            square8();
        }
        else if(s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            room = 12;
            square16();
        }
        else if(s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            room = 12;
            square11();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("What?");
            square12();
        }
        return null;
    }

    public Location square13() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*   x   *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[12].getMonster())) {
        	combat(rooms[12].getMonster());
        	rooms[12].addMonster(null);
        }
        if(checkLoot(rooms[12].getLoot())) {
        	lootRoom(rooms[12].getLoot());
        	rooms[12].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            room = 13;
            square9();
        }
        else if(s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            room = 13;
            square14();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            room = 13;
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("What?");
            square13();
        }
        return null;
    }

    public Location square14() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *   x   *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[13].getMonster())) {
        	combat(rooms[13].getMonster());
        	rooms[13].addMonster(null);
        }
        if(checkLoot(rooms[13].getLoot())) {
        	lootRoom(rooms[13].getLoot());
        	rooms[13].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            room = 14;
            square10();
        }
        else if(s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            room = 14;
            square15();
        }
        else if(s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            room = 14;
            square13();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("What?");
            square14();
        }
        return null;
    }

    public Location square15() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *   x   *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[14].getMonster())) {
        	combat(rooms[14].getMonster());
        	rooms[14].addMonster(null);
        }
        if(checkLoot(rooms[14].getLoot())) {
        	lootRoom(rooms[14].getLoot());
        	rooms[14].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            room = 15;
            square11();
        }
        else if(s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            room = 15;
            square16();
        }
        else if(s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            room = 15;
            square14();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("What?");
            square15();
        }
        return null;
    }

    public Location square16() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *   x   *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        
        if(checkMonster(rooms[15].getMonster())) {
        	combat(rooms[15].getMonster());
        	rooms[15].addMonster(null);
        }
        if(checkLoot(rooms[15].getLoot())) {
        	lootRoom(rooms[15].getLoot());
        	rooms[15].addLoot(null);
        }
        else {
        	System.out.println("You find nothing of interest in the room.");
        }
        
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            room = 16;
            square12();
        }
        else if(s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            room = 16;
            square15();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
            in.close();
        	System.exit(0);
        }
        else {
            System.out.println("\033[31;1mWhat?\033[0m");
            square16();
        }
        return null;
    }
}
