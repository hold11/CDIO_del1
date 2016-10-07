import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by awo on 04/10/16.
 */
public class DiceCupTest {
    DiceCup die;

    /**
     * Sets the faceCount and diceCount in the Dice and DiceCup classes.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Dice.setFaceCount(6);
        DiceCup.setDiceCount(2);
        die = new DiceCup();
    }

    /**
     * Tests if the count of every specific dice roll increments until it gets to 6
     * then the value has to decrement.
     * @throws Exception
     */
    @Test
    public void rollDie() throws Exception {
        // 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        int[] dieScore = new int[11];
        int score = 0;

        for (int i = 0; i < 12000; i++) {
            for (int eyes : die.rollDie())
                score += eyes;

            dieScore[score-2]++;
            score = 0;
        }

        assertTrue(dieScore[0] != 0 && dieScore[10] != 0);

        for (int i = 1; i < 6; i++)
            assertTrue(dieScore[i - 1] < dieScore[i]);
        for (int i = 7; i < 11; i++)
            assertTrue(dieScore[i - 1] > dieScore[i]);

        for (int i = 0; i < dieScore.length; i++)
            System.out.printf("score %s: %s\n", i+2, dieScore[i]);
    }
}