package cont;


import mod.*;
import view.*;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class Main {
	//INSTANCE VARIABLES
	private static final String[] Loop = { "Continue"};
	private static final String[] Replay = { "Yes", "No"};
	private Player _p;
	private Maze _z;
	private StringMap _s;
	private Window _w;
	private static JPanel scene;
	
	//MAIN METHOD TO TEST GAME RUNNING
	public static void main(String[] args) throws InterruptedException {
		Lab2();
	}

	/*
	 * This method constructs the entire game, initializing everything to be equal to a new instance of each class need.
	 * This method starts by opening up a JOptionPane window that introduces the player to the game and then gives them a choice
	 * to see if they want to skip the opening or not. Depending on their choice the game either starts immediately or another JOptionPane window opens 
	 * displaying the message. This method throws an InterruptedException due to one of the penalties that'll be described in the Question class.
	 * This class uses a KeyListener to know if you are hitting W A S or D for movement, and each time you make a move, it updates the current map
	 * by calling the updateMap method in StringMap. This method is also responsible for setting up the frame and making the JPanel update due to 
	 * its call to updateMap as mentioned before.
	 */
	public static void Lab2() throws InterruptedException {
		final Question q = new Question();
		q.questionpick();
		final StringMap s = new StringMap();
		final JFrame fram = new JFrame("Riddler's Labyrinth (???)");
		final Maze z = new Maze();
		final Player p = new Player(z);
		final Window _w = new Window();
		int a = _w.option(Replay, "Welcome to the Labyrinth.\nWould you like to skip the introduction?");
		if(a == 1) {
		Window.msg("You awake in an underground labyrinth, your face against the hard tiled floor as the rock-walls surround you, only part of the wall having a passage you can go through.\n"
				+ "Soon, a robot's mechanical voice echos throughout the room. 'So you're awake now?' the robot says in a monotonous tone. 'We can finally get to testing.'\n"
				+ "The passage way ahead brightens up as torches lining the walls are suddenly lit. The robot's voice comes back on.\n'Ahead of you is a passage leading towards the exit. Its up to you to answer the randomly scattered questions and make it out.'\n"
				+ "'Dont worry, these questions will cater to that stupid human brain of yours. Well hurry up now, we dont have all day.'\nThe robot's voice disappears, leaving only you and the halls ahead to escape.");
		Window.msg("If you need any help, just press H for assistance, press C for credits, and press E to exit.\nBy the way, WASD or Arrow Keys to move :)");
		fram.setVisible(true);
		fram.setSize(800,800);
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fram.setResizable(false);
		scene = s.updateMap(p, z, "",  _w, q);
		fram.add(scene);
	
		fram.add(s.getMap());
		fram.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
	
			public void keyReleased(KeyEvent e) { }
	
			public void keyPressed(KeyEvent e) {
				int input = e.getKeyCode();
				if (input == KeyEvent.VK_W || input == KeyEvent.VK_UP) {
					try {
						scene = s.updateMap(p, z, "NORTH",  _w, q);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					fram.add(scene);
					fram.revalidate();
				} else if (input == KeyEvent.VK_S || input == KeyEvent.VK_DOWN) {
					try {
						scene = s.updateMap(p, z, "SOUTH",  _w, q);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
					fram.add(scene);
					fram.revalidate();
				} else if (input == KeyEvent.VK_D || input == KeyEvent.VK_RIGHT) {
					try {
						scene = s.updateMap(p, z, "EAST",  _w, q);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
					fram.add(scene);
					fram.revalidate();
				} else if (input == KeyEvent.VK_A || input == KeyEvent.VK_LEFT) {
					try {
						scene = s.updateMap(p, z, "WEST",  _w, q);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					fram.add(scene);
					fram.revalidate();
				}
				else if (input == KeyEvent.VK_C) {
					 Window.msg("Credits: Julian Garcia");
				}
				else if (input == KeyEvent.VK_E) {
					 System.exit(0);
					}
				 else if(input == KeyEvent.VK_H){
					 Window.msg("Game Breakdown:\n"
								+ "This game features you the player, navigating a labyrinth with an exit at the end.\nYou move with WASD or Arrow Keys and must get to the green box labeled 'exit' to escape.\n"
								+ "The player's image is a human in an orange outfit.\nAs you progress, you may stumble upon questions that must be answered correctly to proceed.\n"
								+ "Failure to get the correct answer will result in the player being unable to move for a moment or be brought back to spawn.\nGood luck making it out.");
				}
			};
		});
	
		fram.revalidate();
		}
		else {
		
		Window.msg("If you need any help, just press H for assistance, press C for credits, and press E to exit.\nBy the way, WASD or Arrow Keys to move :)");
		fram.setVisible(true);
		fram.setSize(800,800);
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fram.setResizable(false);
		scene = s.updateMap(p, z, "",  _w, q);
		fram.add(scene);
	
		fram.add(s.getMap());
		fram.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
	
			public void keyReleased(KeyEvent e) { }
	
			public void keyPressed(KeyEvent e) {
				int input = e.getKeyCode();
				if (input == KeyEvent.VK_W || input == KeyEvent.VK_UP) {
					try {
						scene = s.updateMap(p, z, "NORTH",  _w, q);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					fram.add(scene);
					fram.revalidate();
				} else if (input == KeyEvent.VK_S || input == KeyEvent.VK_DOWN) {
					try {
						scene = s.updateMap(p, z, "SOUTH",  _w, q);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
					fram.add(scene);
					fram.revalidate();
				} else if (input == KeyEvent.VK_D || input == KeyEvent.VK_RIGHT) {
					try {
						scene = s.updateMap(p, z, "EAST",  _w, q);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					fram.add(scene);
					fram.revalidate();
				} else if (input == KeyEvent.VK_A || input == KeyEvent.VK_LEFT) {
					try {
						scene = s.updateMap(p, z, "WEST",  _w, q);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
					fram.add(scene);
					fram.revalidate();
				}
				else if (input == KeyEvent.VK_C) {
				 Window.msg("Credits: Julian Garcia");
			}
				else if (input == KeyEvent.VK_E) {
					 System.exit(0);
					}
				 else if(input == KeyEvent.VK_H){
				Window.msg("Game Breakdown:\n"
						+ "This game features you the player, navigating a labyrinth with an exit at the end.\nYou move with WASD or Arrow Keys and must get to the green box labeled 'exit' to escape.\n"
						+ "The player's image is a human in an orange outfit.\nAs you progress, you may stumble upon questions that must be answered correctly to proceed.\n"
						+ "Failure to get the correct answer will result in the player being unable to move for a moment or be brought back to spawn.\nGood luck making it out.");
				}
			};
		});
	
		fram.revalidate();
		}
	}
}