import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Arrays;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    public static long convertMayaNumber(ArrayList<MayaFigure> mNumber, Hashtable<MayaFigure, String> mayaToBase20, int mayaRadix) {
        StringBuilder sb = new StringBuilder();
        
        for (MayaFigure curFig : mNumber) {
            if (mayaToBase20.containsKey(curFig)) {
                sb.append(mayaToBase20.get(curFig));
            }
        }
        
        String ss = sb.toString();
        return Long.parseLong(ss, mayaRadix);
    }
    
    public static ArrayList<MayaFigure> convertNumberToMaya(long number, int mayaRadix, Hashtable<String, MayaFigure> base20ToMaya) {
        ArrayList<MayaFigure> output = new ArrayList<MayaFigure>();
        
        String resultInMayaBase20 = Long.toString(number, mayaRadix);
        for (int i = 0; i < resultInMayaBase20.length(); i++) {
            String positionNumber = resultInMayaBase20.substring(i, i + 1);
            if (base20ToMaya.containsKey(positionNumber)) {
                output.add(base20ToMaya.get(positionNumber));
            }
        }
        return output;
    }
    
    public static long operation(String operand, long first, long second) {
        if (operand.equals("+")) {
            return first + second;
        } else if (operand.equals("-")) {
            return first - second;
        } else if (operand.equals("*")) {
            return first * second;
        } else if (operand.equals("/")) {
            return first / second;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        // Init maya system
        MayaFigure.setFigureSize(L, H);
        
        String[] allMayaFigures = new String[H];
        for (int i = 0; i < H; i++) {
            String numeral = in.next();
            allMayaFigures[i] = numeral;
        }
        // now create all maya figures
        int mayaRadix = 20;
        Hashtable<MayaFigure, String> mayaToBase20 = new Hashtable<MayaFigure, String>();
        Hashtable<String, MayaFigure> base20ToMaya = new Hashtable<String, MayaFigure>();
        for (int i = 0; i < mayaRadix; i++) {
            String[] curFigure = new String[H];
            for (int j = 0; j < H; j++) { // extract the ith portion of size L
                String oneElementOfMayaDico = allMayaFigures[j].substring(i * L, i * L + L);
                curFigure[j] = oneElementOfMayaDico;
            }
            MayaFigure curMaya = new MayaFigure(curFigure);
            String base20 = Integer.toString(i, mayaRadix);
            mayaToBase20.put(curMaya, base20);
            base20ToMaya.put(base20, curMaya);
        }
        
        // first number in operation
        ArrayList<MayaFigure> numberOne = new ArrayList<MayaFigure>();
        ArrayList<String> oneFigure = new ArrayList<String>();
        int S1 = in.nextInt();
        //System.err.println("S1 lines " + S1);
        for (int i = 0; i < S1; i++) {
            String num1Line = in.next();
            oneFigure.add(num1Line);
            if (((i + 1) % H) == 0) {
                numberOne.add(new MayaFigure(oneFigure.toArray(new String[0])));
                oneFigure = new ArrayList<String>();
            }
        }
        
        long numberOneFromMaya = convertMayaNumber(numberOne, mayaToBase20, mayaRadix);
        
        // second number in operation
        ArrayList<MayaFigure> numberTwo = new ArrayList<MayaFigure>();
        oneFigure = new ArrayList<String>();
        int S2 = in.nextInt();
        for (int i = 0; i < S2; i++) {
            String num2Line = in.next();
            oneFigure.add(num2Line);
            if (((i + 1) % H) == 0) {
                numberTwo.add(new MayaFigure(oneFigure.toArray(new String[0])));
                oneFigure = new ArrayList<String>();
            }
        }
        
        long numberTwoFromMaya = convertMayaNumber(numberTwo, mayaToBase20, mayaRadix);
        
        // operation
        String operation = in.next();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        long result = operation(operation, numberOneFromMaya, numberTwoFromMaya);
        ArrayList<MayaFigure> res = convertNumberToMaya(result, mayaRadix, base20ToMaya);
        for (MayaFigure mf : res) {
            System.out.println(mf);
        }
    }
}

class MayaFigure {
	private static int L = 0;
	private static int H = 0;
	private String[] content;
	private int length = 0;

	public MayaFigure(String[] description) {
		if (description == null) {
			throw new IllegalArgumentException();
		} else if (description.length != H) {
			throw new IllegalArgumentException();
		} else {
			content = description;
			length = content.length;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		MayaFigure mf = (MayaFigure)obj;
		if (mf.content == null) {
			return false;
		}
		int l = mf.content.length;
		if (length != l) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			if ( ! content[i].equals(mf.content[i])) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(content);
	}
	
	public static void setFigureSize(int L, int H) {
		MayaFigure.L = L;
		MayaFigure.H = H;
	}
	
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    for (String s : content) {
	        sb.append(s);
	        sb.append("\n");
	    }
	    return sb.toString().trim();
	}
}