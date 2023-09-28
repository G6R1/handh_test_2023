public class Player extends Creature {
    private int healingLimit = 4;

    public Player(int health, int attack, int minDamage, int maxDamage, int defense) {
        super(health, attack, minDamage, maxDamage, defense);
    }

    public int getHealingLimit() {
        return healingLimit;
    }

    private void setHealingLimit(int healingLimit) {
        this.healingLimit = healingLimit;
    }
}
