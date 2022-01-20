import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmptySeaTester {

	@Test
	void shootAtTest() {
		EmptySea es = new EmptySea();
		boolean actual = es.shootAt(1, 0);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	void isSunkTest() {
		EmptySea es = new EmptySea();
		boolean actual = es.isSunk();
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	void toStringTest() {
		EmptySea es = new EmptySea();
		String actual = es.toString();
		String expected = "S";
		assertEquals(expected, actual);
	}

	@Test
	void getEmptySeaTypeTest() {
		EmptySea es = new EmptySea();
		String expected = "empty";
		String actual = es.getShipType();
		assertEquals(expected, actual);
	}

}
