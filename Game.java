import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * Created by wlafleur on 10/10/15.
 */
public class Game implements KeyListener {
	
	public Player p;
	private JFrame textframe;
	private JTextArea textarea;
	private JTextArea typearea;
	CustomOutputStream cos;
	PrintStream printstream;
	
	private Thread thread1;
	
	private String readstring;
	 
	
    public static void main(String[] args) {
      Game s = new Game();
      s.startScreen();
    }

    public void startScreen() {
    	   textframe = new JFrame("Untitled Game #43 Command Line");
    	   textframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	   //textframe.setLayout(new LayoutManager());
    	   textarea = new JTextArea();
    	   textarea.setEditable(false);
    	   textarea.setLineWrap(true);
    	   textarea.setMargin(new Insets(5,5,5,5));
    	   JScrollPane scrollpane = new JScrollPane(textarea);
    	   scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	   scrollpane.setPreferredSize(new Dimension(600, 600));
    	   scrollpane.setBorder(BorderFactory.createLineBorder(Color.black));
    	   typearea = new JTextArea();
    	   typearea.setPreferredSize(new Dimension(600,20));
    	   typearea.setBorder(BorderFactory.createLineBorder(Color.black));
    	   typearea.addKeyListener(this);
    	   textframe.getContentPane().add(scrollpane, BorderLayout.WEST);
    	   textframe.getContentPane().add(typearea, BorderLayout.SOUTH);
    	   textframe.pack();
    	   textframe.setVisible(true);
    	   cos = new CustomOutputStream(textarea);
    	   printstream = new PrintStream(cos);
    	   System.setOut(printstream);
    	   
    	   manage();
    }
    
    public void manage() {
    	
           System.out.println("Welcome to [Untitled Game]!  Please enter name.");
           
           Runnable r = new Runnable() {
        	   @Override
        	   public void run() {
        		   synchronized(thread1) {
        			   try 
                       {
                           thread1.wait();
                       } 
                       catch (InterruptedException e) 
                       {
                    	   e.printStackTrace();
                       }
        		   }
        	   }
           };
           thread1 = new Thread(r);
           thread1.run();
           

           p = new Player(readstring);
           
           System.out.println("");
           System.out.println("Welcome " + p.getName() + "!\n");
           System.out.println("");
           System.out.println("Below are the controls for the game:");
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
           System.out.println("");
           System.out.println("Ready? Type 'start' without the single quotes to enter the world of [empty]!");
           
           
           while(true) {
        	   thread1 = new Thread(r);
               thread1.run();
        	   if(readstring.equalsIgnoreCase("start")) {
        		   RoomInit.initRooms();
        		   typearea.removeKeyListener(this);
        		   typearea.addKeyListener(RoomInit.rooms[0]);
        		   RoomInit.rooms[0].operate(p, typearea, 0);
        		   break;
        	   }
        	   else {
        		   System.out.println("I did not understand your response.");
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
			readstring = typearea.getText();
			if(readstring.length() > 1) {
				readstring = readstring.substring(0, readstring.length()-1);
				synchronized(thread1)
	            {
					thread1.notify();
	            } 
			}
			else {
				System.out.println("Invalid input, try again");
			}
			
			typearea.setText("");
		}
	}
}
