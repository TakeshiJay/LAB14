import java.util.*;
import java.util.Random;

/**
 * A program that simulates a tic-tac-toe game.
 * 
 * @author Catherine Bui, Jacob Sunia, Paul Cao
 * @version 12/01/2020
 */
public class Main {
	/**
	 * Prompts user for their choice that places their token and the computer
	 * generated one, reverts the user's token, or quits the game.
	 */
	public static void main(String[] args) {
		Stack<Memento> history = new Stack<Memento>();
		Random ran = new Random();
		Board b = new Board();
		int rowChoice = 0;
		int colChoice = 0;
		char symbol = 'x';
		int choice = 0;

		while (choice != 3) {
			b.display();
			System.out.println("1. Place Token\n2. Revert\n3. Quit");
			choice = CheckInput.getIntRange(1, 3);

			if (choice == 1) {
				history.push(b.save());
				do {
					System.out.println("Place an " + symbol);
					System.out.print("1. Row: ");
					rowChoice = CheckInput.getIntRange(0, 2);
					System.out.print("2. Col: ");
					colChoice = CheckInput.getIntRange(0, 2);

				} while (!b.placeToken(symbol, rowChoice, colChoice));
				char result = b.checkWinner(symbol, rowChoice, colChoice);
				if (result == symbol) {
					b.display();
					System.out.println("Game Over!");
					System.out.println(symbol + " has won!");
					break;
				} else if (result == 't') {
					b.display();
					System.out.println("Game Over!");
					System.out.println("It's a tie!");
					break;
				}
				symbol = 'o';
				while (!b.placeToken(symbol, rowChoice, colChoice)) {
					rowChoice = ran.nextInt(3);
					colChoice = ran.nextInt(3);
				}
				System.out.println("Placing an " + symbol);
				System.out.println("1. Row: " + rowChoice);
				System.out.println("2. Col: " + colChoice);
				result = b.checkWinner(symbol, rowChoice, colChoice);
				if (result == symbol) {
					b.display();
					System.out.println("Game Over!");
					System.out.println(symbol + " has won!");
					choice = 3;
				} else if (result == 't') {
					b.display();
					System.out.println("Game Over!");
					System.out.println("It's a tie!");
					choice = 3;
				}
				symbol = 'x';
			} else if (choice == 2) {
				if (history.isEmpty()) {
					System.out.println("You cannot revert!");
				} else {
					b.restore(history.pop());
				}
			} else if (choice == 3) {
				System.out.println("You've chosen to quit, bye!");
			}
		}
	}
}