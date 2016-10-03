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

/**
 * This class uses the Dice class to roll multiple die. It handles the wanted amount
 * of die in the project, and rolls them all.
 * @version 1.0.0
 */
public class DiceCup {
    private Dice[] die;     // [] Because we have an Array of Dice objects

    private static int diceCount;

    /**
     * When the DiceCup gets constructed, an arrays gets initialized with the wanted amount of die. Therefore
     * it is important that the diceCount variable gets set first (with the setDiceCount method).
     */
    public DiceCup() {
        // We instantiate our Dice object array with the diceCount number of die
        die = new Dice[diceCount];

        // Every record in our Dice object array gets instantiated with a new Dice object
        for (int i = 0; i < diceCount; i++) {
            Dice dice = new Dice();
            die[i] = dice;
        }
    }

    /**
     * Returns an array of all the rolled die. All values gets put in an array, and outputted.
     * @return array of int's
     */
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

    /**
     * Sets the wanted amount of die in the project.
     * @param _diceCount wanted amount of die.
     */
    public static void setDiceCount(int _diceCount) {
        diceCount = _diceCount;
    }

    /**
     * Returns the specified amount of die chosen in the project.
     * @return int
     */
    public static int getDiceCount() {
        return diceCount;
    }
}
