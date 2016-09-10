package core;

import java.util.ArrayList;
import java.util.Random;

import core.model.Location;
import util.Preconditions;

public class FloorGrid {
	
	public enum Direction {
		North, South, East, West
	}
	private final Random random;
	private final Tile[][] tiles;
	private final Location staircasePosition;
	
	public FloorGrid(int width, int height, Random random, int roomNums, Location staircasePosition) {
		if (roomNums < 2) {
			throw new IllegalArgumentException("");
		}
		Preconditions.checkGreaterThanZero(height);
		Preconditions.checkGreaterThanZero(width);
		if (height * width < roomNums) {
			throw new IllegalArgumentException();
		}
		tiles = new Tile[height][width];
		this.random = random;
		this.staircasePosition = checkLocation(staircasePosition);
		
	}
	
	public boolean canMoveInDirection(Direction direction, Location location) {
		checkLocation(location);
		switch (direction) {
		case North: 
			return getTileAt(checkLocation(Location.of(location.x, location.y-1))).canBeEntered();
		case South:
			return getTileAt(checkLocation(Location.of(location.x, location.y+1))).canBeEntered();
		case East:
			return getTileAt(checkLocation(Location.of(location.x+1, location.y))).canBeEntered();
		case West: 
			return getTileAt(checkLocation(Location.of(location.x-1, location.y))).canBeEntered();
		}
		throw new UnsupportedOperationException();
	}
	
	Location checkLocation(Location location) {
		if (isValidLocation(location)) {
			throw new IllegalArgumentException(String.format("Your location %s was not in the bounds of the Tile array.", location));
		}
		return location;
	}
	private boolean isValidLocation(Location location) {
		return location.x < 0 || location.x > tiles.length || location.y < 0 || location.y > tiles[0].length;
	}
	
	private Tile getTileAt(Location location) {
		return tiles[location.x][location.y];
	}
}
