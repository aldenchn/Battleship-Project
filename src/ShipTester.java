import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShipTester {

	@Test
	void getLengTest() {
		Battleship bs = new Battleship();
		int actual = bs.getLength();
		int expected = 4;
		assertEquals(expected, actual);
	}

	@Test
	void setAndGetBowRowTest() {
		Battleship bs = new Battleship();
		bs.setBowRow(1);
		int expcted = 1;
		int actual = bs.getBowRow();
		assertEquals(expcted, actual);
	}

	@Test
	void setAndGetBowColumnTest() {
		Battleship bs = new Battleship();
		bs.setBowColumn(2);
		int expected = 2;
		int actual = bs.getBowColumn();
		assertEquals(expected, actual);
	}

	@Test
	void setAndIsHoriontalTest() {
		Battleship bs = new Battleship();
		bs.setHorizontal(false);
		boolean expected = false;
		boolean actual = bs.isHorizontal();
		assertEquals(expected, actual);
	}

	@Test
	void setAndIsHoriontalTest2() {
		Battleship bs = new Battleship();
		bs.setHorizontal(true);
		boolean expected = true;
		boolean actual = bs.isHorizontal();
		assertEquals(expected, actual);
	}

	@Test
	void getShipTypeTest() {
		EmptySea es = new EmptySea();
		String expected = "empty";
		String actual = es.getShipType();
		assertEquals(expected, actual);
	}

	@Test
	void detectSurroundingTestLeft() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = true;
		// loop until we found a Ship in the Ocean, pass the position left to the ship
		// into detectSurrounding
		// this should change judgeActual from true to false
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++)
				if (!shipArray[i][j].getShipType().equals("empty")) {
					if (j - 1 >= 0) {
						judgeActual = Ship.detectSurrounding(i, j - 1, ocn);
						found = true; // change found to true, so we can break form the first for loop
						break;
					}
				}
		}
		boolean judgeExpected = false;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test
	void detectSurroundingTestRight() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = true;
		// loop until we found a Ship in the Ocean, pass the position right to the ship
		// into detectSurrounding
		// this should change judgeActual from true to false
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++)
				if (!shipArray[i][j].getShipType().equals("empty")) {
					if (j + 1 <= 9) {
						judgeActual = Ship.detectSurrounding(i, j + 1, ocn);
						found = true; // change found to true, so we can break form the first for loop
						break;
					}
				}
		}
		boolean judgeExpected = false;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test
	void detectSurroundingTestTop() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = true;
		// loop until we found a Ship in the Ocean, pass the position at the top of the
		// found ship
		// into detectSurrounding
		// this should change judgeActual from true to false
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++)
				if (!shipArray[i][j].getShipType().equals("empty")) {
					if (i - 1 >= 0) {
						judgeActual = Ship.detectSurrounding(i - 1, j, ocn);
						found = true; // change found to true, so we can break form the first for loop
						break;
					}
				}
		}
		boolean judgeExpected = false;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test
	void detectSurroundingTestBottom() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = true;
		// loop until we found a Ship in the Ocean, pass the position at the bottom to
		// the ship
		// into detectSurrounding
		// this should change judgeActual from true to false
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++)
				if (!shipArray[i][j].getShipType().equals("empty")) {
					if (i + 1 <= 9) {
						judgeActual = Ship.detectSurrounding(i + 1, j, ocn);
						found = true; // change found to true, so we can break form the first for loop
						break;
					}
				}
		}
		boolean judgeExpected = false;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test
	void detectSurroundingTestTopLeft() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = true;
		// loop until we found a Ship in the Ocean, pass the position at the top left to
		// the ship
		// into detectSurrounding
		// this should change judgeActual from true to false
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++)
				if (!shipArray[i][j].getShipType().equals("empty")) {
					if (i - 1 >= 0 && j - 1 >= 0) {
						judgeActual = Ship.detectSurrounding(i - 1, j - 1, ocn);
						found = true; // change found to true, so we can break form the first for loop
						break;
					}
				}
		}
		boolean judgeExpected = false;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test
	void detectSurroundingTestTopRight() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = true;
		// loop until we found a Ship in the Ocean, pass the position at the top right
		// to
		// the ship
		// into detectSurrounding
		// this should change judgeActual from true to false
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++)
				if (!shipArray[i][j].getShipType().equals("empty")) {
					if (i - 1 >= 0 && j + 1 <= 9) {
						judgeActual = Ship.detectSurrounding(i - 1, j + 1, ocn);
						found = true; // change found to true, so we can break form the first for loop
						break;
					}
				}
		}
		boolean judgeExpected = false;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test
	void detectSurroundingBottomLeft() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = true;
		// loop until we found a Ship in the Ocean, pass the position at the bottom left
		// to the ship into detectSurrounding
		// this should change judgeActual from true to false
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++)
				if (!shipArray[i][j].getShipType().equals("empty")) {
					if (i + 1 <= 9 && j - 1 >= 0) {
						judgeActual = Ship.detectSurrounding(i + 1, j - 1, ocn);
						found = true; // change found to true, so we can break form the first for loop
						break;
					}
				}
		}
		boolean judgeExpected = false;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test
	void detectSurroundingBottomRight() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = true;
		// loop until we found a Ship in the Ocean, pass the position at the bottom left
		// to the ship into detectSurrounding
		// this should change judgeActual from true to false
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++)
				if (!shipArray[i][j].getShipType().equals("empty")) {
					if (i + 1 <= 9 && j + 1 <= 9) {
						judgeActual = Ship.detectSurrounding(i + 1, j + 1, ocn);
						found = true; // change found to true, so we can break form the first for loop
						break;
					}
				}
		}
		boolean judgeExpected = false;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test // scenario that is not OK to place a ship that is horizontally placed
	void okToPlaceShipAtHorizontal() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = true;
		Ship bShip = new Battleship();
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++) {
				if (!shipArray[i][j].getShipType().equals("empty")) {
					if (j - 3 >= 0) {
						// the end of the ship will overlap with a non-empty space,
						// thus the judgeActual is expected to change from true to false
						found = true;
						judgeActual = bShip.okToPlaceShipAt(i, j - 3, true, ocn);
						break;
					}
				}
			}
		}
		boolean judgeExpected = false;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test // scenario that is not OK to place a ship that is not horizontally placed
	void okToPlaceShipAtVertical() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = true;
		Ship bShip = new Battleship();
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++) {
				if (!shipArray[i][j].getShipType().equals("empty")) {
					if (i - 3 >= 0) {
						found = true;
						judgeActual = bShip.okToPlaceShipAt(i - 3, j, false, ocn);
						break;
					}
				}
			}
		}
		boolean judgeExpected = false;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test // test for a scenario that okToPlaceShip would return true
	void okToPlaceShipOk() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = false;
		Ship sShip = new Submarine();
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++) {
				// if a empty sea and its surrounding are both empty
				// we can certainly place a submarine at (i,j)
				if (shipArray[i][j].getShipType().equals("empty")) {
					if (Ship.detectSurrounding(i, j, ocn)) {
						found = true;
						judgeActual = sShip.okToPlaceShipAt(i, j, false, ocn);
						break;
					}
				}
			}
		}
		boolean judgeExpected = true;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test // test for a scenario that okToPlaceShip would return false, because it is next
			// to another ship
	void okToPlaceShipNext() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = true;
		Ship sShip = new Submarine();
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length - 1; j++) {
				if (shipArray[i][j].getShipType().equals("empty")
						&& (!shipArray[i][j + 1].getShipType().equals("empty"))) {
					found = true;
					judgeActual = sShip.okToPlaceShipAt(i, j, false, ocn);
					break;
				}
			}
		}

		boolean judgeExpected = false;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test
	void isSunkTest1() { // scenario that a ship is not sunk
		Ship Bs = new Battleship();
		// a new created ship is by default not sunk
		boolean actual = Bs.isSunk();
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	void isSunkTest2() { // scenario that a submarine is sunk
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = false;
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++) {
				if ((shipArray[i][j].getShipType().equals("Submarine")) && (shipArray[i][j].toString().equals("S"))) {
					shipArray[i][j].shootAt(i, j); // now the submarine is sunk
					found = true;
					judgeActual = shipArray[i][j].isSunk(); // isSunk is expected to return true
					break;
				}
			}
		}
		boolean judgeExpected = true;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test
	void shootAtSunk() { // shoot at a sunk submarine should return false
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = true;
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++) {
				// try to find a submarine that is not sunk
				if ((shipArray[i][j].getShipType().equals("Submarine")) && (shipArray[i][j].toString().equals("S"))) {
					shipArray[i][j].shootAt(i, j); // now the submarine is sunk
					found = true;
					judgeActual = shipArray[i][j].shootAt(i, j); // shhotAt is expected to return false
					break;
				}
			}
		}
		boolean judgeExpected = false;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test
	void shootAtNonSunk() { // shoot at a non-sunk and not hit position of a destroyer should return true
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		boolean judgeActual = false;
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++) {
				// try to find a destroyer that is not sunk
				if ((shipArray[i][j].getShipType().equals("Destroyer")) && (!shipArray[i][j].isSunk())) {
					found = true;
					judgeActual = shipArray[i][j].shootAt(i, j); // shhotAt is expected to return true
					break;
				}
			}
		}
		boolean judgeExpected = true;
		assertEquals(judgeExpected, judgeActual);
	}

	@Test // a ship has been hit but not sunk should return S
	void toStringS() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		String actual = null;
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++) {
				// try to find a Battleship that is not sunk
				if ((shipArray[i][j].getShipType().equals("Battleship")) && (!shipArray[i][j].isSunk())) {
					found = true;
					shipArray[i][j].shootAt(i, j);// shot at one position, should turn it into S
					actual = shipArray[i][j].toString();
					break;
				}
			}
		}
		String expected = "S";
		assertEquals(expected, actual);

	}

	@Test
	void toStringx() {
		Ocean ocn = new Ocean();
		ocn.placeAllShipsRandomly();
		Ship[][] shipArray = ocn.getShipArray();
		boolean found = false;
		String actual = null;
		for (int i = 0; i < shipArray.length; i++) {
			if (found == true) {
				break;
			}
			for (int j = 0; j < shipArray[0].length; j++) {
				// try to find a submarine that is not sunk
				if ((shipArray[i][j].getShipType().equals("Submarine")) && (!shipArray[i][j].isSunk())) {
					found = true;
					shipArray[i][j].shootAt(i, j);// shot at one position, should turn it into x
					actual = shipArray[i][j].toString();
					break;
				}
			}
		}
		String expected = "x";
		assertEquals(expected, actual);

	}
}
