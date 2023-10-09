import models.Monster;
import models.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(40, 30, 2, 8, 30);
        Monster monster1 = new Monster(10, 10, 1, 1, 10);
        Monster monster2 = new Monster(50, 20, 1, 4, 20);
        Monster monster3 = new Monster(200, 30, 1, 3, 30);

        Monster monster4;
        try {
            monster4 = new Monster(-100, 50, 7, 6, 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Невалидные параметры для создания существа.
        }

        player.hit(player); // Нельзя атаковать самого себя.

        while (monster1.isAlive() && player.isAlive()) {
            player.hit(monster1);
            if (monster1.isAlive())
                monster1.hit(player);
        }

        if (player.isAlive()) {
            System.out.println("Монстр-1 повержен!");
        } else {
            System.out.println("Игрок повержен!");
            return;
        }

        while (monster2.isAlive() && player.isAlive()) {
            player.hit(monster2);
            if (monster2.isAlive())
                monster2.hit(player);
        }

        if (player.isAlive()) {
            System.out.println("Монстр-2 повержен!");
        } else {
            System.out.println("Игрок повержен!");
            return;
        }

        while (monster3.isAlive() && player.isAlive()) {
            player.hit(monster3);
            if (monster3.isAlive())
                monster3.hit(player);
        }

        if (player.isAlive()) {
            System.out.println("Монстр-3 повержен!");
        } else {
            System.out.println("Игрок повержен!");
        }
    }
}