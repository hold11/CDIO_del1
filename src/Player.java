/**
 ||======================================||
 ||    _         _     _  ___   ___      ||  Terningspil v1.0.0 | Java JDK 1.8.0_101
 ||   | |__   _ | | __| |/_  | /_  |     ||  Anders Wiberg Olsen        (s165241)
 ||   | '_ \ / \| |/ _  |  | |   | |     ||  Emil Johan Høj             (s152282)
 ||   | | | | O | | (_| | _| |_ _| |_    ||  Iman Chelhi                (s165228)
 ||   |_| |_|\_/|_|\__,_||_____|_____|   ||  Sebastian Tibor Bakonyvári (s145918)
 ||                                      ||  Troels Just Christoffersen (s150052)
 ||======================================||
 */

import java.util.ArrayList;
import java.util.List;

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

    public Player() {
        this.playerScore = 0;
        this.playerName = String.format("Player %s", playerCount);
        this.playerID = playerCount;

        playerCount++;

        players.add(this);
    }

    public int getPlayerScore() {
        return this.playerScore;
    }

    public void addPlayerScore(int playerScore) {
        this.playerScore += playerScore;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public static Player findPlayer(int playerID) {
        for (int i = 0; i < players.size(); i++)
            if (players.get(i).getPlayerID() == playerID)
                return players.get(i);

        throw new IllegalArgumentException("Could not find a player the following ID: " + playerID);
    }

    public static List<Player> getPlayersList() {
        return players;
    }
}
