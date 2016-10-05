/*
    §§======================================§§
    ||    _         _     _  ___   ___      ||  Terningspil v1.0.0 | Java JDK 1.8.0_101
    ||   | |__   _ | | __| |/_  | /_  |     ||  Anders Wiberg Olsen        (s165241)
    ||   | '_ \ / \| |/ _  |  | |   | |     ||  Emil Johan Hoeg            (s152282)
    ||   | | | | O | | (_| | _| |_ _| |_    ||  Iman Chelhi                (s165228)
    ||   |_| |_|\_/|_|\__,_||_____|_____|   ||  Sebastian Tibor Bakonyvari (s145918)
    ||                                      ||  Troels Just Christoffersen (s150052)
    §§======================================§§
 */

public class App {
    public static void main(String[] args) {
        Dice.setFaceCount(6);
        DiceCup.setDiceCount(2);
        //GameLogic.setPlayerCount(2);

        Player p1 = new Player();
        Player p2 = new Player();

        while (!GameLogic.playerHasWon) {
            //String currentPlayer = GameLogic.findPlayer(GameLogic.whosTurnIsIt()).getPlayerName();
            Player currentPlayer = Player.findPlayer(GameLogic.whosTurnIsIt());

            System.out.printf("This turn goes to: %s", currentPlayer.getPlayerName());
            System.out.print("\nPress 'enter' to roll the die.");
            pause();

            int rolledTotal = 0;
            for (int diceFace : GameLogic.playTurn(currentPlayer))
                rolledTotal += diceFace;

            System.out.println(currentPlayer.getPlayerName() + " rolled " + rolledTotal + " in total.");
            System.out.println("" + currentPlayer.getPlayerName() + " now has " + currentPlayer.getPlayerScore() + " points.\n\n");
        }
    }

    private static void pause() {
        try {System.in.read(); }
        catch (Exception ex) {  }
    }
}
