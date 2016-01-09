package core;

import java.util.ArrayList;
import java.util.Random;

public class Entity {
	private int maxHealth;
	public int currentHealth;
	protected ArrayList<Skill> skillList = new ArrayList<Skill>();
	public Entity() {
		maxHealth = 10;
		currentHealth = maxHealth;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public ArrayList<Skill> getSkillList() {
		return skillList;
	}
	public Skill onTurn(Entity enemy) {
		return skillList.get(new Random().nextInt(skillList.size()));
	}
	
}
