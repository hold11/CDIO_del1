import java.util.ArrayList;
import java.util.List;

/**
 * Created by awo on 30/09/16.
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
}
