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
        //будем ли валидировать - private конструктор, метод для создания
        this.health = health;
        this.attack = attack;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.defense = defense;
    }

    public void hit(Creature enemy) {
        if (!isAlive) {
            System.out.println("Вы мертвы.");
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
                enemy.setHealth(enemy.getHealth() - r.nextInt(maxDamage + 1 - minDamage) + minDamage);
                break;
            }
            attMod--;
        }

        if (attMod == 0)
            System.out.println("Неудачная атака. ");
    }


    /*
    Одно Существо может ударить другое по такому алгоритму:
  - Рассчитываем Модификатор атаки. Он равен разности Атаки атакующего и Защиты защищающегося плюс 1
  - Успех определяется броском N кубиков с цифрами от 1 до 6, где N - это Модификатор атаки. Всегда бросается хотя бы один кубик.
    - Удар считается успешным, если хотя бы на одном из кубиков выпадает 5 или 6
  - Если удар успешен, то берется произвольное значение из параметра Урон атакующего и вычитается из Здоровья защищающегося.

     */

    protected void checkParams(int health, int attack, int minDamage, int maxDamage, int defense) {
        boolean at = 0 < attack && attack <= 30;
        boolean df = 0 < defense && defense <= 30;
    };

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (health <= 0)
            setAlive(false);
    }

    public int getAttack() {
        return attack;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getDefense() {
        return defense;
    }

    private boolean isAlive() {
        return isAlive;
    }

    private void setAlive(boolean alive) {
        isAlive = alive;
    }
}
