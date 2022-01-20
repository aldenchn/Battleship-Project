import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BattleShipTester {

	@Test
	void getBattleshipTypeTest() {
		Battleship bs = new Battleship();
		String expected = "Battleship";
		String actual = bs.getShipType();
		assertEquals(expected, actual);
	}
}
