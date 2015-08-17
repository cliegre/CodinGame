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
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            int Pi = in.nextInt();
            a[i] = Pi;
        }
        
        Arrays.sort(a);
        
        int min = -1;
        
        // search the min difference
        for (int i = 0; i < a.length - 1; i++) {
            int delta = a[i + 1] - a[i];
            if (min == -1 || (delta < min)) {
                min = delta;
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(min);
    }
}