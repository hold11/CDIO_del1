/**
 * Created by awo on 30/09/16.
 */
public class Player {
    private int playerScore;
    private int playerID;
    private String playerName;

    private static int playerCount = 1;

    public Player(String playerName) {
        this.playerScore = 0;
        this.playerName = playerName;
        this.playerID = playerCount;

        playerCount++;
    }
    public int getPlayerScore() {
        return this.playerScore;
    }

    public void addPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }
}
