package core;

public class Skill {
	private String name;
	private String description;
	private boolean canBeUsed;
	public Skill() {
		this.name = "Basic Skill";
		this.description = "This skill does nothing and if you are seeing this, it is probably a bug.";
	}
	public String onUse(Entity user, Entity target) {
		return "Nothing happened.";
	}
	public void onTurn() {
//	Use this method for cooldown times and other time-based effects
	}

	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public boolean isCanBeUsed() {
		return canBeUsed;
	}
	public void setCanBeUsed(boolean canBeUsed) {
		this.canBeUsed = canBeUsed;
	}
}
