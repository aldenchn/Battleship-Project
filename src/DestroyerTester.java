import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DestroyerTester {

	@Test
	void getDestroyerTypeTest() {
		Destroyer ds = new Destroyer();
		String expected = "Destroyer";
		String actual = ds.getShipType();
		assertEquals(expected, actual);
	}

}
