package Models;


/**
 * Класс объектов типа "Игрок".
 */
public class Player extends Entity {

    //region Поля
    /**
     * Количество раз, сколько игрок может исцеляться.
     * По тз установлено 3 раза.
     */
    private int healCount;
    //endregion

    //region Конструкторы
    public Player(){}
    public Player(int DPS, int DEF, int HP, int minDamage, int maxDamage){
        super(DPS, DEF, HP, minDamage, maxDamage);
        healCount = 3;
    }
    //endregion

    //region Методы
    /**
     * Лечение игрока.
     * Лечение равно 30% от максимального запаса здоровья.
     */
    public void heal(){
        if(healCount <= 0){
            System.out.println("Больше нет возможности исцеляться!");
        }else if(checkHealth()) {
            int newHp = (int) Math.min(getHP() + Math.round(getMaxHealth() * 0.3), getMaxHealth());
            int healedHP = newHp - getHP();
            setHP(newHp);
            System.out.printf("Восстановлено %d здоровья. Текущее количество HP: %d\n",
                    healedHP, getHP());
            healCount--;
        }
    }


    @Override
    public String toString() {
        return "Игрок: \n" + super.toString();
    }
    //endregion
}
