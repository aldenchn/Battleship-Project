/**
 * A ship with a length of two tiles.
 * 
 * @author klaus
 *
 */
public class Destroyer extends Ship {

	/**
	 * Sets the inherited length variable and initializes the hit array, based on
	 * the size of this ship (2 tiles).
	 */
	public Destroyer() {
		length = 2;
		hit = new boolean[2];
		hit[0] = false;
		hit[1] = false;
	}

	/**
	 * @return "Destroyer", indicating that this is a Destroyer.
	 */
	@Override
	public String getShipType() {
		return "Destroyer";
	}

}
