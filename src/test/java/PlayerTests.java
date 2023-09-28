import Models.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlayerTests {

    @Test
    public void createPlayer_WithValidParams(){
        int HP = 99;
        int DPS = 20;
        int DEF = 25;
        Player player = new Player(DPS, DEF, HP);
        assertEquals(DEF, player.getDEF());
        assertEquals(HP, player.getHP());
        assertEquals(DPS, player.getDPS());
    }

    @Test
    public void createPlayer_WithInvalidParams(){
        int HP = -123;
        int DPS = 10000;
        int DEF = 923850972;
        Player player = new Player(DPS, DEF, HP);
        assertEquals(30, player.getDEF());
        assertEquals(0, player.getHP());
        assertEquals(30, player.getDPS());
    }
}
