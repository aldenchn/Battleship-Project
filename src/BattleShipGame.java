import java.util.Scanner;

public class BattleShipGame {
	private Ocean ocean;
	private Scanner scnr;

	/**
	 * Initialize the game - creates an empty ocean, place 10 <code>ships</code>
	 * randomly on board and initialize a scanner to take in user inputs later
	 */

	public BattleShipGame() {
		this.ocean = new Ocean();
		this.ocean.placeAllShipsRandomly();
		this.scnr = new Scanner(System.in);
	}

	/**
	 * This method interacts with the user and do the following things when the
	 * player hasn't sunk all 10 ships:
	 * 
	 * 1. Print out the current board 2. Shoot at one location. 3. Print out hit or
	 * miss information accordingly.
	 * 
	 * When game is over, ask the player if he/she wants to play again. If so,
	 * restart the game.
	 */

	public void start() {
		System.out.print("Game Start! \nHere is your board:\n");
		ocean.print();
		// check if game over
		while (true) {
			if (ocean.isGameOver()) {
				System.out.print("Game is over!\n");
				printScore();
				while (true) {
					scnr.nextLine();
					System.out.print("Do you want to play again? Enter 'yes' or 'no' \n");
					String ans = scnr.nextLine();
					ans = ans.trim();
					if (ans.equals("no")) {
						return;
					} else if (ans.equals("yes")) {
						BattleShipGame newgame = new BattleShipGame();
						newgame.start();
					} else {
						System.out.print("Input not valid. \n");
					}
				}
			}
			fireShot();
			ocean.print();
		}
	}

	// this helper method shoots at one location in ocean based on user input
	private void fireShot() {
		int inputRow = rowColNumberInputHelper("row");
		int inputCol = rowColNumberInputHelper("col");
		boolean hitOrMiss = ocean.shootAt(inputRow, inputCol);
		if (hitOrMiss) {
			Ship[][] shipArr = ocean.getShipArray();
			if (shipArr[inputRow][inputCol].isSunk()) {
				System.out.println("Hit! You just sunk a " + shipArr[inputRow][inputCol].getShipType()
						+ ". Here is the board now:");
			} else {
				System.out.println("Hit! Here is the board now:");
			}
		} else {
			System.out.println("Miss! Here is the board now:");
		}
	}

	// this helper takes in row/column and interacts with the user inputs to decide
	// the row and column the user wants to shoot at
	private int rowColNumberInputHelper(String rowOrCol) {
		while (true) {
			int input = -1;
			System.out.printf("Please enter the %s number you want to shoot at.\n", rowOrCol);
			if (scnr.hasNextInt()) { // checks if the input is an integer
				input = scnr.nextInt();
			} else {
				scnr.next(); // if the input is not an integer, skip the input
			}
			if (input > 9 || input < 0) {
				System.out.printf("Invalid input - %s number should be an integer from 0 to 9. Please re-enter.\n",
						rowOrCol);
			} else {
				return input;
			}
		}
	}

	/**
	 * Prints out the current score. To be called at the end of a game.
	 */
	private void printScore() {
		System.out.printf("Score: %d\n", ocean.getShotsFired());
	}

	/**
	 * The main function. Run this method to play the game.
	 */
	public static void main(String[] args) {
		BattleShipGame game = new BattleShipGame();
		game.start();

	}

}
