import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by awo on 04/10/16.
 */
public class PlayerTest {
    Player p1, p2, p3, p4;

    // TODO: The players p1, p2, p3 and p4 gets reconstructed many times, so fx p1 gets the name "Player 35", and there are 16 players in the players list. FIX IT!

    @Before
    public void setUp() throws Exception {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player("Hans");
        p4 = new Player("Betinna");
    }

    @After
    public void tearDown() throws Exception {
        Player.reset();
    }

    @Test
    public void addPlayerScore() throws Exception {
        int add1 = 17, add2 = 13, add3 = 5, add4 = 2;
        p1.addPlayerScore(add1);
        p2.addPlayerScore(add2);

        assertEquals(add1, p1.getPlayerScore());
        assertEquals(add2, p2.getPlayerScore());

        p1.addPlayerScore(add3);
        p2.addPlayerScore(add4);

        assertEquals(add1 + add3, p1.getPlayerScore());
        assertEquals(add2 + add4, p2.getPlayerScore());
    }

    @Test
    public void getPlayerID() throws Exception {
        assertEquals(1, p1.getPlayerID());
        assertEquals(2, p2.getPlayerID());
        assertEquals(3, p3.getPlayerID());
        assertEquals(4, p4.getPlayerID());
    }

    @Test
    public void getPlayerName() throws Exception {
        assertEquals("Player 1", p1.getPlayerName());
        assertEquals("Player 2", p2.getPlayerName());
        assertEquals("Hans",     p3.getPlayerName());
        assertEquals("Betinna",  p4.getPlayerName());
    }

    @Test
    public void findPlayer() throws Exception {
        assertEquals("Player 1", Player.findPlayer(1).getPlayerName());
        assertEquals("Betinna", Player.findPlayer(4).getPlayerName());
    }

    @Test
    public void getPlayersList() throws Exception {
        List<Player> players = Player.getPlayersList();
        assertEquals(4, players.size());
    }

}