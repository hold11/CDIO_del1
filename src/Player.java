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

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the player class.
 * @version 1.0.0
 */
public class Player {
    private int playerScore;
    private int playerID;
    private String playerName;

    private static int playerCount = 1;

    private static List<Player> players = new ArrayList<Player>();

    public Player(String playerName) {
        this.playerScore = 0;
        this.playerName = playerName;
        this.playerID = playerCount;

        playerCount++;

        players.add(this);
    }

    /**
     * The Player does not take any arguments. When constructing a new player, the new player will
     * automatically get added to the players list (a list of all the players).
     */
    public Player() {
        this.playerScore = 0;
        this.playerName = String.format("Player %s", playerCount);
        this.playerID = playerCount;

        playerCount++;

        players.add(this);
    }

    /**
     * Returns the score of a specific player.
     * @return int
     */
    public int getPlayerScore() {
        return this.playerScore;
    }

    /**
     * This method adds a value to a specific player's score.
     * @param playerScore the wanted value that has to be added to the player.
     */
    public void addPlayerScore(int playerScore) {
        this.playerScore += playerScore;
    }

    /**
     * Returns the player ID of a specific player.
     * @return int
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * Returns the player name of a specific player.
     * @return String
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Returns the specific player with the specified ID.
     * @param playerID the ID of the wanted player
     * @return Player
     */
    public static Player findPlayer(int playerID) {
        for (int i = 0; i < players.size(); i++)
            if (players.get(i).getPlayerID() == playerID)
                return players.get(i);

        throw new IllegalArgumentException("Could not find a player the following ID: " + playerID);
    }

    /**
     * Returns a list of all registered players.
     * @return List of Player objects
     */
    public static List<Player> getPlayersList() {
        return players;
    }

    /**
     * Resets the players list and the playerCount variables.
     */
    public static void reset() {
        playerCount = 1;
        players.clear();
    }
}
