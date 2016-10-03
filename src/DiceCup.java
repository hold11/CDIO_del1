/*
 ||======================================||
 ||    _         _     _  ___   ___      ||  Terningspil v1.0.0 | Java JDK 1.8.0_101
 ||   | |__   _ | | __| |/_  | /_  |     ||  Anders Wiberg Olsen        (s165241)
 ||   | '_ \ / \| |/ _  |  | |   | |     ||  Emil Johan Hoeg            (s152282)
 ||   | | | | O | | (_| | _| |_ _| |_    ||  Iman Chelhi                (s165228)
 ||   |_| |_|\_/|_|\__,_||_____|_____|   ||  Sebastian Tibor Bakonyvari (s145918)
 ||                                      ||  Troels Just Christoffersen (s150052)
 ||======================================||
 */

public class DiceCup {
    private Dice[] die;     // [] Because we have an Array of Dice objects

    private static int diceCount;

    public DiceCup() {
        // We instantiate our Dice object array with the diceCount number of die
        die = new Dice[diceCount];

        // Every record in our Dice object array gets instantiated with a new Dice object
        for (int i = 0; i < diceCount; i++) {
            Dice dice = new Dice();
            die[i] = dice;
        }
    }

    public int[] rollDie() {
        // We need an array of results, so every dice that gets rolled, gets analysed speerately in the GameLogic class
        int[] result = new int[diceCount];

        // Every dice gets rolled, and the value of the face, gets inserted in the result array
        for (int i = 0; i < diceCount; i++) {
            result[i] = die[i].rollDice();
        }

        // The result gets returned
        return result;
    }

    public static void setDiceCount(int _diceCount) {
        diceCount = _diceCount;
    }

    public static int getDiceCount() {
        return diceCount;
    }
}
