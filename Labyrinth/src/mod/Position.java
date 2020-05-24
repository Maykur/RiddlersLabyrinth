package mod;

public class Position {
	//INSTANCE VARIABLES
	private int _row;
	private int _col;
	
	//GETTERS
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	
	//CONSTRUCTOR
	public Position(int r, int c) {
		_row = r;
		_col = c;
	}
}