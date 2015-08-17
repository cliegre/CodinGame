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
        int n = in.nextInt();
        in.nextLine();
        String vs = in.nextLine();
        System.err.println(vs);
        if (vs.isEmpty()) {
            System.out.println("0");           
        } else {
            String[] figures = vs.split(" ");
            int l = figures.length;
            int[] values = new int[l];
            for (int i = 0; i < l; i++) {
                values[i] = Integer.parseInt(figures[i]);
            }
            
            // SOLUTION 3
            int maxLoss = 0;
            int lastMax = values[0];
            int lastMin = values[0];
            
            for (int i = 1; i < l; i++) {
                int cur = values[i];
                int prev = values[i - 1];
                int delta = cur - prev;
                
                if (cur > lastMax) {
                    lastMax = cur;
                    lastMin = cur;
                } else if (delta < 0) { // phase de descente
                    if (cur < lastMin) {
                        lastMin = cur;
                        int currentLoss = lastMin - lastMax;
                        if (currentLoss < maxLoss) {
                            maxLoss = currentLoss;
                        }
                    }
                } else if (delta > 0) { // phase de remontée mais pas au dessus de last max
                    
                }
            }
            
            System.out.println(maxLoss);
            
            // SOLUTION 2
            //int max = values[0];
            //int[] maxesBehindIndex = new int[l];
            //for (int i = 0; i < l; i++) {
            //    if (values[i] > max) {
            //        max = values[i];
            //    }
            //    maxesBehindIndex[i] = max;
            //}
            
            //int min = values[l - 1];
            //int[] minsAfterIndex = new int[l];
            //for (int i = l - 1; i >= 0; i--) {
            //    if (values[i] < min) {
            //        min = values[i];
            //    }
            //    minsAfterIndex[i] = min;
            //}
            
            //int maxLoss = 0;
            //for (int i = 0; i < l; i++) {
            //    int idxLoss = minsAfterIndex[i] - maxesBehindIndex[i];
            //    if (idxLoss < maxLoss) {
            //        maxLoss = idxLoss;
            //    }
            //}
            
            //System.out.println(maxLoss);
            
            // SOLUTION 1
            //int[] diff = new int[l - 1];
            //for (int i = 0; i < l - 1; i++) {
            //    diff[i] = values[i + 1] - values[i];
            //}
            
            //int[] loss = new int[l - 1];
            //loss[0] = diff[0];
            //int maxLoss = 0;
            //for (int i = 1; i < l - 1; i++) {
            //    int curLoss = Math.min(diff[i], (loss[i - 1] + diff[i]));
            //    loss[i] = curLoss;
            //    if (curLoss < maxLoss) {
            //        maxLoss = curLoss;
            //    }
            //}
            //System.out.println(maxLoss);
        }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
    }
}