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
        int N = in.nextInt();
        int C = in.nextInt();
        //System.err.println("N " + N + " C " + C);
        int[] contribsMax = new int[N];
        int somme = 0;
        for (int i = 0; i < N; i++) {
            int B = in.nextInt();
            contribsMax[i] = B;
            //System.err.println("contrib " + i + " : " + B);
            somme += B;
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        if (somme < C) {
            System.out.println("IMPOSSIBLE");
        } else {
            int remaining = C;
            int guy = 0;
            
            Arrays.sort(contribsMax);
            
            do {
                int remainingGuys = N - guy;
                int contribMeanRemaining = remaining / remainingGuys;
                //System.err.println("remaining mean " + contribMeanRemaining);
                
                int currentContrib = contribsMax[guy];
                //System.err.println("current contrib " + currentContrib);
                
                if (contribMeanRemaining < currentContrib) {
                    System.out.println(contribMeanRemaining);
                } else {
                    contribMeanRemaining = currentContrib;
                    System.out.println(currentContrib);
                }
                
                remaining -= contribMeanRemaining;
                guy++;
            } while (guy < N);
        }
    }
}
