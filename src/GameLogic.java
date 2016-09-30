/**
 * Created by awo on 30/09/16.
 */
public class GameLogic {

    private static int playerCount;
    private static Player[] players;

    private static void addScore(Player player, int score) {
        player.addPlayerScore(score);
    }
    private static void turn(Player player) {
        DiceCup diceCup = new DiceCup();
        int result = 0;

        for (int i = 0; i < DiceCup.getDiceCount(); i++) {
            result += diceCup.rollDie()[i];
        }

        addScore(player, result);
    }

    public static void setPlayerCount(int _playerCount) {
        playerCount = _playerCount;
    }

    public static void setPlayers(Player[] _players) {
        players = _players;
    }

    public static boolean playerHasWon() {
        for (int i = 0; i < playerCount; i++) {
            if (players[i].getPlayerScore() < 40)
                return false;
            else
                return true;
        }

        return false;
    }
}
