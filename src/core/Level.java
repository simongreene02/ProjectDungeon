package core;

import java.util.ArrayList;
import java.util.Random;

public class Level {
	private Random random = new Random();
	private final int LEVEL_SIZE;
	public ArrayList<Room> rooms = new ArrayList();

	public Level(int levelSize, int averageRoomDifficulty) {
		LEVEL_SIZE = Math.max(2, levelSize);
		int maxCorridorLength = random.nextInt(LEVEL_SIZE - 1) + 2;
		int minCorridorLength = random.nextInt(maxCorridorLength - 1) + 1;
		int corridorLength;
		int roomLocationX;
		int roomLocationY;
		Room corridorStart;
		int corridorDirection = 0;
		rooms.add(new Room(0, 0));
		ArrayList<Integer> roomDifficulties = new ArrayList<Integer>();
		roomDifficulties.add(0);
		while (roomDifficulties.size() < LEVEL_SIZE) {
			roomDifficulties.add((int) (averageRoomDifficulty * 0.5 + random.nextInt(averageRoomDifficulty)));
		}
		for (int i = 0; i < roomDifficulties.size() - 1; i++) {
			roomDifficulties.set(roomDifficulties.size() - 1, (int) (roomDifficulties.get(LEVEL_SIZE - 1) + (averageRoomDifficulty * 1.5 - roomDifficulties.get(i))));
		}
		roomDifficulties.set(roomDifficulties.size() - 1, (int) roomDifficulties.get(LEVEL_SIZE - 1) / LEVEL_SIZE * 10);
		while (rooms.size() < LEVEL_SIZE) {
			corridorLength = Math.min(random.nextInt(maxCorridorLength - minCorridorLength) + minCorridorLength,
					LEVEL_SIZE - rooms.size());
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
				if (findRoomAt(x, y) == null) {
					System.out.print("-");
				}
				if (findRoomAt(x, y) != null) {
					System.out.print("+");
				}
			}
			System.out.println();
		}
	}
}
