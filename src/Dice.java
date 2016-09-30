/**
 * Created by awo on 30/09/16.
 */
import java.util.*;

public class Dice {
    private Random rand;

    private static int faceCount;

    public Dice() {
        rand = new Random();
    }

    public int rollDice() {
        return rand.nextInt(faceCount) + 1;
    }

    public static void setFaceCount(int _faceCount) {
        faceCount = _faceCount;
    }

}
