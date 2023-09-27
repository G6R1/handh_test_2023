import java.util.Objects;

public abstract class Creature {

    private int health;
    private int damage;
    private int defense;
    private boolean isAlive = true;


    public void attack(Creature enemy) {
        if (Objects.equals(this, enemy))
            System.out.println("Нельзя атаковать самого себя.");
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
