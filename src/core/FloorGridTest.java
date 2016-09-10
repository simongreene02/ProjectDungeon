package core;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import core.model.Location;

public class FloorGridTest {
	private FloorGrid floorGrid;

	@Before
	public void setUp() {
		floorGrid = new FloorGrid(5, 5, new Random(0), 12, Location.of(4, 4));
	}

	@Test
	public void checkLocation_positiveCase() {
		floorGrid.checkLocation(Location.of(3, 3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkLocation_xTooHighYTooHigh() {
		floorGrid.checkLocation(Location.of(6, 7));
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkLocation_negativeXNegativeY() {
		floorGrid.checkLocation(Location.of(-1, -1));
	}

}
