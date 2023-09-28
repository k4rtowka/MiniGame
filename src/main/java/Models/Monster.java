package Models;

public class Monster extends Entity{

    public Monster(int DPS, int DEF, int HP){
        super(DPS, DEF, HP);
    }

    //region Методы
    @Override
    public String toString() {
        return "Монстр: \n" + super.toString();
    }
    //endregion

}
