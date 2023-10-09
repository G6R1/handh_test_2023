package models;

public class Player extends Creature {
    private int healingLimit = 4;
    private int maxHealth;

    public Player(int health, int attack, int minDamage, int maxDamage, int defense) {
        super(health, attack, minDamage, maxDamage, defense);
        maxHealth = health;
    }

    @Override
    protected void setHealth(int health) {
        super.setHealth(health);
        if (healingLimit != 0 && health < maxHealth * 0.7) {
            setHealth((int) (health + maxHealth * 0.3));
            healingLimit--;
        }
    }
}
