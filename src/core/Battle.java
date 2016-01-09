package core;

public class Battle {
	
	public Entity Battle(boolean recoveryAfterBattle, Entity player, Entity enemy) {
		while (player.currentHealth >= 0 && enemy.currentHealth >= 0) {
			if (player.currentHealth >= 0) {
				System.out.println(player.onTurn(enemy).onUse(player, enemy));
			}
			if (enemy.currentHealth >= 0) {
				System.out.println(enemy.onTurn(player).onUse(enemy, player));
			}
		}
		if (recoveryAfterBattle == true && player.currentHealth > 0) {
			player.currentHealth = player.getMaxHealth();
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
