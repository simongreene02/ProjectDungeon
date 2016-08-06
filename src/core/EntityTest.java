package core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class EntityTest {
	private Entity entity;
	@Before
	public void setUp() {
		entity = new Entity(new Random(0), 10);
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
		entity.addSkill(new Skill());
		Entity enemy = new Entity(new Random(1), 9);
		assertEquals(new Skill(), entity.onTurn(enemy));
	}

}
