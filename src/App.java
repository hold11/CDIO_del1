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
    private static MP3 music = new MP3("assets/spilmusik.mp3");

    /**
     * This method executes the entire game.
     * @param args we don't use this........
     */
    public static void main(String[] args) {
        Dice.setFaceCount(6);
        DiceCup.setDiceCount(2);

        Player p1 = new Player();
        Player p2 = new Player();

        Field[] fields = { new Empty.Builder().build() };

        GUI.create(fields);

        GUI.addPlayer(p2.getPlayerName(), 0);
        GUI.addPlayer(p1.getPlayerName(), 0);

        GUI.displayChanceCard("");

        // Start Music
        if (args.length == 0)
            music.play();

        // Start the game
        while (!GameLogic.getPlayerHasWon()) {
            Player currentPlayer = Player.findPlayer(GameLogic.whoseTurnIsIt());

            GUI.getUserButtonPressed("\t\t          This turn goes to: " + currentPlayer.getPlayerName()
                    + "\n\t\t   "
                    + "Press 'the button', would you kindly?", "the button");

            int eyes[] = GameLogic.playTurn(currentPlayer);

            GUI.setDice(eyes[0], eyes[1]);
            GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerScore());
            System.out.println("\n" + currentPlayer.getPlayerName() + " rolled a " + eyes[0] + " and a " + eyes[1] + " giving " + GameLogic.calTotalScore(eyes, currentPlayer) + " points."
                    + "\n" + currentPlayer.getPlayerName() + " now has " + currentPlayer.getPlayerScore() + " points in total.\n\n");
            GUI.displayChanceCard(currentPlayer.getPlayerName() + " rolled " + GameLogic.calTotalScore(eyes, currentPlayer) + " points.");

            // When a player has reeched 40 points or more
            if(GameLogic.getPlayerHasWon()) {
                System.out.println("\n" + currentPlayer.getPlayerName() + " has won the game.");
                GUI.displayChanceCard(currentPlayer.getPlayerName() + " rolled " + GameLogic.calTotalScore(eyes, currentPlayer) + " points." + "<br>"+ "<br>"+ "<br>" + " YOU ARE WINNER!");

                // If the user wants to exit the game
                if (GUI.getUserButtonPressed("\t                      " + "Press 'Exit' to exit or 'Play again' to play again", "Exit" , "Play Again") == "Exit")
                {
                    music.close();
                    GUI.close();
                } else { // If the player wants to play again
                    // Reset everything
                    GameLogic.setPlayerHasWon(!true); // FW:FW:FW:FW:RE: THOUGHT YOU MIGHT GET A LAUGH OUT OF THIS!
                    for (Player p : Player.getPlayersList())
                        GUI.setBalance(p.getPlayerName(), 0);
                    Player.reset();

                    // Call the main method again, if the user wants to restart the game.
                    String[] _args = {"restart"};
                    main(_args);
                }
            }
        }
    }
}
