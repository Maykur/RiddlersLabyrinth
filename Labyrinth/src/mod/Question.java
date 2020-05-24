package mod;

import view.*;

import java.util.ArrayList;
import java.util.Collections;

import mod.Maze;
import mod.Position;

public class Question {
	//INSTANCE VARIABLES
	private static Position _curPos1;
	private static Position _curPos2;
	private static Position _curPos3;
	private static Position _curPos4;
	private static Position _curPos5;
	private static Position _curPos6;
	public ArrayList<Position> firstPosition =  new ArrayList<Position>();
	ArrayList<Integer> nums = new ArrayList<Integer>();
	
	//GETTERS
	public Position getPosition1() { return _curPos1;	}
	public Position getPosition2() { return _curPos2;	}
	public Position getPosition3() { return _curPos3;	}
	public Position getPosition4() { return _curPos4;	}
	public Position getPosition5() { return _curPos5;	}
	public Position getPosition6() { return _curPos6;	}
	public Position getQuestPos1() { return firstPosition.get(0);	}
	public Position getQuestPos2() { return firstPosition.get(1);	}
	public Position getQuestPos3() { return firstPosition.get(2);	}
	public Position getQuestPos4() { return firstPosition.get(3);	}
	public Position getQuestPos5() { return firstPosition.get(4);	}
	public Position getQuestPos6() { return firstPosition.get(5);	}
	
	/*
	 * This method adds all of the potential questions to the firstPosition
	 * ArrayList at set positions to then be randomly picked out for later use
	 */
	public void addQuestions() {
	firstPosition.add(new Position(1,6));
	firstPosition.add(new Position(8,12));
	firstPosition.add(new Position(1,19));
	firstPosition.add(new Position(16,14));
	firstPosition.add(new Position(19,1));
	firstPosition.add(new Position(10,16));
	firstPosition.add(new Position(1,1)); 
	firstPosition.add(new Position(7,1));
	firstPosition.add(new Position(11,2)); 
	firstPosition.add(new Position(13,2));
	firstPosition.add(new Position(13,7)); 
	firstPosition.add(new Position(13,13)); 
	firstPosition.add(new Position(17,18));
	firstPosition.add(new Position(19,10));
	firstPosition.add(new Position(17,6));
	}
	
	/*
	 * This method removes the question off the board by setting it off the screen and in
	 * a corner that the player cannot access anymore and is hidden behind the wall texture
	 */
	public void killQues(int s){
		if (s==1) {
			firstPosition.set(0, new Position(0,0));
		}
		if (s==2) {
			firstPosition.set(1, new Position(0,0));
		}
		if (s==3) {
			firstPosition.set(2, new Position(0,0));
		}
		if (s==4) {
			firstPosition.set(3, new Position(0,0));
		}
		if (s==5) {
			firstPosition.set(4, new Position(0,0));
		}
		if (s==6) {
			firstPosition.set(5, new Position(0,0));
		}
	}
	
	/*
	 * This method calls the addQuestions method, which adds the questions to the firstPosition array list
	 * and then shuffles it, mixing up the order of positions. It then calls the newList method, which adds numbers to
	 * the nums array list
	 */
	public void questionpick() {
		addQuestions();
		Collections.shuffle(firstPosition);
		newList();
		Collections.shuffle(nums);
	}
	
