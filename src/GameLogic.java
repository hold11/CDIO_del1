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

public class GameLogic {

    private static int playerTurn = 0;
    private static int playerCount;
    private static List<Player> players = Player.getPlayersList();

    protected static boolean playerHasWon = false;

    public static int playTurn(Player player) {
        DiceCup diceCup = new DiceCup();
        int result = 0;

        for (int i = 0; i < DiceCup.getDiceCount(); i++) {
            result += diceCup.rollDie()[i];
        }

        player.addPlayerScore(result);

        if (player.getPlayerScore() >= 40)
        {System.out.println(player.getPlayerName() + " has won the game."); playerHasWon = true; }

        return result;
    }

    public static void setPlayerCount(int _playerCount) {
        playerCount = _playerCount;
    }

    //public static void setPlayers(Player[] _players) {
    //    players = _players;
    //}

    public static int whosTurnIsIt() {
        if (playerTurn < players.size())
            playerTurn++;
        else
            playerTurn = 1;

        return playerTurn;
    }
}
