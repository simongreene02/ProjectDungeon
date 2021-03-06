package core;

public class Battle {

	/**
	 * Starts a battle between two entities.
	 * 
	 * @param recoveryAfterBattle
	 *            Whether or not the victorious entity will get a full recovery
	 *            after battle
	 * @param player
	 * @param enemy
	 * @return The entity that won the battle.
	 */
	public static Entity doBattle(boolean recoveryAfterBattle, Entity player, Entity enemy) {
		while (player.getCurrentHealth() >= 0 && enemy.getCurrentHealth() >= 0) {
			if (player.getCurrentHealth() > 0) {
				Posession usedSkill = player.onTurn(enemy);
				System.out.println("You used " + usedSkill.getName());
				usedSkill.onUse(player, enemy);
			}
			if (enemy.getCurrentHealth() > 0) {
				Posession usedSkill = enemy.onTurn(player);
				System.out.println("The enemy used " + usedSkill.getName());
				usedSkill.onUse(enemy, player);
			}
		}
		if (player.getCurrentHealth() > 0) {
			if (recoveryAfterBattle) {
				player.incrementCurrentHealth(player.getMaxHealth());
				for (Skill skill : player.getSkillList()) {
					skill.onBattleEnd();
				}
			}
			return player;
		}
		return enemy;
	}
}
