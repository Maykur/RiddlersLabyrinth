package view;
	import java.awt.BorderLayout;
	import java.awt.GridLayout;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.util.ArrayList;
	
	import javax.swing.*;

import mod.*;
import cont.*;

public class StringMap extends JFrame {
	//INSTANCE VARIABLES
	private static final String[] Loop = {"Continue"};
	private static final String[] Replay = {"Yes", "No"};
	private static final long serialVersionUID = 1L;
	Window _w;
	private JPanel _map = new JPanel(new GridLayout(21, 21));
	private JLabel[][] Maze = new JLabel[21][21];
	private boolean test = false;
	private Icon wall2 = new ImageIcon(getClass().getResource("cob (2).jpg"));
	private Icon player2 = new ImageIcon(getClass().getResource("ClassD.jpg"));
	private Icon floor2 = new ImageIcon(getClass().getResource("path2 (1).jpg"));
	private Icon exit2 = new ImageIcon(getClass().getResource("exit (1) (1).jpg"));
	private Icon Q1 = new ImageIcon(getClass().getResource("mario (1).jpg"));
	private Icon Q2 = new ImageIcon(getClass().getResource("mario (1).jpg"));
	private Icon Q3 = new ImageIcon(getClass().getResource("mario (1).jpg"));
	private Icon Q4 = new ImageIcon(getClass().getResource("mario (1).jpg"));
	private Icon Q5 = new ImageIcon(getClass().getResource("mario (1).jpg"));
	private Icon Q6 = new ImageIcon(getClass().getResource("mario (1).jpg"));
	

	//GETTER
	public JPanel getMap() {
		return _map;
	}

	/*
	 * This method does everything for GUI, it displays every image seen and does so by using the boolean map created in the Maze class.
	 * The method creates a new JPanel with a layout of 21x21 and takes input from player. It checks if the player is alive first before doing a move and then
	 * checks to see if the player's input equals NORTH (w), SOUTH (s), EAST (d), or WEST (a) and will the use the p.move method to move the player and then checks the game
	 * with gameCheck to see if the player is at anywhere important (on a question block or exit). The for loop is what sets the elements in the JPanel to icons that were
	 * initialized above and gets each position's location with the getPosition method from each class. It'll return the map afterwards which is where in the Main class,
	 * the frame can set it's JPanel (Scene) equal to this updated JPanel.
	 */
	public JPanel updateMap(Player p, Maze z, String userIn, Window _w, Question q1) throws InterruptedException {
		_map = new JPanel(new GridLayout(21, 21));
		if(p.isAlive() == true) {
		if (userIn.equals("NORTH")) {
			if (z.getMaze()[p.getPosition().getRow()-1][p.getPosition().getCol()] == false) {
				p.move(Direction.North, z);
				gameCheck(p, z, userIn,  _w, q1);
				
			} 
		}
		else if (userIn.equals("SOUTH")) {
			if (z.getMaze()[p.getPosition().getRow()+1][p.getPosition().getCol()] == false){
				p.move(Direction.South, z);
				gameCheck(p, z, userIn,  _w, q1);
				
			}
		}
		else if (userIn.equals("WEST")) {
			if (z.getMaze()[p.getPosition().getRow()][p.getPosition().getCol()-1] == false) {
				p.move(Direction.West, z);
				//gameCheck1(p, m, z, r1, r2, r3,  userIn,  _w,  sw, ma);
				gameCheck(p, z, userIn,  _w, q1);
			
			} 
		}
		else if (userIn.equals("EAST")) {
			if (z.getMaze()[p.getPosition().getRow()][p.getPosition().getCol()+1] == false) {
				p.move(Direction.East, z);
				gameCheck(p, z, userIn,  _w, q1);
				
			} 
		}
		}
		for (int r = 0; r < z.getMaze().length; r++) {
			for (int c = 0; c < z.getMaze()[r].length; c++) {
				//if userIn.equals("NORTH") move player r by - 1 if empty space above
				
				if (z.getMaze()[r][c]) {
					Maze[r][c] = new JLabel(wall2);
					_map.add(Maze[r][c]);
				} else if (r == p.getPosition().getRow() &&
						c == p.getPosition().getCol()) {
					Maze[r][c] = new JLabel(player2);
					_map.add(Maze[r][c]);
				
				} else if (r == z.getEnd().getRow() &&
						c == z.getEnd().getCol()) {
					Maze[r][c] = new JLabel(exit2);
					_map.add(Maze[r][c]);
				
			} else if (null != q1.getQuestPos1() && r == q1.getQuestPos1().getRow() &&
					c == q1.getQuestPos1().getCol()) {
				Maze[r][c] = new JLabel(Q1);
				_map.add(Maze[r][c]);
			}
			else if (null != q1.getQuestPos2() && r == q1.getQuestPos2().getRow() &&
					c == q1.getQuestPos2().getCol()) {
				Maze[r][c] = new JLabel(Q2);
				_map.add(Maze[r][c]);
			}
			else if (null != q1.getQuestPos3() && r == q1.getQuestPos3().getRow() &&
					c == q1.getQuestPos3().getCol()) {
				Maze[r][c] = new JLabel(Q3);
				_map.add(Maze[r][c]);
			}
			else if (null != q1.getQuestPos4() && r == q1.getQuestPos4().getRow() &&
					c == q1.getQuestPos4().getCol()) {
				Maze[r][c] = new JLabel(Q4);
				_map.add(Maze[r][c]);
			}
			else if (null != q1.getQuestPos5() && r == q1.getQuestPos5().getRow() &&
					c == q1.getQuestPos5().getCol()) {
				Maze[r][c] = new JLabel(Q5);
				_map.add(Maze[r][c]);
			}
			else if (null != q1.getQuestPos6() && r == q1.getQuestPos6().getRow() &&
					c == q1.getQuestPos6().getCol()) {
				Maze[r][c] = new JLabel(Q6);
				_map.add(Maze[r][c]);
			}
			else {
					Maze[r][c] = new JLabel(floor2);
					_map.add(Maze[r][c]);
				}

			}
		}
		return _map;
	}
		
