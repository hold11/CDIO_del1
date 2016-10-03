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

import java.util.*;

public class Dice {
    private Random rand;

    private static int faceCount;

    public Dice() {
        rand = new Random();
    }

    public int rollDice() {
        return rand.nextInt(faceCount) + 1;
    }

    public static void setFaceCount(int _faceCount) {
        faceCount = _faceCount;
    }

}
