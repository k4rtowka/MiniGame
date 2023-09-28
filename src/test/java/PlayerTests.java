import Models.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlayerTests {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    public void createPlayer_WithValidParams(){
        int HP = 99;
        int DPS = 20;
        int DEF = 25;
        player.setHP(HP); player.setDEF(DEF); player.setDPS(DPS);
        assertEquals(DEF, player.getDEF());
        assertEquals(HP, player.getHP());
        assertEquals(DPS, player.getDPS());
    }

    @Test
    public void createPlayer_WithInvalidParams(){
        int HP = -123;
        int DPS = 10000;
        int DEF = 923850972;
        int maxDamage = 10000;
        int minDamage = 10000;
        player.setHP(HP); player.setDEF(DEF); player.setDPS(DPS);
        player.setMinDamage(minDamage); player.setMaxDamage(maxDamage);

        assertEquals(30, player.getDEF());
        assertEquals(0, player.getHP());
        assertEquals(30, player.getDPS());
        assertEquals(20, player.getMinDamage());
        assertEquals(50, player.getMaxDamage());
    }

    @Test
    public void healTest(){
        int HP = 90;
        int DPS = 0;
        int DEF = 0;
        int maxDamage = 1;
        int minDamage = 1;
        Player player = new Player(DPS, DEF, HP, minDamage, maxDamage);
        player.heal();
        assertEquals(100, player.getHP());
        player.heal();
        assertEquals(100, player.getHP());
    }

    @Test
    public void healMaxHpTest(){
        int HP = 90;
        int DPS = 0;
        int DEF = 0;
        int maxDamage = 1;
        int minDamage = 1;
        Player player = new Player(DPS, DEF, HP, minDamage, maxDamage);
        player.heal();
        assertEquals(100, player.getHP());
        player.heal();
        assertEquals(100, player.getHP());
    }
}
