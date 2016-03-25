package core;

public class Battle {


	public static Entity doBattle(boolean recoveryAfterBattle, Entity player, Entity enemy) {
		while (player.currentHealth >= 0 && enemy.currentHealth >= 0) {
			if (player.currentHealth > 0) {
				Skill usedSkill = player.onTurn(enemy);
				System.out.println("You used " + usedSkill.getName());
				usedSkill.onUse(player, enemy);
			}
			if (enemy.currentHealth > 0) {
				Skill usedSkill = enemy.onTurn(player);
				System.out.println("The enemy used " + usedSkill.getName());
				usedSkill.onUse(enemy, player);
			}
		}
		if (recoveryAfterBattle == true && player.currentHealth > 0) {
			player.currentHealth = player.getMaxHealth();
			for (Skill s : player.getSkillList()) {
				s.onBattleEnd();
			}
		}
		if (player.currentHealth > enemy.currentHealth) {
			return player;
		} else if (enemy.currentHealth > player.currentHealth) {
			return enemy;
		} else {
			return null;
		}
	}
}
