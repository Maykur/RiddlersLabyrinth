package mod;
import view.*;

public class Player {
	//INSTANCE VARIABLES
	public Position _curPos;
	private Window _w;
	private boolean _isAlive = true;
	
	//GETTERS
	public Position getPosition() { return _curPos; }
	public boolean isAlive() { return _isAlive; }

	//SETTERS
	public void setPosition(Position p) { _curPos = p; }
	public void killPlayer() { _isAlive = false; _curPos= new Position(1,0); }
	public Position setPosition(Maze z) { return  _curPos = new Position(z.getStart().getRow(), z.getStart().getCol()); }
	
	//CONSTRUCTOR
	public Player(Maze z) {
		_curPos = new Position(z.getStart().getRow(), z.getStart().getCol());
	}
	
	/*
	 * This method moves the player according to their direction inputed and maze parameter. If player went north and the maze says they can, then the player's icon is moved forward, 
	 * else, they just stand in place. Returns true if they can move and false if they cannot
	 */
	public boolean move(Direction d, Maze z) {
		if(_isAlive == true) {
		if(d == Direction.North) {
			if(_curPos.getRow() - 1 >= 0 && !z.getMaze()[_curPos.getRow() - 1]
					[_curPos.getCol()]) {
				_curPos = new Position(_curPos.getRow() - 1, _curPos.getCol());
				return true;
			}
		}
		else if(d == Direction.South) {
			if(_curPos.getRow() + 1 < z.getMaze().length && !z.getMaze()[_curPos.getRow() + 1]
					[_curPos.getCol()]) {
				_curPos = new Position(_curPos.getRow() + 1, _curPos.getCol());
				return true;
			}
		}
		else if(d == Direction.East) {
			if(_curPos.getCol() + 1 < z.getMaze()[_curPos.getRow()].length && !z.getMaze()[_curPos.getRow()]
					[_curPos.getCol() + 1]) {
				_curPos = new Position(_curPos.getRow(), _curPos.getCol() + 1);
				return true;
			}	
		}
		else {
			if(_curPos.getCol() - 1 >= 0 && !z.getMaze()[_curPos.getRow()][_curPos.getCol()- 1]) {
				_curPos = new Position(_curPos.getRow(), _curPos.getCol() - 1);
				return true;
			}
		}
		}
		return false;
	}

}
