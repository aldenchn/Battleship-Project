/**
 * A ship with a length of one tile.
 * 
 * @author klaus
 *
 */
public class Submarine extends Ship {
	/**
	 * Sets the inherited length variable and initializes the hit array, based on
	 * the size of this ship (1 tiles).
	 */
	public Submarine() {
		length = 1;
		hit = new boolean[1];
		hit[0] = false;
	}

	/**
	 * @return "Submarine", indicating that this is a Submarine.
	 */
	@Override
	public String getShipType() {
		return "Submarine";
	}

}
