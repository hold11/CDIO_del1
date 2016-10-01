/**
 * Created by awo on 30/09/16.
 */
public class GameLogic {

    private static int playerTurn = 0;
    private static int playerCount;
    private static Player[] players;

    protected static boolean playerHasWon = false;

    private static void addScore(Player player, int score) {
        player.addPlayerScore(score);
    }

    public static int playTurn(Player player) {
        DiceCup diceCup = new DiceCup();
        int result = 0;

        for (int i = 0; i < DiceCup.getDiceCount(); i++) {
            result += diceCup.rollDie()[i];
        }

        addScore(player, result);

        if (player.getPlayerScore() >= 40)
        {System.out.println(player.getPlayerName() + " has won the game."); playerHasWon = true; }

        return result;
    }

    public static void setPlayerCount(int _playerCount) {
        playerCount = _playerCount;
    }

    public static void setPlayers(Player[] _players) {
        players = _players;
    }

    /*public static boolean playerHasWon() {
        for (int i = 0; i < playerCount; i++) {
            if (players[i].getPlayerScore() < 40)
                return false;
            else
                return true;
        }

        return false;
    }*/

    //public static Player findPlayer(int playerID) {
    //    for (int i = 0; i < players.length; i++)
    //        if (players[i].getPlayerID() == playerID)
    //            return players[i];

    //    throw new IllegalArgumentException("Could not find a player the following ID: " + playerID);
    //}

    public static int whosTurnIsIt() {
        if (playerTurn < players.length)
            playerTurn++;
        else
            playerTurn = 1;

        return playerTurn;
    }
}
