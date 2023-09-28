package Models;

public abstract class Entity {
    //region Поля
    /**
     * Атака
     * Не может быть null
     * Должно быть положительным.
     */
    private int DPS;
    /**
     * Количество брони
     * Не может быть null
     * Должно быть положительным.
     */
    private int DEF;
    /**
     * Количество здоровья
     * Не может быть null
     * Должно быть положительным.
     */
    private int HP;
    private boolean isAlive;
    /**
     * Количество максимального здоровья. Устанавливается вручную.
     */
    private final int maxHealth = 100;
    //endregion

    //region Конструкторы

    /**
     * Конструктор с параметрами
     * @param DPS атака
     * @param DEF защита
     * @param HP здоровье
     */
    public Entity(int DPS, int DEF, int HP){
        setDPS(DPS);
        setDEF(DEF);
        setHP(HP);
        isAlive = this.HP > 0;
    }
    //endregion

    //region Сеттеры
    public void setDPS(int DPS){
        this.DPS = Math.max(Math.min(DPS, 30), 1);
    }

    public void setDEF(int DEF){
        this.DEF = Math.max(Math.min(DEF, 30), 1);
    }

    public void setHP(int HP){
        this.HP = Math.max(Math.min(HP, maxHealth), 0);
    }
    //endregion

    //region Геттеры

    public int getHP() {
        return HP;
    }

    public int getDEF() {
        return DEF;
    }

    public int getDPS() {
        return DPS;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    //endregion

    //region Методы
    public boolean checkHealth(){
        this.isAlive = this.HP > 0;
        return this.isAlive;
    }
    @Override
    public String toString() {
        return "DPS: " + DPS
                + "\nDEF: " + DEF
                + "\nHP: " + HP;
    }

    //endregion
}
