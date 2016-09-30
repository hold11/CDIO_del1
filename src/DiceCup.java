/**
 * Created by awo on 30/09/16.
 */
public class DiceCup {
    private Dice[] die;     // [] fordi vi har en Array (eller liste) af terninger (Dice)

    private static int diceCount;

    public DiceCup() {
        // Vi instantierer vores Dice array med antallet diceCount terninger
        die = new Dice[diceCount];

        // Hver plads i vores die array får instantieret en ny Dice
        for (int i = 0; i < diceCount; i++) {
            Dice dice = new Dice();
            die[i] = dice;
        }
    }

    public int[] rollDie() {
        // Vi vil have en array af resultater, så hver terning i kastet kan behandles hver for sig i GameLogic-klassen
        int[] result = new int[diceCount];

        // Hver terning kastes, og sættes ind i result
        for (int i = 0; i < diceCount; i++) {
            result[i] = die[i].rollDice();
        }

        // Resultatet returneres
        return result;
    }

    public static void setDiceCount(int _diceCount) {
        diceCount = _diceCount;
    }

    public static int getDiceCount() {
        return diceCount;
    }
}
