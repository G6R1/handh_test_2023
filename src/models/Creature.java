package models;

import java.util.Objects;
import java.util.Random;

public abstract class Creature {

    private int health;
    private int attack;
    private int minDamage;
    private int maxDamage;
    private int defense;
    private boolean isAlive = true;

    public Creature(int health, int attack, int minDamage, int maxDamage, int defense) {
        if (!checkParams(health, attack, minDamage, maxDamage, defense))
            throw new IllegalArgumentException("Невалидные параметры для создания существа.");

        this.health = health;
        this.attack = attack;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.defense = defense;
    }

    public void hit(Creature enemy) {
        if (!isAlive) {
            System.out.println("Погибщее существо не может совершить атаку. ");
            return;
        }
        if (!enemy.isAlive()) {
            System.out.println("Враг уже мертв.");
            return;
        }
        if (Objects.equals(this, enemy)) {
            System.out.println("Нельзя атаковать самого себя.");
            return;
        }


        int attMod = this.attack - enemy.getDefense() + 1;
        if (attMod <= 0)
            attMod = 1;
        Random r = new Random();

        while (attMod != 0) {
            int roll = r.nextInt(6) + 1;
            if (roll == 5 || roll == 6) {
                enemy.setHealth(enemy.getHealth() - (r.nextInt(maxDamage + 1 - minDamage) + minDamage));
                break;
            }
            attMod--;
        }
    }

    protected boolean checkParams(int health, int attack, int minDamage, int maxDamage, int defense) {
        return (0 < attack && attack <= 30)
                && (0 < defense && defense <= 30)
                && health > 0
                && maxDamage >= minDamage;
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
        if (health <= 0) {
            this.health = 0;
            isAlive = false;
        }
    }

    public int getDefense() {
        return defense;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
