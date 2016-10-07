import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by twast on 07-10-2016.
 */

public class GameLogicTest {
    Player p1, p2;

    @Before
    public void setUp() throws Exception {
        p1 = new Player();
        p2 = new Player();
    }

    @After
    public void tearDown() throws Exception {
        Player.reset();
    }

    @Test
    public void playTurn() throws Exception {

    }

    @Test
    public void calTotalScore() throws Exception {

    }

    @Test
    public void whoseTurnIsIt() throws Exception {

    }

}