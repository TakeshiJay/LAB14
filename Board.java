/** Board class is the tik tac toe initial gameboard */
public class Board {
	/** board is our 2-d array that initializes a empty board */
	private char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, };

	/**
	 * placeToken takes the current token whether 'X' or 'O' and places it in
	 * collumns position
	 * 
	 * @param token is going to be the 'X' or 'O' for the board
	 * @param row   is the current xValue or row of the specified character
	 * @param col   is the current yValue or collumn of the specified character
	 */
	public boolean placeToken(char token, int row, int col) {
		if (board[row][col] != ' ') {
			return false;
		}
		board[row][col] = token;
		return true;
	}

	/**
	 * display display's the board and prints according to user call in main
	 */
	public void display() {
		System.out.println("  0 1 2");
		System.out.println("0 " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("  -----");
		System.out.println("1 " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("  -----");
		System.out.println("2 " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
	}

	/**
	 * save method is used as a callback functionthat stores the previous state of
	 * the board
	 * 
	 * @return the Previous state of the board
	 */
	public Memento save() {
		return new Memento(board);
	}

	/**
	 * Restores the moment of the board that was called last LIFO
	 * 
	 * @param m the moment of the board at that current state
	 */
	public void restore(Memento m) {
		for (int i = 0; i < m.getState().length; ++i) {
			for (int j = 0; j < m.getState()[0].length; ++j) {
				board[i][j] = m.getState()[i][j];
			}
		}
	}

	/**
	 * Takes in the last move inputted and calculates if a win has been made.
	 * 
	 * @param token the last char inputted into the board
	 * @param row   the row of the last inputted
	 * @param col   the column of the last inputted
	 * @return the token if the last move won, a space if no win is found, and t if
	 *         the board has been filled up
	 */
	public char checkWinner(char token, int row, int col) {
		if (board[row][0] == token && board[row][1] == token && board[row][2] == token)
			return token;
		else if (board[0][col] == token && board[1][col] == token && board[2][col] == token)
			return token;
		else if (board[0][0] == token && board[1][1] == token && board[2][2] == token)
			return token;
		else if (board[0][2] == token && board[1][1] == token && board[2][0] == token)
			return token;
		else if (this.fullBoard())
			return 't';
		else
			return ' ';
	}

	/**
	 * Checks if the board is full and returns its state.
	 * 
	 * @return true if the board if full, and false otherwise
	 */
	public boolean fullBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ')
					return false;
			}
		}
		return true;
	}
}




