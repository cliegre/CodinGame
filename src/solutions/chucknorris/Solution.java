import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    private static String ZERO = new String("00");
    private static String ONE = new String("0");
    private static String SPACE = new String(" ");
    
    private static String parseBinaryString(String input) {
        ArrayList<String> setOfUnary = new ArrayList();
        int length = input.length();
        int idx = 0;
        int fromIndex = 0;
        char first = input.charAt(0);
        boolean isZero = first == '0' ? true : false;
        while (idx < length && idx != -1) {
            idx = input.indexOf(isZero ? '1' : '0', fromIndex); // if it was 0 we search for first 1 and vice versa.
            String s = new String();
            if (idx == -1) {
                s = input.substring(fromIndex);
            } else {
                s = input.substring(fromIndex, idx);
            }
            setOfUnary.add(s);
            fromIndex = idx;
            isZero = !isZero; // if we were searching for 0, now search for 1
        }
        
        StringBuilder output = new StringBuilder();
        for (String s : setOfUnary) {
            output.append(toUnary(s));
            output.append(SPACE);
        }
        
        return output.toString();
    }
    
    private static String toUnary(String input) {
        if (input.length() > 0) {
            char first = input.charAt(0);
            return toUnarySequence(first, input.length());
        } else {
            return input;
        }
    }
    
    // 100101
    
    private static String toUnarySequence(char zeroOrOne, int number) {
        StringBuilder sb = new StringBuilder();
        if (zeroOrOne == '0') {
            sb.append(ZERO);
        } else {
            sb.append(ONE);
        }
        sb.append(SPACE);
        for (int i = 0; i < number; i++) {
            sb.append("0");
        }
        return sb.toString();
    }
    
    
    static String toBitString(int x, int bits) {
        String bitString = Integer.toBinaryString(x);
        int size = bitString.length();
        StringBuilder sb = new StringBuilder( bits );
        if (bits > size) {
            for (int i = 0; i < bits - size; i++) {
                sb.append('0');
            }
            sb.append(bitString);
        } else {
            sb = sb.append( bitString.substring(size-bits, size) );
        }
        return sb.toString();
    }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        
        System.err.println(MESSAGE);

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        StringBuilder sb = new StringBuilder();
        byte[] content = MESSAGE.getBytes();
        for (byte b : content) {
            String binaryRepresentation = toBitString((int)b, 7);
            sb.append(binaryRepresentation);
        }
        
        System.out.println(parseBinaryString(sb.toString()).trim());
    }
}