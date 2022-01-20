/**
 * A Ship with a length of four tiles.
 * 
 * @author klaus
 *
 */
public class Battleship extends Ship {

	/**
	 * Sets the inherited length variable and initializes the hit array, based on
	 * the size of this ship (4 tiles).
	 */
	public Battleship() {
		length = 4;
		hit = new boolean[4];
		hit[0] = false;
		hit[1] = false;
		hit[2] = false;
		hit[3] = false;
	}

	/**
	 * 
	 * @return "Battleship", indicating that this is a Battleship.
	 */
	@Override
	public String getShipType() {
		return "Battleship";
	}

}
