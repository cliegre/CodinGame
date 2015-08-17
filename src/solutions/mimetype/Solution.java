import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    public static String extension(String input) {
        System.err.println("extesion " + input);
        int dot = input.lastIndexOf(".");
        if (dot != -1) {
            String foundExt = input.substring(dot +1).toLowerCase();
            System.err.println("found ext " + foundExt);
            return foundExt;
        } else {
            return new String();
        }
    }

    public static void main(String args[]) {
        Hashtable<String, String> mimes = new Hashtable();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        in.nextLine();
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        in.nextLine();
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            System.err.println("file ext " + EXT);
            String MT = in.next(); // MIME type.
            mimes.put(EXT.toLowerCase(), MT);
            in.nextLine();
        }
        System.err.println(mimes.size());
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            String extension = extension(FNAME);
            if (! extension.isEmpty() && mimes.containsKey(extension)) {
                System.out.println(mimes.get(extension));
            } else {
                System.out.println("UNKNOWN");
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
    }
}