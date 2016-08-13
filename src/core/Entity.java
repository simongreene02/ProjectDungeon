package core;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import com.sun.org.apache.xerces.internal.util.DatatypeMessageFormatter;

import util.Predecate;

/**
 * This class is a mutable that represents a charactor entity
 * 
 * @author ninja
 *
 */
public class Entity {
	private final int maxHealth;
	private final Random random;
	private int currentHealth;
	private ArrayList<Skill> skillList = new ArrayList<Skill>();

	public Entity(Random random, int maxHealth) {
		this(random, maxHealth, maxHealth);
	}
	
	public Entity(Random random, int maxHealth, int currentHealth) {
		this.random = random;
		this.maxHealth = Predecate.checkGreaterThanZero(maxHealth);
		this.currentHealth = Predecate.checkGreaterThanZero(Predecate.checkLessThanEqualToValue(currentHealth, maxHealth));
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public ArrayList<Skill> getSkillList() {
		return skillList;
	}

	public Posession onTurn(Entity enemy) {
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

	public int getCurrentHealth() {
		return currentHealth;
	}

	/**
	 * Decreases the health of the entity by the specified value. If the damage
	 * value is greater than the current health, then the current health will be
	 * set to zero
	 * 
	 * @param damageValue
	 *            The amount to damage the entity (must be greater than 0)
	 * @throws IllegalArgumentException
	 *             when the damage value is less than or greater than 0
	 */
	public void decrementCurrentHealth(int damageValue) {
		currentHealth = Math.max(currentHealth - Predecate.checkGreaterThanZero(damageValue), 0);
	}

	/**
	 * Increases the health of the entity by the specified value. If the healing
	 * value combined with the current health is greater than the max health, then the current health will be
	 * set to the max health
	 * 
	 * @param healingValue
	 *            The amount to heal the entity (must be greater than 0)
	 * @throws IllegalArgumentException
	 *             when the healing value is less than or greater than 0
	 */
	public void incrementCurrentHealth(int healingValue) {
		currentHealth = Math.min(currentHealth + Predecate.checkGreaterThanZero(healingValue), maxHealth);
	}

}
