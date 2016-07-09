package core;

import java.util.ArrayList;
import java.util.Random;

public class Level {
	private final Random random;
	public ArrayList<Room> rooms = new ArrayList();
	private final int STAIRCASE_X;
	private final int STAIRCASE_Y;

	public Level(Random random, int levelSize, int averageRoomDifficulty) {
		this.random = random;
		if (levelSize < 2) {
			throw new IllegalArgumentException("The LevelSize must be greater than or equal to 2, as opposed to the current value of " + levelSize);
		}
		int maxCorridorLength = random.nextInt(levelSize - 1) + 2;
		int minCorridorLength = random.nextInt(maxCorridorLength - 1) + 1;
		int corridorLength;
		int roomLocationX;
		int roomLocationY;
		Room corridorStart;
		int corridorDirection = 0;
		rooms.add(new Room(0, 0));
		ArrayList<Integer> roomDifficulties = new ArrayList<Integer>();
		roomDifficulties.add(0);
		while (roomDifficulties.size() < levelSize) {
			roomDifficulties.add((int) (averageRoomDifficulty * 0.75 + random.nextInt(averageRoomDifficulty/2)));
		}
		for (int i = 0; i < roomDifficulties.size() - 1; i++) {
			roomDifficulties.set(levelSize - 1, (int) (roomDifficulties.get(levelSize - 1)
					+ (averageRoomDifficulty * 1.5 - roomDifficulties.get(i))));
		}
		roomDifficulties.set(roomDifficulties.size() - 1, (int) (roomDifficulties.get(levelSize - 1) / levelSize * 3.5));
		for (int difficulty : roomDifficulties) {
			System.out.println(difficulty);
		}
		while (rooms.size() < levelSize) {
			corridorLength = Math.min(random.nextInt(maxCorridorLength - minCorridorLength) + minCorridorLength,
					levelSize - rooms.size());
			corridorStart = rooms.get(random.nextInt(rooms.size()));
			roomLocationX = corridorStart.getX();
			roomLocationY = corridorStart.getY();
			corridorDirection = random.nextInt(3);
			for (int i = 0; i < corridorLength; i++) {
				while (findRoomAt(roomLocationX, roomLocationY) != null) {
					if (corridorDirection == 0) {
						roomLocationY++;
					}
					if (corridorDirection == 1) {
						roomLocationX++;
					}
					if (corridorDirection == 2) {
						roomLocationY--;
					}
					if (corridorDirection == 3) {
						roomLocationX--;
					}
				}
				rooms.add(new Room(roomLocationX, roomLocationY, roomDifficulties.get(rooms.size())));
			}
		}
		STAIRCASE_X = rooms.get(levelSize - 1).getX();
		STAIRCASE_Y = rooms.get(levelSize - 1).getY();
	}

	public Room findRoomAt(int x, int y) {
		for (Room room : rooms) {
			if (room.getX() == x && room.getY() == y) {
				return room;
			}
		}
		return null;
	}

	public void drawLevel() {
		int minX = 0;
		int minY = 0;
		int maxX = 0;
		int maxY = 0;
		for (Room room : rooms) {
			minX = Math.min(minX, room.getX());
			minY = Math.min(minY, room.getY());
			maxX = Math.max(maxX, room.getX());
			maxY = Math.max(maxY, room.getY());
		}
		for (int y = maxY + 1; y >= minY - 1; y--) {
			for (int x = minX - 1; x <= maxX + 1; x++) {
				if (x == 0 && y == 0) {
					System.out.print("<");
				}
				else if (x == STAIRCASE_X && y == STAIRCASE_Y) {
					System.out.print(">");
				}
				else if (findRoomAt(x, y) != null) {
					System.out.print("+");
				}
				else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}
