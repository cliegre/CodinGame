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
        int L = in.nextInt();
        in.nextLine();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        ArrayList<String> ASCII = new ArrayList(H);
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            ASCII.add(ROW);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        ArrayList<String> answers = new ArrayList(H);
        for (int i = 0; i < H; i++) {
            answers.add(new String());
        }
        
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            // retrouver l'ascii code ==> index 
            int indexOfChar = 26; // ? default character
            // si c'est autre chose que A-Z prendre le point interrogation
            int asciiOfChar = (int)c;
            System.err.println("ASCII OF CHAR " + asciiOfChar);
            if (asciiOfChar >= 65 && asciiOfChar <= 90) { // [a-z]
                indexOfChar = asciiOfChar - 65;
            }
            
            if (asciiOfChar >= 97 && asciiOfChar <= 122) { // [A-Z])
                indexOfChar = asciiOfChar - 97;
            }
            System.err.println("index of char " + indexOfChar);
            
            for (int j = 0; j < H; j++) {
                String ans = answers.get(j);
                ans += ASCII.get(j).substring(indexOfChar * L, (indexOfChar + 1) * L);
                System.err.println("ANSWER FOR LINE " + j + " NOW CONTAINS " + ans);
                answers.set(j, ans);
            }
        }

        for (int i = 0; i < H; i++) {
            System.out.println(answers.get(i));
        }
    }
}