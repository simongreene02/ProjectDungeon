package core;

import java.util.Objects;

public class Skill implements Posession {
	private final String name;
	private final String description;

	public Skill(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void onUse(Entity user, Entity target) {
		System.out.println("Nothing happened.");
	}

	public void onTurn() {
		// Use this method for cooldown times and other time-based effects
	}

	public void onBattleEnd() {
		// Use this method for anything that can only be done a certain number
		// of times per battle
	}

	@Override
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean canBeUsed() {
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Skill))
			return false;
		Skill other = (Skill) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
