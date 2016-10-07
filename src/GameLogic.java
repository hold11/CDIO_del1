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

import java.util.List;

/**
 * This class holds all of the game logic to the game. All rules gets applied in this class.
 * @version 1.0.2
 */
public class GameLogic {

    private static int playerTurn = 0;
    private static List<Player> players = Player.getPlayersList();

    private static boolean playerHasWon = false;

    public static boolean getPlayerHasWon() {
        return playerHasWon;
    }

    public static void setPlayerHasWon(boolean playerHasWon) {
        GameLogic.playerHasWon = playerHasWon;
    }

    /**
     * Returns the score the specific player rolled (Dice).
     * @param player the player that has to play.
     * @return int
     */
    public static int[] playTurn(Player player) {
        DiceCup diceCup = new DiceCup();
        int[] eyes = diceCup.rollDie();

        player.addPlayerScore(calTotalScore(eyes, player));

        if(player.getPlayerScore() >= 40) {
            playerHasWon = true;
        }

        return eyes;
    }

    /**
     * This method takes an array, and calculates the total score
     * @param eyes array of integers
     * @param player calculate score of this player
     * @return int
     */
    public static int calTotalScore(int[] eyes, Player player) {
        int total = 0;
        if (eyes[0] == 1 && eyes[1] == 1)
            total -= player.getPlayerScore();

        else
            for (int val : eyes)
                total += val;

        return total;
    }

    /**
     * Returns the ID of the specific player whose turn it is.
     * @return int
     */
    public static int whoseTurnIsIt() {
        if (playerTurn < players.size())
            playerTurn++;
        else
            playerTurn = 1;

        return playerTurn;
    }
}