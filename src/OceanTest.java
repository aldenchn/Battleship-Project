import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OceanTest {

	@Test
	void placeAllShipsRandomlyTest() {
		Ocean testOcean = new Ocean();
		testOcean.placeAllShipsRandomly();
		Ship[][] ships = testOcean.getShipArray();
		// one battleship, two cruisers, three destroyers, 4 submarines
		int[] expected = new int[] { 1 * 4, 2 * 3, 3 * 2, 4 * 1 };
		int[] actual = new int[] { 0, 0, 0, 0 };
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (ships[i][j].getShipType() == "Battleship") {
					actual[0] += 1;
				} else if (ships[i][j].getShipType() == "Cruiser") {
					actual[1] += 1;
				} else if (ships[i][j].getShipType() == "Destroyer") {
					actual[2] += 1;
				} else if (ships[i][j].getShipType() == "Submarine") {
					actual[3] += 1;
				}
			}
		}
		assertArrayEquals(expected, actual);
	}

	@Test
	void shootAtTest() {
		Ocean testOcean = new Ocean();
		testOcean.placeAllShipsRandomly();
		Ship[][] ships = testOcean.getShipArray();
		// default is to fill all with 0
		int[][] actual = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				boolean bool = testOcean.shootAt(i, j);
				if (ships[i][j].getShipType().equals("empty")) {
					if (bool != false) {
						actual[i][j] = 1;
					}
				} else {
					if (bool == false) {
						actual[i][j] = 1;
					}
				}
			}
		}
		// the second loop to test sunk ships
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				boolean bool = testOcean.shootAt(i, j);
				if (!ships[i][j].getShipType().equals("empty")) {
					if (bool != false) {
						actual[i][j] = 1;
					}
				}
			}
		}
		int[][] expected = new int[10][10];
		assertArrayEquals(expected, actual);
	}

	@Test
	void getShotsFiredTest() {
		Ocean testOcean = new Ocean();
		testOcean.placeAllShipsRandomly();
		testOcean.shootAt(0, 0);
		testOcean.shootAt(1, 1);
		testOcean.shootAt(2, 2);
		int expected = 3;
		int actual = testOcean.getShotsFired();
		assertEquals(expected, actual);

	}

	@Test
	void getHitCountTest() {
		Ocean testOcean = new Ocean();
		testOcean.placeAllShipsRandomly();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				testOcean.shootAt(i, j);
			}
		}
		int expected = 20;
		int actual = testOcean.getHitCount();
		assertEquals(expected, actual);
	}

	@Test
	void getshipsSunkTest() {
		Ocean testOcean = new Ocean();
		testOcean.placeAllShipsRandomly();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				testOcean.shootAt(i, j);
			}
		}
		int expected = 10;
		int actual = testOcean.getShipsSunk();
		assertEquals(expected, actual);
	}

	@Test
	void isGameOverTest() {
		Ocean testOcean = new Ocean();
		testOcean.placeAllShipsRandomly();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				testOcean.shootAt(i, j);
			}
		}
		boolean expected = true;
		boolean actual = testOcean.isGameOver();
		assertEquals(expected, actual);
	}

	@Test
	void isGameOverTest2() {
		Ocean testOcean = new Ocean();
		testOcean.placeAllShipsRandomly();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				testOcean.shootAt(i, j);
			}
		}
		boolean expected = false;
		boolean actual = testOcean.isGameOver();
		assertEquals(expected, actual);
	}

}
