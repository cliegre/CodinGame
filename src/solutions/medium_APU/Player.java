import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // the number of cells on the X axis
        in.nextLine();
        int H = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        
        ArrayList<String> horizLines = new ArrayList<String>(H);
        ArrayList<String> vertiLines = new ArrayList<String>(W);
        
        for (int i = 0; i < H; i++) {
            String oneHorizLine = in.nextLine();
            //System.err.println("one horiz line " + oneHorizLine);
            horizLines.add(oneHorizLine);
        }
        
        for (int i = 0; i < W; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < H; j++) {
                sb.append(horizLines.get(j).charAt(i));    
            }
            String oneVertLine = sb.toString();
            //System.err.println("one vert line " + oneVertLine);
            vertiLines.add(oneVertLine);
        }
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("0 0 1 0 0 1"); // Three coordinates: a node, its right neighbor, its bottom neighbor
        
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                StringBuilder sb = new StringBuilder();
                String currentHorizLine = horizLines.get(j);
                String currentVertiLine = vertiLines.get(i);
                if (currentHorizLine.charAt(i) == '0') {
                    System.err.println("NODE AT " + i + " " + j);
                    sb.append(i);
                    sb.append(' ');
                    sb.append(j);
                    sb.append(' ');
                    // check node a droite => use currentHorizLine
                    int nodeOnMyRightIdx = currentHorizLine.indexOf('0', i + 1);
                    if (nodeOnMyRightIdx == -1) {
                        sb.append("-1 -1");
                    } else {
                        sb.append(nodeOnMyRightIdx);
                        sb.append(' ');
                        sb.append(j);
                    }
                    sb.append(' ');
                    // check node under => use vertiLine
                    int nodeUnderMeIdx = currentVertiLine.indexOf('0', j + 1);
                    if (nodeUnderMeIdx == - 1) {
                        sb.append("-1 -1");
                    } else {
                        sb.append(i);
                        sb.append(' ');
                        sb.append(nodeUnderMeIdx);
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }
}