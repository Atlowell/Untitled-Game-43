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
    
    Monster monster1 = null;
    Monster monster2 = new Rat();
    Monster monster3 = null;
    Monster monster4 = null;
    Monster monster5 = null;
    Monster monster6 = null;
    Monster monster7 = null;
    Monster monster8 = null;
    Monster monster9 = null;
    Monster monster10 = null;
    Monster monster11 = null;
    Monster monster12 = null;
    Monster monster13 = null;
    Monster monster14 = null;
    Monster monster15 = null;
    Monster monster16 = null;
    
    Player p;
    
    public Location(Player pl, Scanner sc) {
    	p = pl;
    	in = sc;
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
    
    
    
    private void combat(Monster m, int r) {
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
    						if(l.checkType() == "Loot") {
    							p.addToInventory(l);
    						}
    						else if(l.checkType() == "Armor") {
    							if(p.addArmor((Armor)l)) {
    								System.out.println("Armor upgrade attained! Your armor is now " + p.getAP() + "!");
    							}
    							else {
    								System.out.println("The armor was not an upgrade.");
    							}
    						}
    						else if(l.checkType() == "Weapon") {
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
    			else {
    				System.out.println("You and the " + m.getName() + " swing at eachother.  Your health is now " + c.getPlayer().getHP() + ".");
    			}
    		}
    		else if(s.equalsIgnoreCase("flee")) {
    			if(c.flee()) {
    				p = c.getPlayer();
    				System.out.println("You have successfully fled back to room " + r);
    				fleeroom(r);
    			}
    		}
    		else {
    			if(c.getWinner() == false) {
    				System.out.println("As you attempt to flee, the Monster strikes you and you fall.  Your life draws to a close.\nGame over.");
    				in.close();
    			}
    			else if(c.getWinner() == null) {
    				System.out.println("You could not escape!  The monster hits you!  Your health is now " + c.getPlayer().getHP());
    			}
    		}
    	}
    }
    
    private boolean checkMonster(Monster m) {
    	if(m == null) {
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
        if(checkMonster(monster1)) {
        	combat(monster1, 1);
        	
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
        System.out.println("Which way would you like to go?");
        System.out.println("'a' for west.)");
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
