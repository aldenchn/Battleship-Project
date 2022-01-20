import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SubmarineTester {

	@Test
	void getSubmarineTypeTest() {
		Submarine su = new Submarine();
		String expected = "Submarine";
		String actual = su.getShipType();
		assertEquals(expected, actual);
	}
}
