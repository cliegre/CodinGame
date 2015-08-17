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
        boolean fired = false;

        // game loop
        while (true) {
            int spaceX = in.nextInt();
            int spaceY = in.nextInt();
            int fireAtX = -1;
            System.err.println("spaceX " + spaceX + " spaceY " + spaceY);
            int minHeightBetweenMountainTopAndShip = 10;
            for (int i = 0; i < 8; i++) {
                // represents the height of one mountain, from 9 to 0. Mountain heights are provided from left to right.
                int mountainH = in.nextInt();
                int distance = spaceY - mountainH;
                System.err.println("distance between M and S " + distance);
                if (distance < minHeightBetweenMountainTopAndShip) {
                    minHeightBetweenMountainTopAndShip = distance;
                    fireAtX = i;
                    System.err.println("minimum distance found " + distance + " firet At X " + i);
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            if (spaceX == fireAtX) {
                System.out.println("FIRE");        
            } else {
                System.out.println("HOLD"); // either:  FIRE (ship is firing its phase cannons) or HOLD (ship is not firing).
        
            }
        }
    }
}