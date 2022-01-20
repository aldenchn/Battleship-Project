import java.util.ArrayList;
import java.util.Random;

/**
 * This class manages the game state by keeping track of what entity is
 * contained in each position on the game board.
 * 
 * @author Jackie
 *
 */
public class Ocean implements OceanInterface {

	/**
	 * A 10x10 2D array to record user's shots. {@literal true} if the given
	 * location has been hit, and {@literal false} otherwise.
	 */
	private Boolean[][] ifHit;

	/**
	 * A 10x10 2D array of Ships, which can be used to quickly determine which ship
	 * is in any given location.
	 */
	protected Ship[][] ships;

	/**
	 * The total number of shots fired by the user
	 */
	protected int shotsFired;

	/**
	 * The number of times a shot hit a ship. If the user shoots the same part of a
	 * ship more than once, every hit is counted, even though the additional "hits"
	 * don't do the user any good.
	 */
	protected int hitCount;

	/**
	 * The number of ships totally sunk.
	 * 
	 */
	protected int shipsSunk;

	/**
	 * Creates an "empty" ocean, filling every space in the <code>ships</code> array
	 * with EmptySea objects. Should also initialize the other instance variables
	 * appropriately.
	 */
	public Ocean() {
		this.ifHit = new Boolean[10][10];
		this.shipsSunk = 0;
		this.shotsFired = 0;
		this.hitCount = 0;
		this.ships = new Ship[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				ships[i][j] = new EmptySea();
				ifHit[i][j] = false;
			}
		}
	}

	/**
	 * Place all ten ships randomly on the (initially empty) ocean. Larger ships
	 * must be placed before smaller ones to avoid cases where it may be impossible
	 * to place the larger ships.
	 * 
	 * @see java.util.Random
	 */
	public void placeAllShipsRandomly() {
		// place 1 Battleship
		Battleship bs = new Battleship();
		randomPlaceHelper(bs);
		// place 2 Cruisers
		for (int i = 0; i < 2; i++) {
			Cruiser cr = new Cruiser();
			randomPlaceHelper(cr);
		}
		// place 3 Destroyers
		for (int i = 0; i < 3; i++) {
			Destroyer des = new Destroyer();
			randomPlaceHelper(des);
		}
		// place 4 Submarines
		for (int i = 0; i < 4; i++) {
			Submarine sub = new Submarine();
			randomPlaceHelper(sub);
		}
	}

	// this helper method takes in a ship object and return a list of locations
	// that's valid to put the ship at
	private ArrayList<int[]> shipLocationHelper(Ship ship) {
		ArrayList<int[]> possibleLocation = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				boolean horizontal = ship.okToPlaceShipAt(i, j, true, Ocean.this);
				boolean vertical = ship.okToPlaceShipAt(i, j, false, Ocean.this);
				if (horizontal) {
					possibleLocation.add(new int[] { i, j, 1 });
				}
				if (vertical) {
					possibleLocation.add(new int[] { i, j, 0 });
				}
			}
		}
		return possibleLocation;
	}

	// this helper method places a ship object at a random valid location
	private void randomPlaceHelper(Ship ship) {
		ArrayList<int[]> arr = shipLocationHelper(ship);
		Random rand = new Random();
		int[] randomLocation = arr.get(rand.nextInt(arr.size()));
		boolean boo = (randomLocation[2] == 1);
		ship.placeShipAt(randomLocation[0], randomLocation[1], boo, Ocean.this);
	}

	/**
	 * Checks if this coordinate is not empty; that is, if this coordinate does not
	 * contain an EmptySea reference.
	 * 
	 * @param row    the row (0 to 9) in which to check for a floating ship
	 * @param column the column (0 to 9) in which to check for a floating ship
	 * @return {@literal true} if the given location contains a ship, and
	 *         {@literal false} otherwise.
	 */
	public boolean isOccupied(int row, int column) {
		return (!ships[row][column].getShipType().equals("empty"));
	}

	/**
	 * Fires a shot at this coordinate. This will update the number of shots that
	 * have been fired (and potentially the number of hits, as well). If a location
	 * contains a real, not sunk ship, this method should return {@literal true}
	 * every time the user shoots at that location. If the ship has been sunk,
	 * additional shots at this location should return {@literal false}.
	 * 
	 * @param row    the row (0 to 9) in which to shoot
	 * @param column the column (0 to 9) in which to shoot
	 * @return {@literal true} if the given location contains an afloat ship (not an
	 *         EmptySea), {@literal false} if it does not.
	 */
	public boolean shootAt(int row, int column) {
		this.shotsFired += 1;
		Ship ship = ships[row][column];
		// add ifHit to keep record
		ifHit[row][column] = true;
		if (!ship.getShipType().equals("empty")) {
			if (ship.isSunk()) {
				return false;
			} else {
				ship.shootAt(row, column);
				if (ships[row][column].isSunk()) {
					this.shipsSunk += 1;
				}
				this.hitCount += 1;
				return true;
			}
		} else {
			ship.shootAt(row, column);
			return false;
		}
	}

	/**
	 * @return the number of shots fired in this game.
	 */
	public int getShotsFired() {
		return this.shotsFired;
	}

	/**
	 * @return the number of hits recorded in this game.
	 */
	public int getHitCount() {
		return this.hitCount;
	}

	/**
	 * @return the number of ships sunk in this game.
	 */
	public int getShipsSunk() {
		return this.shipsSunk;
	}

	/**
	 * @return {@literal true} if all ships have been sunk, otherwise
	 *         {@literal false}.
	 */
	public boolean isGameOver() {
		return (shipsSunk == 10);
	}

	/**
	 * Provides access to the grid of ships in this Ocean. The methods in the Ship
	 * class that take an Ocean parameter must be able to read and even modify the
	 * contents of this array. While it is generally undesirable to allow methods in
	 * one class to directly access instance variables in another class, in this
	 * case there is no clear and elegant alternatives.
	 * 
	 * @return the 10x10 array of ships.
	 */
	public Ship[][] getShipArray() {
		return this.ships;
	}

	/**
	 * Prints the ocean. To aid the user, row numbers should be displayed along the
	 * left edge of the array, and column numbers should be displayed along the top.
	 * Numbers should be 0 to 9, not 1 to 10. The top left corner square should be
	 * 0, 0.
	 * <ul>
	 * <li>Use 'S' to indicate a location that you have fired upon and hit a (real)
	 * ship</li>
	 * <li>'-' to indicate a location that you have fired upon and found nothing
	 * there</li>
	 * <li>'x' to indicate a location containing a sunken ship</li>
	 * <li>'.' (a period) to indicate a location that you have never fired
	 * upon.</li>
	 * </ul>
	 * 
	 * This is the only method in Ocean that has any printing capability, and it
	 * should never be called from within the Ocean class except for the purposes of
	 * debugging.
	 * 
	 */
	public void print() {
		System.out.print(" ");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%-2s%d", "", i);
		}
		System.out.println("");
		for (int i = 0; i < 10; i++) {
			Ship[] oneRow = this.ships[i];
			System.out.printf("%d%-2s", i, "");
			for (int j = 0; j < 10; j++) {
				Ship ship = oneRow[j];
				// not hit
				if (ifHit[i][j] == false) {
					System.out.printf("%-3s", '.');
				} else {
					if (ship.getShipType() == "empty") { // EmptySea
						System.out.printf("%-3s", '-');
					} else { // Other ships
						String rep = ship.toString();
						System.out.printf("%-3s", rep);
					}
				}
			}
			System.out.println("");
		}

	}
}
