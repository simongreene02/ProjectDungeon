package core;

import java.util.ArrayList;
import java.util.Random;

import core.model.Location;
import util.Predecate;

public class FloorGrid {
	private final Random random;
	private final Tile[][] tiles;
	private final Location staircasePosition;
	
	public FloorGrid(int width, int height, Random random, int roomNums, Location staircasePosition) {
		if (roomNums < 2) {
			throw new IllegalArgumentException("");
		}
		Predecate.checkGreaterThanZero(height);
		Predecate.checkGreaterThanZero(width);
		if (height * width < roomNums) {
			throw new IllegalArgumentException();
		}
		tiles = new Tile[height][width];
		this.random = random;
		this.staircasePosition = staircasePosition;
		
	}	
}
