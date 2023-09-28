package Models;

import java.util.Random;

/**
 * Класс для реализации сражений между существами.
 */
public class Battle {


    //region Тех.задание
    /**
     * Первое существо атакует второе.
     * @param first первое существо
     * @param second второе существо
     */
    public void attack(Entity first, Entity second){
        //Проверка, что оба живы
        if(first.checkHealth() && second.checkHealth()) {

            //Расчет модификатора урона
            int modifier = calcDamage(first.getDPS(), second.getDEF());
            Random random = new Random();

            if(modifier <= 0) modifier = 1;
            int damage;
            for (int i = 0; i < modifier; i++) {
                if ((random.nextInt(6) + 1) == 6 || (random.nextInt(6) + 1) == 5) {
                    damage = first.getDamage();
                    second.setHP(second.getHP() - damage);
                    System.out.printf("Нанесено %d урона. %s: Оставшееся здоровье %d.\n",
                            damage, second.getClass().getSimpleName(), second.getHP());

                    if (second.checkHealth()) return;
                    System.out.printf("%s погиб!", second.getClass().getSimpleName());
                    return;
                }
            }

            System.out.println("Нанесено 0 урона.");

        }else System.out.println("Мертвые уже не сражаются.");
    }

    private int calcDamage(int attack, int defense){
        return attack - defense + 1;
    }
    //endregion

    //region Доп. методы
    /**
     * Имитирует сражение игрока и монстра.
     * @param player игрок
     * @param monster монстр
     */
    public void fight(Player player, Monster monster){
        Random random = new Random();
        while(player.checkHealth() && monster.checkHealth()){
            this.attack(player, monster);
            this.attack(monster, player);
            if(random.nextBoolean()) {
                player.heal();
                this.attack(monster, player);
            }
        }
    }
    //endregion

}
