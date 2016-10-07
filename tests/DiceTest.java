import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by awo on 04/10/16.
 */
public class DiceTest {
    private Dice dice;

    /**
     * Sets the face count value from the Dice class
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Dice.setFaceCount(6);
        dice = new Dice();
    }

    /**
     * Tests if the dice works, and are some what random
     * @throws Exception
     */
    @Test
    public void rollDice() throws Exception {
        int[] diceFace = new int[6];

        for (int i = 0; i < 60000; i++)
            diceFace[dice.rollDice() - 1]++;

        for (int i = 0; i < diceFace.length; i++)
        {
            assertEquals(10000, diceFace[i], 400);
            System.out.printf("face %s: %s\n", i+1, diceFace[i]);
        }
    }
}