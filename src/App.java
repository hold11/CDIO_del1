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
import desktop_fields.*;
import desktop_resources.*;

public class App {
    public static void main(String[] args) {
        Dice.setFaceCount(6);
        DiceCup.setDiceCount(2);

        Player p1 = new Player();
        Player p2 = new Player();

        Field[] fields = { new Empty.Builder().build() };

        GUI.create(fields);

        GUI.addPlayer(p1.getPlayerName(), 0);
        GUI.addPlayer(p2.getPlayerName(), 0);

        GUI.displayChanceCard("");

        while (!GameLogic.getPlayerHasWon()) {
            Player currentPlayer = Player.findPlayer(GameLogic.whosTurnIsIt());

            GUI.getUserButtonPressed("This turn goes to: " + currentPlayer.getPlayerName() + "\nPress 'the button', would you kindly?", "the button");

            int rolled[] = GameLogic.playTurn(currentPlayer);
            //int calTotalScore = 0;
            //for (int diceFace : rolled) {
            //    calTotalScore += diceFace;
            //}

            GUI.setDice(rolled[0], rolled[1]);
            GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerScore());

            GUI.displayChanceCard(currentPlayer.getPlayerName() + " rolled " + GameLogic.calTotalScore(rolled) + " points.");

            if(GameLogic.getPlayerHasWon()) {
                GUI.displayChanceCard(currentPlayer.getPlayerName() + " rolled " + GameLogic.calTotalScore(rolled) + " points." + "<br>"+ "<br>"+ "<br>" + " YOU ARE WINNER!");
                GUI.showMessage("Press 'ok' to exit");
                GUI.close();
            }
        }
    }
}
