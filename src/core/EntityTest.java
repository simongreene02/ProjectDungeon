package core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class EntityTest {
	private Entity entity;
	private Entity damagedEntity;
	@Before
	public void setUp() {
		entity = new Entity(new Random(0), 10);
		damagedEntity = new Entity(new Random(0), 10, 4);
	}

	@Test
	public void getMaxHealth() {
		assertEquals(10, entity.getMaxHealth());
	}
	
	@Test
	public void getSkillList() {
		assertEquals(new ArrayList<Skill>(), entity.getSkillList());
	}
	
	@Test (expected = IllegalStateException.class)
	public void onTurn_emptyList() {
		Entity enemy = new Entity(new Random(1), 9);
		entity.onTurn(enemy);
	}
	
	@Test
	public void onTurn() {
		entity.addSkill(new Skill("", ""));
		Entity enemy = new Entity(new Random(1), 9);
		assertEquals(new Skill("", ""), entity.onTurn(enemy));
	}
	
	@Test
	public void decrementCurrentHealth_by6() {
		entity.decrementCurrentHealth(6);
		assertEquals(4, entity.getCurrentHealth());
	}
	
	@Test
	public void decrementCurrentHealth_by11() {
		entity.decrementCurrentHealth(11);
		assertEquals(0, entity.getCurrentHealth());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void decrementCurrentHealth_by0() {
		entity.decrementCurrentHealth(0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void decrementCurrentHealth_withNegativeValue() {
		entity.decrementCurrentHealth(-1);
	}
	
	@Test
	public void incrementCurrentHealth_by4() {
		damagedEntity.incrementCurrentHealth(4);
		assertEquals(8, damagedEntity.getCurrentHealth());
	}
	
	@Test
	public void incrementCurrentHealth_by100() {
		damagedEntity.incrementCurrentHealth(100);
		assertEquals(10, damagedEntity.getCurrentHealth());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void incrementCurrentHealth_by0() {
		damagedEntity.incrementCurrentHealth(0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void incrementCurrentHealth_withNegativeValue() {
		damagedEntity.incrementCurrentHealth(-1);
	}

}
