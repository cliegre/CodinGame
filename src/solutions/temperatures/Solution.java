import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String TEMPS = in.nextLine(); // the N temperatures expressed as integers ranging from -273 to 5526

        System.err.println("INPUT STRING " + TEMPS);

        int min = 0;
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        if (N == 0) {
            System.out.println("0");
        } else {
            StringTokenizer st = new StringTokenizer(TEMPS);
            
            // first token
            min = Integer.parseInt(st.nextToken());
            System.err.println("parsed int " + min);

            // then compare
            for (int i = 1; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                System.err.println("parsed int " + temp);
                if (Math.abs(temp) < Math.abs(min)) {
                    min = temp;
                } else if (Math.abs(temp) == Math.abs(min)) {
                    if (min < temp) { // min was negative
                        min = temp;
                    }
                }
            }
            System.out.println(String.valueOf(min));
        }
    }
}