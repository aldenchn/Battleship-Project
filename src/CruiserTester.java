import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CruiserTester {

	@Test
	void getCruiserTypeTest() {
		Cruiser cr = new Cruiser();
		String expected = "Cruiser";
		String actual = cr.getShipType();
		assertEquals(expected, actual);
	}

}
