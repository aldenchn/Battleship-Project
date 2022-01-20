
/**
 * A ship with a length of three tiles.
 * 
 * @author klaus
 *
 */
public class Cruiser extends Ship {

	/**
	 * Sets the inherited length variable and initializes the hit array, based on
	 * the size of this ship (3 tiles).
	 */
	public Cruiser() {
		length = 3;
		hit = new boolean[3];
		hit[0] = false;
		hit[1] = false;
		hit[2] = false;
	}

	/**
	 * @return "Cruiser", indicating that this is a Cruiser.
	 */
	@Override
	public String getShipType() {
		return "Cruiser";
	}

}
