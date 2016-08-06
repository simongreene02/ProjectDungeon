package core;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * This class is a mutable that represents a charactor entity
 * @author ninja
 *
 */
public class Entity {
	private final int maxHealth;
	private final Random random;
	private int currentHealth;
	private ArrayList<Skill> skillList = new ArrayList<Skill>();
	public Entity(Random random, int maxhealth) {
		this.random = random;
		this.maxHealth = maxhealth;
		currentHealth = maxHealth;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public ArrayList<Skill> getSkillList() {
		return skillList;
	}
	public Skill onTurn(Entity enemy) {
		if (skillList.isEmpty()) {
			throw new IllegalStateException("SkillList is empty");
		}
		return skillList.get(random.nextInt(skillList.size()));
	}
	@Override
	public int hashCode() {
		return Objects.hash(maxHealth, currentHealth, skillList);
	}
	@Override
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
	
	public void addSkill(Skill skill) {
		skillList.add(skill);
	}
	
}
