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
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        
        System.err.println("N steps " + N);
        
        int minX = 0;
        int maxX = W;
        int minY = 0;
        int maxY = H;
        int curX = X0;
        int curY = Y0;

        // game loop
        while (true) {
            String BOMB_DIR = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            
            // L or R in BOMB_DIR => change X
            // U or D in BOMB_DIR => change Y
            if (BOMB_DIR.indexOf('U') != -1) {
                maxY = curY;
                curY = ((maxY - minY) / 2) + minY;
            } else if (BOMB_DIR.indexOf('D') != -1) {
                minY = curY;
                curY = ((maxY - minY) / 2) + minY;
            }
            
            if (BOMB_DIR.indexOf('L') != -1) {
                maxX = curX;
                curX = ((maxX - minX) / 2) + minX;
            } else if (BOMB_DIR.indexOf('R') != -1) {
                minX = curX;
                curX = ((maxX - minX) / 2) + minX;
            }

            System.out.println("" + curX + " " + curY); // the location of the next window Batman should jump to.
        }
    }
}