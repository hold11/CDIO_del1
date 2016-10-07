/*
    §§======================================§§
    ||    _         _     _  ___   ___      ||  Terningspil v1.0.0 | Java JDK 1.8.0_101
    ||   | |__   _ | | __| |/_  | /_  |     ||  Anders Wiberg Olsen        (s165241)
    ||   | '_ \ / \| |/ _  |  | |   | |     ||  Emil Johan Hoeg            (s152282)
    ||   | | | | O | | (_| | _| |_ _| |_    ||  Iman Chelhi                (s165228)
    ||   |_| |_|\_/|_|\__,_||_____|_____|   ||  Sebastian Tibor Bakonyvari (s145918)
    ||                                      ||  Troels Just Christoffersen (s150052)
    §§======================================§§
 */

import java.util.List;

/**
 * This class holds all of the game logic to the game. All rules gets applied in this class.
 * @version 1.0.0
 */
public class GameLogic {

    private static int playerTurn = 0;
    private static List<Player> players = Player.getPlayersList();

    private static boolean playerHasWon = false;

    public static boolean getPlayerHasWon() {
        return playerHasWon;
    }

    /**
     * Returns the score the specific player rolled (Dice).
     * @param player the player that has to play.
     * @return int
     */
    public static int[] playTurn(Player player) {
        DiceCup diceCup = new DiceCup();
        //int   result = 0;
        int[] rolled = diceCup.rollDie();

        //for (int i = 0; i < DiceCup.getDiceCount(); i++)
        //    result += rolled[i];

        //player.addPlayerScore(result);
        player.addPlayerScore(calTotalScore(rolled));

        if(player.getPlayerScore() >= 40) {
            System.out.println("\n" + player.getPlayerName() + " has won the game.");
            playerHasWon = true;
        }

        return rolled;
    }

    /**
     * This method takes an array, and calculates the total score
     * @param rolled array of integers
     * @return int
     */
    public static int calTotalScore(int[] rolled) {
        int total = 0;
        for (int val : rolled)
            total += val;
        return total;
    }

    /**
     * Returns the ID of the specific player whos turn it is.
     * @return int
     */
    public static int whosTurnIsIt() {
        if (playerTurn < players.size())
            playerTurn++;
        else
            playerTurn = 1;

        return playerTurn;
    }
}
