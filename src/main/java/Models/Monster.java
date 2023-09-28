package Models;

/**
 * Класс объектов типа "Монстр".
 */
public class Monster extends Entity{

    public Monster(int DPS, int DEF, int HP, int minDamage, int maxDamage){
        super(DPS, DEF, HP, minDamage, maxDamage);
    }

    //region Методы
    @Override
    public String toString() {
        return "Монстр: \n" + super.toString();
    }
    //endregion

}
