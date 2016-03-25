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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Entity))
			return false;
		Entity other = (Entity) obj;
		if (currentHealth != other.currentHealth)
			return false;
		if (maxHealth != other.maxHealth)
			return false;
		if (skillList == null) {
			if (other.skillList != null)
				return false;
		} else if (!skillList.equals(other.skillList))
			return false;
		return true;
	}
	
}
