import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    public static String generateNextLine(String line) {
        ArrayList<Element> elements = parseLine(line);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.size(); i++) {
            Element el = elements.get(i);
            sb.append(el.number);
            sb.append(" ");
            sb.append(el.figure);
            sb.append(" ");
        }
        return sb.toString().trim(); // to remove the trailing whitespace
    }
    
    public static ArrayList<Element> parseLine(String line) {
        ArrayList<Element> ret = new ArrayList<Element>();
        String[] ints = line.split(" ");
        // init
        int numberOfFigureFound = 0;
        int figure = Integer.parseInt(ints[0]);
        ret.add(new Element(figure));
        // iterate
        for (int i = 1; i < ints.length; i++) {
            int curFigure = Integer.parseInt(ints[i]);
            if (curFigure == figure) { // still the same figure
                ret.get(numberOfFigureFound).increase();
            } else { // found a different figure
                ret.add(new Element(curFigure));
                figure = curFigure;
                numberOfFigureFound++;
            }
        }
        
        return ret;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int L = in.nextInt();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        // 1
        // 1 1 
        // 2 1
        // 1 2 1 1   // nombre chiffre
        // 1 1 1 2 2 1
        // 3 1 2 2 1 1
        // 1 3 1 1 2 2 2 1
        // 1 1 1 3 2 1 3 2 1 1
        String output = String.valueOf(R);
        
        while (L > 1) {
            output = generateNextLine(output);
            L--;
        }
        
        // parser la ligne
        // entréé par chiffre => pas bon car on préserve pas l'ordre => ArrayList => object => chiffre nombre
        // si on a deja ce chiffre on incrémente la quantité
        // a la fin on écrit
        
        System.out.println(output);
        
    }
}

class Element {
    public int number;
    public int figure;
    
    public Element(int figure) {
        this.figure = figure;
        this.number = 1;
    }
    
    public void increase() {
        this.number++;
    }
    
    public String toString() {
        return "figure " + figure + " number " + number;
    }
}
