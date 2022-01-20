
public abstract class Ship {

	/**
	 * The column (0 to 9) which contains the bow (front) of the ship.
	 */
	protected int bowColumn;

	/**
	 * The row (0 to 9) which contains the bow (front) of the ship.
	 */
	protected int bowRow;

	/**
	 * hit is an array of four booleans telling whether that part of the ship has
	 * been hit. Only battleships will use all four locations; cruisers use only the
	 * first three, destroyers the first two, submarines and empty sea one.
	 */
	protected boolean[] hit;

	/**
	 * true if the ship occupies a single row, false otherwise.
	 */
	protected boolean horizontal;

	/**
	 * The number of tiles occupied by the ship. Empty sea locations have a length
	 * of 1.
	 */
	protected int length;

	/**
	 * Helper function to get the length of a ship.
	 * 
	 * @return the length of the ship.
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Helper function to get the row of the bow.
	 * 
	 * @return the row of the bow (front) of the ship.
	 */
	public int getBowRow() {
		return bowRow;
	}

	/**
	 * Helper function to get the column of the bow.
	 * 
	 * @return the column of the bow (front) of the ship.
	 */
	public int getBowColumn() {
		return bowColumn;
	}

	/**
	 * @param bowColumn the bowColumn to set
	 */
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}

	/**
	 * Helper function to judge if a ship is horizontal.
	 * 
	 * @return {@literal true} if this boat is horizontal (facing left), false
	 *         otherwise.
	 */
	public boolean isHorizontal() {
		return horizontal;
	}

	/**
	 * set field horizontal to passed in boolean value.
	 * 
	 * @param horizontal the horizontal to set
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * set field bowRow to passed in integer.
	 * 
	 * @param bowRow the bowRow to set
	 */
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}

	/**
	 * Abstract method to return ship type.
	 * 
	 * @return the String representing the type of this ship.
	 */
	public abstract String getShipType();

	/**
	 * Determines whether or not this is represents a valid placement configuration
	 * for this Ship in this Ocean. Ship objects in an Ocean must not overlap other
	 * Ship objects or touch them vertically, horizontally, or diagonally.
	 * Additionally, the placement cannot be such that the Ship would extend beyond
	 * the extents of the 2D array in which it is placed. Calling this method should
	 * not actually change either the Ship or the provided Ocean.
	 * 
	 * @param row        the candidate row to place the ship
	 * @param column     the candidate column to place the ship
	 * @param horizontal whether or not to have the ship facing to the left
	 * @param ocean      the Ocean in which this ship might be placed
	 * @return {@literal true} if it is valid to place this ship of this length in
	 *         this location with this orientation, and false otherwise.
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		// the starting position is occupied
		if (ocean.isOccupied(row, column)) {
			return false;
		}
		// check for whether length within the grid
		if (horizontal) {
			if ((column + length - 1) > 9) { // exceed the grid boundary
				return false;
			}
			// check surroundings for the whole ship
			for (int i = 0; i < length; i++) {
				if (ocean.isOccupied(row, column + i)) {
					return false;
				}
				if (!detectSurrounding(row, column + i, ocean)) {
					return false;
				}
			}

		} else {
			if ((row + length - 1) > 9) {
				return false;
			}
			// change surroundings for the whole ship
			for (int j = 0; j < length; j++) {
				if (ocean.isOccupied(row + j, column)) {
					return false;
				}
				if (!detectSurrounding(row + j, column, ocean)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Helper function to detect a tile's surrounding, return true if there is no
	 * ship placed around it.
	 * 
	 * @param row   the candidate row of a position to check
	 * @param col   the candidate column of a position to check
	 * @param ocean an ocean instance to check
	 * @return {@literal true} if this position's surroundings are all empty seas,
	 *         and false otherwise.
	 */
	public static boolean detectSurrounding(int row, int col, Ocean ocean) {
		if (0 <= (col - 1) && (col - 1) <= 9) { // check left side
			if (ocean.isOccupied(row, col - 1)) {
				return false;
			}
		}
		if (0 <= (col - 1) && (col - 1) <= 9 && (row - 1) >= 0 && (row - 1) <= 9) { // left top check
			if (ocean.isOccupied(row - 1, col - 1)) {
				return false;
			}
		}
		if ((row - 1) >= 0 && (row - 1) <= 9) { // check top
			if (ocean.isOccupied(row - 1, col)) {
				return false;
			}
		}
		if (0 <= (col + 1) && (col + 1) <= 9 && (row - 1) >= 0 && (row - 1) <= 9) { // check right top
			if (ocean.isOccupied(row - 1, col + 1)) {
				return false;
			}
		}
		if (0 <= (col + 1) && (col + 1) <= 9) { // check right side
			if (ocean.isOccupied(row, col + 1)) {
				return false;
			}
		}
		if (0 <= (col + 1) && (col + 1) <= 9 && (row + 1) >= 0 && (row + 1) <= 9) { // check right bottom
			if (ocean.isOccupied(row + 1, col + 1)) {
				return false;
			}
		}
		if ((row + 1) >= 0 && (row + 1) <= 9) { // check bottom
			if (ocean.isOccupied(row + 1, col)) {
				return false;
			}
		}
		if (0 <= (col - 1) && (col - 1) <= 9 && (row + 1) >= 0 && (row + 1) <= 9) { // left bottom check
			if (ocean.isOccupied(row + 1, col - 1)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Puts the Ship in the Ocean. This will give values to the bowRow, bowColumn,
	 * and horizontal instance variables in the Ship. This should also place a
	 * reference to this Ship in each of the one or more locations (up to four) in
	 * the corresponding Ocean array this Ship is being placed in. Each of the
	 * references placed in the Ocean will be identical since it is not possible to
	 * refer to a "part" of a ship, only the whole ship.
	 * 
	 * @param row        the row to place the ship
	 * @param column     the column to place the ship
	 * @param horizontal whether or not to have the ship facing to the left
	 * @param ocean      the Ocean in which this ship will be placed
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		setBowColumn(column);
		setBowRow(row);
		setHorizontal(horizontal);
		Ship[][] shipArray = ocean.getShipArray();
		if (horizontal) {
			for (int i = 0; i < length; i++) {
				shipArray[row][column + i] = Ship.this;
			}
		} else {
			for (int i = 0; i < length; i++) {
				shipArray[row + i][column] = Ship.this;
			}
		}
	}

	/**
	 * If a part of this ship occupies this coordinate, and if the ship hasn't been
	 * sunk, mark the part of the ship at that coordinate as "hit".
	 * 
	 * @param row    the row of the shot
	 * @param column the column of the shot
	 * @return {@literal true} if this ship hasn't been sunk and a part of this ship
	 *         occupies the given row and column and false otherwise.
	 */
	public boolean shootAt(int row, int column) {
		if (isSunk()) { // if the ship is sunk, return false
			return false;
		}
		// judge if the coordinate passed in is part of the ship
		if (horizontal) {
			if ((row == bowRow) && (column >= bowColumn) && (column <= (bowColumn + length - 1))) {
				hit[column - bowColumn] = true;
				return true;
			}
		} else {
			if ((column == bowColumn) && (row >= bowRow) && (row <= (bowRow + length - 1))) {
				hit[row - bowRow] = true;
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if this ship has been sunk and false otherwise.
	 * 
	 * @return {@literal true} if every part of the ship has been hit, and false
	 *         otherwise.
	 */
	public boolean isSunk() {
		for (int x = 0; x < length; x++) {
			if (hit[x] == false) { // as long as there is one part of it hasn't been hit, return false
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns a single character String to use in the Ocean's print method. This
	 * method should return "x" if the ship has been sunk, and "S" if it has not yet
	 * been sunk. This method can only be used to print out locations in the ocean
	 * that have been shot at; it should not be used to print locations that have
	 * not been the target of a shot yet.
	 * 
	 * @return "x" if this ship has been sunk, and "S" otherwise.
	 */
	public String toString() {
		if (isSunk()) {
			return "x";
		} else {
			return "S";
		}
	}

}
