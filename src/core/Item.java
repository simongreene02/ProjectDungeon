package core;

public class Item extends Skill {
	private String name;
	private String description;
	private boolean canBeUsed;

	public Item() {
		super();
		name = super.getName();
		description = super.getDescription();
		canBeUsed = super.isCanBeUsed();
	}
	
}
