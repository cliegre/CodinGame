import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int road = in.nextInt(); // the length of the road before the gap.
        int gap = in.nextInt(); // the length of the gap.
        int platform = in.nextInt(); // the length of the landing platform.

        int safeSpot = road + gap;

        // game loop
        while (true) {
            int speed = in.nextInt(); // the motorbike's speed.
            int coordX = in.nextInt(); // the position on the road of the motorbike.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            if (coordX >= safeSpot) { // on a sauté
                System.out.println("SLOW");
            } else if (coordX < road) { // on est avant le saut
                // il faut que la vitesse soit la vitesse de gap + 1 et qu'on y arrive pile sur road - 1
                if (speed == gap + 1) { // bonne vitesse
                    if (coordX == road - 1) {
                        System.out.println("JUMP");
                    } else {
                        System.out.println("WAIT");
                    }
                } else if (speed > gap + 1) {
                    System.out.println("SLOW");
                } else if (speed < gap + 1) {
                    System.out.println("SPEED");
                }
            }
        }
    }
}