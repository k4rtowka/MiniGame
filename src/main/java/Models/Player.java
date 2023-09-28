package Models;

public class Player extends Entity {
    private int healCount;

    //region Конструкторы
    public Player(int DPS, int DEF, int HP){
        super(DPS, DEF, HP);
        healCount = 3;
    }
    //endregion

    /**
     * Лечение игрока. Максимум лечений - 3.
     * Лечение равно 30% от максимального запаса здоровья.
     */
    //region Методы
    public void heal(){
        if(healCount <= 0){
            System.out.println("Больше нет возможности исцеляться!");
        }else if(checkHealth()) {
            int newHp = (int) Math.min(getHP() + Math.round(getMaxHealth() * 0.3), getMaxHealth());
            int healedHP = newHp - getHP();
            setHP(newHp);
            System.out.println("Восстановлено " + healedHP + " здоровья. Текущее количество HP: " + getHP());
            healCount--;
        }
    }
    @Override
    public String toString() {
        return "Игрок: \n" + super.toString();
    }
    //endregion
}
