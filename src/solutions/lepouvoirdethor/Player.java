import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position
        int thorX = initialTX;
        int thorY = initialTY;

        // game loop
        while (true) {
            int remainingTurns = in.nextInt();
            
            String WestOrEast = new String();
            String NorthOrSouth = new String();
            
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            if (lightX > thorX) {
                WestOrEast = "E";
                thorX += 1;
            } else if (lightX < thorX) {
                WestOrEast = "W";
                thorX -= 1;
            }
            
            if (lightY > thorY) {
                NorthOrSouth = "S";
                thorY += 1;
            } else if (lightY < thorY) {
                NorthOrSouth = "N";
                thorY -= 1;
            }
            
            System.out.println(NorthOrSouth + WestOrEast); // A single line providing the move to be made: N NE E SE S SW W or NW
        }
    }
}