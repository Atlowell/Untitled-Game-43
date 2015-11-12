import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;


public class Room implements KeyListener {

	private int number;
	private int prev;
	private Loot loot = null;
	private Monster monster = null;
	public String[] map;
	
	private boolean ex = false;
	private String s;
	private JTextArea typearea;
	private Thread thread1;	//Keylistener Thread
	private Thread thread2; //Effect timer thread
	Runnable r;
	Runnable time;
	Player p;
	Effect ef;
	Consumable co;
	
	public Room(int num) {
		number = num;
		map = new String[17];
		initMap();
		
		System.out.println("Room " + num + " initialized");
		
		r = new Runnable() {
      	   @Override
      	   public void run() {
      		   synchronized(thread1) {
      			   try {
      				   thread1.wait();
                   } 
                   catch (InterruptedException e) {
                	   e.printStackTrace();
                   }
      		   }
      	   }
        };
        
        time = new Runnable() {
			@Override
			public void run() {
				p.setHPMod(p.getHPMod() + ef.getHMod());
				p.setAPMod(p.getAPMod() + ef.getAPMod());
				p.setAttackMod(p.getAttackMod() + ef.getAttackMod());
				System.out.println("You have consumed a " + co.getName() + ".");
				try {
					Thread.sleep(1000 * ef.getDuration());
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				p.setHPMod(p.getHPMod() - ef.getHMod());
				p.setAPMod(p.getAPMod() - ef.getAPMod());
				p.setAttackMod(p.getAttackMod() - ef.getAttackMod());
				System.out.println("The " + co.getName() + " has worn off.");
				if(p.getHP() <= 0) {
					System.out.println("As the effects of the " + co.getName() + " wear off, you realize they were the only thing keeping you alive.  You have perished.\nGame over.");
			    	System.out.println("Press enter to exit");
			    	ex = true;
			    	thread1 = new Thread(r);    					
			    	thread1.run();
			    	System.exit(0);
				} 
			}
		};
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
		System.out.println("");
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
	
	
	private void combat() {
    	System.out.println("You have encounted a " + monster.name + "!");
    	System.out.println("Your Health is " + p.getHP());
    	Combat c = new Combat(p, monster);
    	while(true) {
    		System.out.println("Fight or flee?");
    		thread1 = new Thread(r);
    		thread1.run();
    		if(s.equalsIgnoreCase("fight")) {
    			if(c.fight()) {
    				if(c.getWinner()) {
    					System.out.println("You have defeated the " + monster.getName() + "!");
    					Loot l = c.retrieveLoot();
    					p = c.getPlayer();
    					if(l != null) {
    						System.out.println("You looted a " + l.getName() + " from the " + monster.getName() + "!");
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
    						else if(l.checkType().equals("Consumable")){
    							p.addConsumable((Consumable)l);
    						}
    					}
    					else {
    						System.out.println("You found nothing of interest on the " + monster.getName() + ".");
    					}
    					return;
    				}
    				else {
    					System.out.println("You fought in vain but in the end, the monsters of this strange realm were too much for you.\nYou have died.  Game over.");
    					System.out.println("Press enter to quit");
    					ex = true;
    					thread1 = new Thread(r);
    					thread1.run();
    					System.exit(0);
    				}
    			}
    		}
    		else if(s.equalsIgnoreCase("flee")) {
    			if(c.flee()) {
    				p = c.getPlayer();
    				System.out.println("You have successfully fled back to room " + prev + ".");
    				monster.setHP(monster.MAXHEALTH);
    				typearea.removeKeyListener(this);
    				typearea.addKeyListener(RoomInit.rooms[prev-1]);
    				RoomInit.rooms[prev-1].operate(p, typearea, number);
    			}
    			else {
    				if(c.getWinner() == null);
    				else if(c.getWinner() == false) {
    					System.out.println("The " + monster.getName() + "'s hit was enough to mortally wound you.  Your life draws to a close.\nGame over.");
    					System.out.println("Press enter to exit");
    					ex = true;
    					thread1 = new Thread(r);
    					thread1.run();
    					System.exit(0);
    				}
    				System.out.println("Your health is now " + c.getPlayer().getHP());
    			}
    		}
    	}
    }
	
	
	private void lootRoom() {
    	System.out.println("You found a " + loot.getName() + " in the room!");
    	if(loot.checkType().equals("Loot")) {
    		p.addToInventory(loot);
    	}
    	else if(loot.checkType().equals("Armor")) {
    		if(p.addArmor((Armor)loot)) {
    			System.out.println("Armor upgrade attained! Your armor is now " + p.getAP() + "!");
			}
			else {
				System.out.println("The armor was not an upgrade.");
    		}
    	}
    	else if(loot.checkType().equals("Weapon")) {
			if(p.addWeapon((Weapon)loot)) {
				System.out.println("Weapon upgrade attained! Your attack is now " + p.getAttack() + "!");
			}
			else {
				System.out.println("The weapon was not an upgrade.");
			}
		}
    	else if(loot.checkType().equals("Consumable")) {
    		p.addConsumable((Consumable)loot);
    	}
    	
    }
	
	private void useConsumable(String c) {
    	co = p.findCons(c);
    	if(co == null) {
    		System.out.println("No such consumable found.");
    	}
    	else {
    		ef = co.getEffect();
    		if(ef.getDuration() == 0) {
    			p.setHPMod(p.getHPMod() + ef.getHMod());
    			p.setAPMod(p.getAPMod() + ef.getAPMod());
    			p.setAttackMod(p.getAttackMod() + ef.getAttackMod());
    			return;
    		}
    		thread2 = new Thread(time);
    		thread2.start();
    	}
    }
	
	private void printHelp() {
    	System.out.println("Here are the controls:");
        System.out.println("w - North");
        System.out.println("a - West");
        System.out.println("s - South");
        System.out.println("d - East");
        System.out.println("quit OR exit - Exits the game");
        System.out.println("map - Shows the map");
        System.out.println("inventory - Shows your inventory");
        System.out.println("stats - Shows your current stats");
        System.out.println("use [itemname] - Uses itemname from your inventory");
        System.out.println("help - Shows the help screen");
    }
	
	public void operate(Player pl, JTextArea typea, int pr) {
		p = pl;
		typearea = typea;
		prev = pr;
		
		printMap();
		if(monster != null) {
			combat();
			monster = null;
		}
		if(loot != null) {
			lootRoom();
			loot = null;
		}
		else {
       		System.out.println("You search the room, but find nothing of interest.");
        }
		
		while(true) {
       		System.out.println("");
       		System.out.println("Which way would you like to go?");
       		thread1 = new Thread(r);
       		thread1.run();
       		if (s.equalsIgnoreCase("d")) {
       			if(number % RoomInit.ROW != 0) {
       				System.out.println("You have chosen to go East.");
       				typearea.removeKeyListener(this);
       				typearea.addKeyListener(RoomInit.rooms[number]);
       				RoomInit.rooms[number].operate(p, typearea, number);
       				break;
       			}
       			else {
       				System.out.println("Unable to go this direction.");
           			System.out.println("");
       			}
       		}
       		else if (s.equalsIgnoreCase("a")) {
       			if(number % RoomInit.ROW != 1) {
       				System.out.println("You have chosen to go West.");
       				typearea.removeKeyListener(this);
       				typearea.addKeyListener(RoomInit.rooms[number-2]);
       				RoomInit.rooms[number-2].operate(p, typearea, number);
       				break;
       			}
       			else {
       				System.out.println("Unable to go this direction.");
           			System.out.println("");
       			}
       		}
       		else if (s.equalsIgnoreCase("w")) {
       			if((number - 1) / RoomInit.ROW != 0) {
       				System.out.println("You have chosen to go North.");
       				typearea.removeKeyListener(this);
       				typearea.addKeyListener(RoomInit.rooms[number-5]);
       				RoomInit.rooms[number-5].operate(p, typearea, number);
       				break;
       			}
       			else {
       				System.out.println("Unable to go this direction.");
           			System.out.println("");
       			}
       		}
       		else if (s.equalsIgnoreCase("s")) {
       			if((number - 1) / RoomInit.ROW != (RoomInit.ROW - 1)) {
       				System.out.println("You have chosen to go South.");
       				typearea.removeKeyListener(this);
       				typearea.addKeyListener(RoomInit.rooms[number+3]);
       				RoomInit.rooms[number+3].operate(p, typearea, number);
       				break;
       			}
       			else {
       				System.out.println("Unable to go this direction.");
           			System.out.println("");
       			}
       		}
       		else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
       			System.out.println("Thanks for playing!");
       			System.out.println("Press enter to exit.");
       			ex = true;
       			thread1 = new Thread(r);
       			thread1.run();
       			System.exit(0);
       		}
       		else if (s.equalsIgnoreCase("inventory")) {
       			p.getInventory();
       		}
       		else if (s.equalsIgnoreCase("map")) {
       			printMap();
       		}
       		else if (s.equalsIgnoreCase("stats")) {
       			System.out.println("Health: " + p.getHP());
       			System.out.println("Armor Points: " + p.getAP());
       			System.out.println("Attack Points: " + p.getAttack());
       		}
       		else if (s.split(" ")[0].equalsIgnoreCase("use")) {
       			String[] arr = s.split(" ");
       			String s2 = "";
       			for(int i = 1; i < arr.length - 1; i++) {
       				s2 = s2 + arr[i] + " ";
       			}
       			s2 = s2 + arr[arr.length - 1];
       			useConsumable(s2);
       		}
       		else if (s.equalsIgnoreCase("help")) {
       			printHelp();
       		}
       		else {
       			System.out.println("I don't understand your input");
       			System.out.println("");
       		}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == '\n') {
			s = typearea.getText();
			if(s.length() > 1) {
				s = s.substring(0, s.length()-1);
				synchronized(thread1) {
					thread1.notify();
		        } 
			}
			else {
				if(ex) {
					synchronized(thread1) {
						thread1.notify();
			        } 
				}
				else {
					System.out.println("Invalid input, try again");
				}
			}
					
			typearea.setText("");
		}
	}
}