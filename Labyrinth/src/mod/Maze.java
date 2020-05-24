package mod;

public class Maze {
	//INSTANCE VARIABLES
	private boolean[][] _maze;
	private Position _start;
	private Position _end;
	private Position _rat1;
	private Position _rat2;
	private Position _rat3;
	private Position _sword;
	private Position _mTar;
	public Position _mmap;
	private boolean sfalse = false;
	private boolean efalse = false;
	private boolean mapfalse = false;
	private boolean pfalse = false;
	private boolean r1false = false;
	private boolean r2false = false;
	private boolean r3false = false;
	private boolean mfalse = false;
	private static final int PLAYER_START_ROW = 10;
	private static final int PLAYER_START_COL = 10;
	private static final int PLAYER_END_ROW = 20;
	private static final int PLAYER_END_COL = 18;

	//GETTERS
	public Position getStart() { return _start; }
	public Position getEnd() { return _end; }
	public boolean[][] getMaze() { return _maze; }
	
	//CONSTRUCTOR
	public Maze() {
		// true is a wall.
		boolean[][] maze = 
			{{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
					 {true, false, false, false, true, false, false, false, true, true, true, true, true, true, true, true, false, false, false, false, true},
					 {true, false, true, false, true, false, true, false, true, true, true, true, true, true, true, true, false, true, true, false, true},
					 {true, false, true, false, true, false, true, false, true, true, true, true, true, true, true, true, false, true, true, false, true},
					 {true, false, true, false, false, false, true, false, false, false, false, false, false, false, false, false, false, true, true, false, true},
					 {true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true},
					 {true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, true},
					 {true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true},
					 {true, false, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, true, false, true, true},
					 {true, false, true, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true, false, true, true},
					 {true, false, true, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true, false, true, true},
					 {true, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, false, true, false, true, true},
					 {true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, false, false, false, true, true},
					 {true, false, false, false, false, true, false, false, false, true, true, true, false, false, false, true, true, true, true, true, true},
					 {true, false, true, true, true, true, false, true, false, true, true, true, false, true, false, true, true, true, true, true, true},
					 {true, false, false, false, false, true, false, true, false, true, true, true, false, true, false, true, true, true, true, true, true},
					 {true, true, true, true, false, true, false, true, false, true, true, true, false, true, false, false, false, false, false, true, true},
					 {true, false, false, false, false, true, false, true, false, true, true, true, false, true, true, true, true, true, false, true, true},
					 {true, false, true, true, true, true, false, true, false, true, true, true, false, true, true, true, true, true, false, true, true},
					 {true, false, false, false, false, false, false, true, false, false, false, false, false, true, true, true, true, true, false, true, true},
					 {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true}};
		_maze = maze;
		_start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
		_end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
	}
}
