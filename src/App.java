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
    }
}
