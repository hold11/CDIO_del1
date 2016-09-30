import java.util.Scanner;

/**
 * Created by awo on 30/09/16.
 */
public class App {
    public static void main(String[] args) {
        Dice.setFaceCount(6);
        DiceCup.setDiceCount(2);
        GameLogic.setPlayerCount(2);

        Player p1 = new Player("Karl");
        Player p2 = new Player("Hans");
        Player[] players = {p1, p2};

        GameLogic.setPlayers(players);

        while (!GameLogic.playerHasWon) {
            //String currentPlayer = GameLogic.findPlayer(GameLogic.whosTurnIsIt()).getPlayerName();
            Player currentPlayer = GameLogic.findPlayer(GameLogic.whosTurnIsIt());

            System.out.printf("This turn goes to: %s", currentPlayer.getPlayerName());
            System.out.print("\nPress 'enter' to roll the die.");
            pause();
            
            // Mere kommer senere
            System.out.println(currentPlayer.getPlayerName() + " rolled " + GameLogic.playTurn(currentPlayer) + " in total.");
            System.out.println("" + currentPlayer.getPlayerName() + " now has " + currentPlayer.getPlayerScore() + " points.\n\n");
        }
    }

    private static void pause() {
        try {System.in.read(); }
        catch (Exception ex) {  }
    }
}
