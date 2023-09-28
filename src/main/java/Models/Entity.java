package Models;

import java.util.Random;
/**
 * Абстрактный класс типа "Сущность".
 */
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
    /**
     * Состояние существа
     */
    private boolean isAlive;
    /**
     * Количество максимального здоровья. Устанавливается вручную.
     */
    private final int maxHealth = 100;
    /**
     * Максимальное количество урона, которое может нанести существо.
     * Не может быть меньше минимального количества урона.
     * Не может быть больше чем половина максимального здоровья существ.
     */
    private int maxDamage;
    /**
     * Минимальное количество урона, которое может нанести существо.
     * Не может быть меньше единицы урона.
     * Не может быть больше чем 20% от максимального здоровья существ.
     */
    private int minDamage;

    //endregion

    //region Конструкторы

    /**
     * Конструктор с параметрами
     * @param DPS атака
     * @param DEF защита
     * @param HP здоровье
     * @param minDamage минимальный урон
     * @param maxDamage максимальный урон
     */
    public Entity(int DPS, int DEF, int HP, int minDamage, int maxDamage){
        setDPS(DPS);
        setDEF(DEF);
        setHP(HP);
        setMinDamage(minDamage);
        setMaxDamage(maxDamage);
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

    private void setMinDamage(int minDamage) {
        this.minDamage = (int) Math.max(Math.min(minDamage, maxHealth*0.2), 1);
    }

    private void setMaxDamage(int maxDamage) {
        this.maxDamage = (int) Math.max(Math.min(maxDamage, maxHealth*0.5), this.minDamage);;
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

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getDamage(){
        Random random = new Random();
        return random.nextInt(maxDamage) + minDamage;
    }
    //endregion

    //region Методы
    /**
     * @return true - если существо живо, false - если мертво.
     */
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
