import java.util.Objects;

public abstract class Creature {

    private int health;
    private int attack;
    private int minDamage;
    private int maxDamage;
    private int defense;
    private boolean isAlive = true;

    public Creature(int health, int attack, int minDamage, int maxDamage, int defense) {
        //будем ли валидировать
        this.health = health;
        this.attack = attack;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.defense = defense;
    }

    public void hit(Creature enemy) {
        if (Objects.equals(this, enemy))
            System.out.println("Нельзя атаковать самого себя.");

        int attMod = this.attack - enemy.getDefense() + 1;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
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
