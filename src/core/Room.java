package core;

import java.util.ArrayList;

public class Room implements Tile {
	private int x = 0;
	private int y = 0;
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private ArrayList<Entity> enemyList = new ArrayList<Entity>();
	
	public Room() {
	}
	
	public Room(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Room(ArrayList<Item> itemList, ArrayList<Entity> enemyList) {
		this.itemList = itemList;
		this.enemyList = enemyList;
	}
	
	public Room(int x, int y, ArrayList<Item> itemList, ArrayList<Entity> enemyList) {
		this.x = x;
		this.y = y;
		this.itemList = itemList;
		this.enemyList = enemyList;
	}
	
	public Room(int x, int y, int difficulty) {
		this.x = x;
		this.y = y;
		
	}
	
	public boolean onEnter(Player player) {
		boolean isPlayerAlive = true;
		for (Entity enemy : enemyList) {
			if (isPlayerAlive) {
				if (!(player == Battle.doBattle(true, player, enemy))) {
					isPlayerAlive = false;
				}
			}
		}
		if (isPlayerAlive) {
			for (Item item : itemList) {
				player.addToInventory(item);
			}
		}
		return isPlayerAlive;
	}



	ArrayList<Item> getItemList() {
		return itemList;
	}

	ArrayList<Entity> getEnemyList() {
		return enemyList;
	}

	@Override
	public boolean canBeEntered() {
		return true;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	
}
