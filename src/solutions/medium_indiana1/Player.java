import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {
    
    private static String TOP = new String("TOP");
    private static String LEFT = new String("LEFT");
    private static String RIGHT = new String("RIGHT");
    private static String BOTTOM = new String("BOTTOM");
    
    private static ArrayList<Tile> dictionnary = new ArrayList<Tile>();
    
    public static void fillDictionnary() {
        Tile t0 = new Tile();
        dictionnary.add(t0);
        Tile t1 = new Tile();
        t1.setValidRoute("LEFT", "BOTTOM");
        t1.setValidRoute("TOP", "BOTTOM");
        t1.setValidRoute("RIGHT", "BOTTOM");
        dictionnary.add(t1);
        Tile t2 = new Tile();
        t2.setValidRoute("LEFT", "RIGHT");
        t2.setValidRoute("RIGHT", "LEFT");
        dictionnary.add(t2);
        Tile t3 = new Tile();
        t3.setValidRoute("TOP", "BOTTOM");
        dictionnary.add(t3);
        Tile t4 = new Tile();
        t4.setValidRoute("TOP", "LEFT");
        t4.setValidRoute("RIGHT", "BOTTOM");
        t4.setInvalidInput("LEFT");
        dictionnary.add(t4);
        Tile t5 = new Tile();
        t5.setValidRoute("LEFT", "BOTTOM");
        t5.setValidRoute("TOP", "RIGHT");
        t5.setInvalidInput("RIGHT");
        dictionnary.add(t5);
        Tile t6 = new Tile();
        t6.setValidRoute("LEFT", "RIGHT");
        t6.setValidRoute("RIGHT", "LEFT");
        t6.setInvalidInput("TOP");
        dictionnary.add(t6);
        Tile t7 = new Tile();
        t7.setValidRoute("TOP", "BOTTOM");
        t7.setValidRoute("RIGHT", "BOTTOM");
        dictionnary.add(t7);
        Tile t8 = new Tile();
        t8.setValidRoute("LEFT", "BOTTOM");
        t8.setValidRoute("RIGHT", "BOTTOM");
        dictionnary.add(t8);
        Tile t9 = new Tile();
        t9.setValidRoute("LEFT", "BOTTOM");
        t9.setValidRoute("TOP", "BOTTOM");
        dictionnary.add(t9);
        Tile t10 = new Tile();
        t10.setValidRoute("TOP", "LEFT");
        t10.setInvalidInput("LEFT");
        dictionnary.add(t10);
        Tile t11 = new Tile();
        t11.setValidRoute("TOP", "RIGHT");
        t11.setInvalidInput("RIGHT");
        dictionnary.add(t11);
        Tile t12 = new Tile();
        t12.setValidRoute("RIGHT", "BOTTOM");
        dictionnary.add(t12);
        Tile t13 = new Tile();
        t13.setValidRoute("LEFT", "BOTTOM");
        dictionnary.add(t13);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        in.nextLine();
        
        System.err.println("W " + W + " H " + H);
        
        int[][] map = new int[W][H];
        
        for (int i = 0; i < H; i++) {
            String LINE = in.nextLine(); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            System.err.println("LINE " + i + " IS " + LINE);
            String[] ints = LINE.split(" ");
            for (int j = 0; j < W; j++) {
                map[j][i] = Integer.parseInt(ints[j]);
            }
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).
        in.nextLine();
        
        fillDictionnary();

        // game loop
        while (true) {
            int XI = in.nextInt();
            int YI = in.nextInt();
            String POS = in.next();
            in.nextLine();

            int idx = map[XI][YI];
            System.err.println("IDX OF XI " + XI + " YI " + YI + " IS " + idx + " INCOMING FROM " + POS);
            String output = dictionnary.get(map[XI][YI]).getOutput(POS);
            System.err.println("output " + output);
            
            if (output.equals(LEFT)) {
                System.out.println("" + (XI - 1) + " " + YI);
            } else if (output.equals(RIGHT)) {
                System.out.println("" + (XI + 1) + " " + YI);
            } else if (output.equals(BOTTOM)) {
                System.out.println("" + XI + " " + (YI + 1));
            } else {
                // MERDUM
            }
        }
    }
}

class Tile {
    public Hashtable<String, String> routes;
    public ArrayList<String> nRoutes;
    
    public Tile() {
        routes = new Hashtable<String, String>();
        nRoutes = new ArrayList<String>();
    }
    
    public void setValidRoute(String input, String output) {
        routes.put(input, output);
    }
    
    public void setInvalidInput(String invalid) {
        nRoutes.add(invalid);
    }
    
    public String getOutput(String input) {
        if (routes.containsKey(input)) {
            return routes.get(input);
        } else {
            return new String();
        }
    }
}
