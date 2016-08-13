package core;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player extends Entity {
	public Player(Random random, int maxHealth) {
		super(random, maxHealth);
	}

	private ArrayList<Item> inventory = new ArrayList<Item>();
	Scanner scanner = new Scanner(System.in);

	public void addToInventory(Item e) {
		inventory.add(e);
	}
	
	public Posession onTurn(Entity enemy) {
		if (inventory.size() == 1 && getSkillList().size() == 0) {
			return inventory.get(0);
		}
		if (inventory.size() == 0 && getSkillList().size() == 1) {
			return getSkillList().get(0);
		}
		System.out.println("Enemy: ");
		System.out.println("HP: " + enemy.getCurrentHealth() + "/" + enemy.getMaxHealth());
		System.out.println("Skills: ");
		for (int i = 1; i <= enemy.getSkillList().size(); i++) {
			System.out.println("\t" + i + ". " + enemy.getSkillList().get(i-1));
		}
		System.out.println("Player:");
		System.out.println("HP: " + getCurrentHealth() + "/" + getMaxHealth());
		System.out.println("Skills: ");
		for (int i = 1; i <= getSkillList().size(); i++) {
			System.out.println("\t" + i + ". " + getSkillList().get(i-1));
		}
		System.out.println("Items: ");
		for (int i = 1; i <= inventory.size(); i++) {
			System.out.println("\t" + (i+getSkillList().size()) + ". " + inventory.get(i-1));
		}
		System.out.println("\n\n");
		int input = 0;
		while (input < 1 || input > (inventory.size() + getSkillList().size())) {
			input = scanner.nextInt();
		}
		if (input <= getSkillList().size()) {
			return getSkillList().get(input-1);
		} else {
			return inventory.remove(input - (getSkillList().size()+1));
		}
		
	}
	
}
