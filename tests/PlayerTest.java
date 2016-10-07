import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by awo on 04/10/16.
 */
public class PlayerTest {
    private Player p1, p2, p3, p4;

    /**
     * Sets up 4 players, 2 with the default name, and 2 with a custom name.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player("Hans");
        p4 = new Player("Betinna");
    }

    /**
     * Resets all the users so we won't end up with 60 users.
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        Player.reset();
    }

    /**
     * Tests if score can be added to each player.
     * @throws Exception
     */
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

    /**
     * Tests if the player ID can be fetched from a player, and the player ID matched correctly to the player.
     * @throws Exception
     */
    @Test
    public void getPlayerID() throws Exception {
        assertEquals(1, p1.getPlayerID());
        assertEquals(2, p2.getPlayerID());
        assertEquals(3, p3.getPlayerID());
        assertEquals(4, p4.getPlayerID());
    }

    /**
     * Tests if the Player 1 and Player 2 gets the correct name, and if custom names can be set.
     * @throws Exception
     */
    @Test
    public void getPlayerName() throws Exception {
        assertEquals("Player 1", p1.getPlayerName());
        assertEquals("Player 2", p2.getPlayerName());
        assertEquals("Hans",     p3.getPlayerName());
        assertEquals("Betinna",  p4.getPlayerName());
    }

    /**
     * Tests if a player can be found by ID.
     * @throws Exception
     */
    @Test
    public void findPlayer() throws Exception {
        assertEquals("Player 1", Player.findPlayer(1).getPlayerName());
        assertEquals("Betinna", Player.findPlayer(4).getPlayerName());
    }

    /**
     * Tests if the player list can be fetched.
     * @throws Exception
     */
    @Test
    public void getPlayersList() throws Exception {
        List<Player> players = Player.getPlayersList();
        assertEquals(4, players.size());
    }

}