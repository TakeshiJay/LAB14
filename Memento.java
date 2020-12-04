/**
 * Memento class is a reverter class to refer the current state of the board to
 * its last known state
 */
public class Memento {
	/** board is the memento's board that will be back-tracked/logged */
	private char[][] board;

	/**
	 * Memento is a overrloaded constructor that initializes the memento's board
	 * param b is the board that will be save in accordance to the main
	 */
	public Memento(char[][] b) {
		board = new char[b.length][b[0].length];
		for (int i = 0; i < b.length; ++i) {
			for (int j = 0; j < b[0].length; ++j) {
				board[i][j] = b[i][j];
			}
		}
	}

	/**
	 * getState is a getter function that returns the mementoBoard
	 * 
	 * @return the backtracked board
	 */
	public char[][] getState() {
		return board;
	}
}