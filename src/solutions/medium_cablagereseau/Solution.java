import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    public static int indexOf(int[] input, int key, int from) {
        int l = input.length;
        for (int i = from + 1; i < l; i++) {
            if (input[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    public static int containsRepetition(int[] input) {
        int l = input.length;
        for (int i = 0; i < l - 1; i++) {
            if (input[i] == input[i + 1]) {
                return input[i];
            }
        }
        return -1;
    }
    
    public static int median(int[] input) {
        int median = 0;
        if (input != null && input.length > 0) {
            int N = input.length;
            int medianIdx = N / 2;
            //if (N % 2 == 0) {
            //    median = input[medianIdx] + input[medianIdx - 1] / 2;
            //} else {
            //    median = input[medianIdx];
            //}
            median = input[medianIdx];
        } else {
            return 0;
        }
        return median;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] Xs = new int[N];
        int[] Ys = new int[N];
        for (int i = 0; i < N; i++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            Xs[i] = X;
            Ys[i] = Y;
        }
        
        // SOLUTION 2
        Arrays.sort(Xs);
        Arrays.sort(Ys);
        int goodY = median(Ys);
        
        long Xsize = Xs[N - 1] - Xs[0];
        
        for (int i = 0; i < N; i++) {
            long deltaY = Math.abs(Ys[i] - goodY);
            Xsize += deltaY;
        }
        
        System.out.println(Xsize);
    }
}