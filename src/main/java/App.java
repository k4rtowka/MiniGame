import Models.Battle;
import Models.Monster;
import Models.Player;

public class App {
    public static void main(String[] args){
        //Демонстрация возможностей классов по тз.
        Player player = new Player(20, 20, 100, 1, 20);
        Monster monster = new Monster(15, 40, 100, 1, 10);
        Battle battle = new Battle();
        battle.attack(player,monster);
    }
}
