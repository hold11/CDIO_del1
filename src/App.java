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

        while (!GameLogic.playerHasWon()) {
            String currentPlayer = GameLogic.findPlayer(GameLogic.whosTurnIsIt()).getPlayerName();

            System.out.printf("This turn goes to: %s", currentPlayer);
            System.out.print("Press 'enter' to roll the die.");
            pause();
            


            // Mere kommer senere
            System.out.println(currentPlayer + " rolled ");
        }
    }

    private static void pause() {
        try {System.in.read(); }
        catch (Exception ex) {  }
    }
}