	/*
	 * This method first checks is the player is at the exit's position by using the getPosition method on both the exit and player. If so 
	 * it'll end the game and pop up a congrats window that tells the player they won. The next thing it checks is if the player
	 * is on top of a question block. If so, the game will ask the user a random question using the randomQuestion method from earlier
	 * and passes in the player and maze as a parameter since the randomQuestion method uses the askQuestion method which has one of its penalties resulting
	 * in the player going back to the beginning. After asking the question, the question is "killed" and the player may move on. There are only 6
	 * questions to worry about so that's why we are only checking it 6 times.
	 */
	public void gameCheck(Player _p,  Maze _z, String userIn, Window _w, Question q1) throws InterruptedException {
		if (_p.getPosition().getRow() == _z.getEnd().getRow() && _p.getPosition().getCol() == _z.getEnd().getCol()) {
			_p.killPlayer();
			ImageIcon congrats = new ImageIcon(getClass().getResource("congrats (2).jpg"));
			JOptionPane.showMessageDialog(null, "You walk through the exit, seeing the robot whose been talking to you through the speaker sitting on a chair.\n"
					+ "'So you actually made it out, surprising since not many have made it this far.' The robot moves in close on you. 'Well for making it out I have a gift to reward you.'\n"
					+ "The robot moves out of the way, revealing a chocolate cake behind them. You move close and read the words 'Congratulations' written on it.\n"
					+ "You take a slice and start to eat the cake as you enjoy your victory.\nThe End.","Congrats!", JOptionPane.INFORMATION_MESSAGE, congrats);
			System.exit(0);
		}
		if (null != q1.getQuestPos1() &&_p.getPosition().getRow() == q1.getQuestPos1().getRow() && _p.getPosition().getCol() == q1.getQuestPos1().getCol()) {
			if(q1.randomQuestion1(_p, _z)) q1.killQues(1);
		}
		if (null != q1.getQuestPos2() &&_p.getPosition().getRow() == q1.getQuestPos2().getRow() && _p.getPosition().getCol() == q1.getQuestPos2().getCol()) {
			if(q1.randomQuestion2(_p, _z)) q1.killQues(2);
		}
		if (null != q1.getQuestPos3() &&_p.getPosition().getRow() == q1.getQuestPos3().getRow() && _p.getPosition().getCol() == q1.getQuestPos3().getCol()) {
			if(q1.randomQuestion3(_p, _z)) q1.killQues(3);
		}
		if (null != q1.getQuestPos4() &&_p.getPosition().getRow() == q1.getQuestPos4().getRow() && _p.getPosition().getCol() == q1.getQuestPos4().getCol()) {
			if(q1.randomQuestion4(_p, _z)) q1.killQues(4);
		}
		if (null != q1.getQuestPos5() &&_p.getPosition().getRow() == q1.getQuestPos5().getRow() && _p.getPosition().getCol() == q1.getQuestPos5().getCol()) {
			if(q1.randomQuestion5(_p, _z)) q1.killQues(5);
		}
		if (null != q1.getQuestPos6() &&_p.getPosition().getRow() == q1.getQuestPos6().getRow() && _p.getPosition().getCol() == q1.getQuestPos6().getCol()) {
			if(q1.randomQuestion6(_p, _z)) q1.killQues(6);
		}
	}
}