	/*
	 * This method adds a total of 15 numbers (starting at 0 and ends at 14) to the nums
	 * array list which will be used later to set a question to a certain position
	 */
	public void newList() {
		nums.add(0);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);
		nums.add(7);
		nums.add(8);
		nums.add(9);
		nums.add(10);
		nums.add(11);
		nums.add(12);
		nums.add(13);
		nums.add(14);
	}
	
	/*
	 * This method sets an int named num1 equal to a random number in between 0 and 14, from the nums list
	 * and is then used for the askQuestions method, passing in whatever num1 was equal to as a parameter, to see
	 * what question is assigned for that position
	 */
	public boolean randomQuestion1(Player p, Maze m) throws InterruptedException{
		int num1 = nums.get(0);
		askQuestions(num1, p, m);
		return true;
	}
	
	/*
	 * This method sets an int named num2 equal to a random number in between 0 and 14, (excluding repeated numbers) from the nums list
	 * and is then used for the askQuestions method, passing in whatever num2 was equal to as a parameter, to see
	 * what question is assigned for that position
	 */
	public boolean randomQuestion2(Player p, Maze m) throws InterruptedException{
		int num2 =  nums.get(1);
		askQuestions(num2, p, m);
		return true;
	}
	
	/*
	 * This method sets an int named num3 equal to a random number in between 0 and 14, (excluding repeated numbers) from the nums list
	 * and is then used for the askQuestions method, passing in whatever num3 was equal to as a parameter, to see
	 * what question is assigned for that position
	 */
	public boolean randomQuestion3(Player p, Maze m) throws InterruptedException{
		int num3 =  nums.get(2);
		askQuestions(num3, p, m);
		return true;
	}
	
	/*
	 * This method sets an int named num4 equal to a random number in between 0 and 14, (excluding repeated numbers) from the nums list
	 * and is then used for the askQuestions method, passing in whatever num4 was equal to as a parameter, to see
	 * what question is assigned for that position
	 */
	public boolean randomQuestion4(Player p, Maze m) throws InterruptedException{
		int num4 =  nums.get(3);
		askQuestions(num4, p, m);
		return true;
	}
	
	/*
	 * This method sets an int named num5 equal to a random number in between 0 and 14, (excluding repeated numbers) from the nums list
	 * and is then used for the askQuestions method, passing in whatever num5 was equal to as a parameter, to see
	 * what question is assigned for that position
	 */
	public boolean randomQuestion5(Player p, Maze m) throws InterruptedException{
		int num5 =  nums.get(4);
		askQuestions(num5, p, m);
		return true;
	}
	
	/*
	 * This method sets an int named num6 equal to a random number in between 0 and 14, (excluding repeated numbers) from the nums list
	 * and is then used for the askQuestions method, passing in whatever num6 was equal to as a parameter, to see
	 * what question is assigned for that position
	 */
	public boolean randomQuestion6(Player p, Maze m) throws InterruptedException{
		int num6 =  nums.get(5);
		askQuestions(num6, p, m);
		return true;
	}
	
	/*
	 * This method uses the number passed in from the randomQuestion method to see what question will be asked and depending on if they get it right or wrong, what'll happen.
	 * A JOptionPane window opens displaying the question with a text box to type in the answer to said question. If the user types in 
	 * the correct response, nothing happens and they can continue forward. However, if they get the question wrong, either 2 penalties can occur.
	 * The user will either be set back towards the beginning of the game, and just have to journey back to where they started, or the game freezes momentarily.
	 * This is why many methods are seen throwing the InterruptedException, the Thread.sleep() method requires it.
	 */
	public static boolean askQuestions(int s, Player p, Maze m) throws InterruptedException {
		int cnt = 0;
		if(s == 0) {
			Window Msg = new Window();
			String b = Msg.in("What is Obama's last name?");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
				Window.msg("You regain your composure and continue to move forward");
				return true;
	        }
			if(b.equalsIgnoreCase("Obama")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
				Window.msg("You regain your composure and continue to move forward");
				return true;
			}
		}
		if(s == 1) {
			Window Msg = new Window();
			String b = Msg.in("What is the tallest building in the world currently?\nHint: 2,717¡ä, 2,722¡ä to tip");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
	        }
			if(b.equalsIgnoreCase("Burj Khalifa")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
				
			}
		}
		if(s == 2) {
			Window Msg = new Window();
			String b = Msg.in("Who is the current principal of TERRA?\nMr. ______");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
				Window.msg("You regain your composure and continue to move forward");
				return true;
	        }
			if(b.equalsIgnoreCase("Sirven")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
	
				 Window.msg("You regain your composure and continue to move forward");
				 cnt++;
				return true;
			}
		}
		if(s == 3) {
			Window Msg = new Window();
			String b = Msg.in("Who invented the first video game console?\n_____ ____");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
	        }
			if(b.equalsIgnoreCase("Ralph Baer")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
			}
		}
		if(s == 4) {
			Window Msg = new Window();
			String b = Msg.in("What element is represented as Li in the Periodic Table of Elements?");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
	        }
			if(b.equalsIgnoreCase("Lithium")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
			}
		}
		if(s == 5) {
			Window Msg = new Window();
			String b = Msg.in("What element is represented as B in the Periodic Table of Elements?");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
				Window.msg("You regain your composure and continue to move forward");
				return true;
	        }
			if(b.equalsIgnoreCase("Boron")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
				 Window.msg("You regain your composure and continue to move forward");
				 cnt++;
				return true;
			}
		}
		if(s == 6) {
			Window Msg = new Window();
			String b = Msg.in("Who wrote The Raven?\n_____ Allan Poe");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
				Window.msg("You regain your composure and continue to move forward");
				return true;
	        }
			if(b.equalsIgnoreCase("Edgar")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
				 Window.msg("You regain your composure and continue to move forward");
				 cnt++;
				return true;
			}
		}
		if(s==7) {
			Window Msg = new Window();
			String b = Msg.in("What is Mr. Rico's last name?");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
				Window.msg("You regain your composure and continue to move forward");
				return true;
	        }
			if(b.equalsIgnoreCase("Rico")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
	
				 Window.msg("You regain your composure and continue to move forward");
				 cnt++;
				return true;
			}
		}
		if(s == 8) {
			Window Msg = new Window();
			String b = Msg.in("Who is the person who made minecraft?\n______ Persson");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
	        }
			if(b.equalsIgnoreCase("Markus")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
			}
		}
		if(s == 9) {
			Window Msg = new Window();
			String b = Msg.in("What sport does Mr. Garland coach in TERRA?\nHint: Involves pins");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
				Window.msg("You regain your composure and continue to move forward");
				return true;
	        }
			if(b.equalsIgnoreCase("Bowling")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
	
				 Window.msg("You regain your composure and continue to move forward");
				 cnt++;
				return true;
			}
		}
		if(s == 10) {
			Window Msg = new Window();
			String b = Msg.in("What famous 'unsinkable' boat sank?\nThe _______");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
	        }
			if(b.equalsIgnoreCase("Titanic")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
			}
		}
		if(s == 11) {
			Window Msg = new Window();
			String b = Msg.in("What state is represented as FL?");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
				Window.msg("You regain your composure and continue to move forward");
				return true;
	        }
			if(b.equalsIgnoreCase("Florida")) {
				Window.msg("Correct!");
			return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				
				 Thread.sleep(3000);
				
				 Window.msg("You regain your composure and continue to move forward");
				 cnt++;
				return true;
			}
		}
		if(s == 12) {
			Window Msg = new Window();
			String b = Msg.in("What state is represented as NY?\n___ ____");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				Thread.sleep(3000);
				Window.msg("You regain your composure and continue to move forward");
				return true;
	        }
			if(b.equalsIgnoreCase("New York")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				 Window.msg("The robot's voice echos from a nearby speaker, 'Wrong! Are you seriously that dumb?'\nYour stupidity overwhelms you, causing you to stop in place momentarily.");
				 Thread.sleep(3000);
				 Window.msg("You regain your composure and continue to move forward");
				 cnt++;
				return true;
			}
		}
		if(s==13) {
			Window Msg = new Window();
			String b = Msg.in("Who sailed the ocean blue in 1492?\n(First and last name included)");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
	        }
			if(b.equalsIgnoreCase("christopher columbus")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
			}
		}
		if(s==14) {
			Window Msg = new Window();
			String b = Msg.in("who was the first president of the United States\n(First and last name included)");
			if(b==null)
	        {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
	        }
			if(b.equalsIgnoreCase("George Washington")) {
				Window.msg("Correct!");
				return true;
			}
			else {
				Window.msg("The robot's voice echos from a nearby speaker, 'Your failure to answer questions like these annoy me, back to the start!'\n"
						+ "Your surrounding suddenly changes, as you find out you've been teleported back to the start.");
				p.setPosition(m);
				return true;
			}
		}
	return true;
	}
}



