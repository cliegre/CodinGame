import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Solution {
	
	private static double calculateDistance(Position A, Position B) {
		//      x = (longitudeB - longitudeA) * cos ( (latitudeA + latitudeB) / 2);
		//      y = (latitudeB - latitudeA);
		//      d = racine(x2 + y2)*6371;
		double x = (B.m_dLongitude - A.m_dLongitude) * Math.cos( (A.m_dLatitude + B.m_dLatitude) / 2.0d);
		double y = B.m_dLatitude - A.m_dLatitude;
		return Math.sqrt(Math.pow(x, 2.0d) + Math.pow(y, 2.0d)) * 6371;
	}

    public static void main(String args[]) {
    	ArrayList<Defibrilateur> defibList = new ArrayList<Defibrilateur>();
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        in.nextLine();
        String LAT = in.next();

        Position userPosition = new Position(LON, LAT);
        
        in.nextLine();
        int N = in.nextInt();
        in.nextLine();
        
        double minDistance = -1.0d;
        int defibIdx = 0;
        
        for (int i = 0; i < N; i++) {
            Defibrilateur defib = new Defibrilateur(in.nextLine());
            defibList.add(defib);
            
            double dist = calculateDistance(userPosition, defib.m_cPosition);
            if (minDistance == -1.0d || (dist < minDistance)) {
            	minDistance = dist;
            	defibIdx = i;
            }
        }
    	
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        System.out.println(defibList.get(defibIdx).m_sName);
    }
}

class Defibrilateur {
	public Defibrilateur(String input) {
	    System.err.println("defib " + input);
		String[] tokens = input.split(";");
		assert(tokens.length == 6);
		String id = tokens[0];
		String name = tokens[1];
		String address = tokens[2];
		String tel = tokens[3];
		String longitude = tokens[4];
		String latitude = tokens[5];
		m_sID = id;
		m_sName = name;
		m_sAddress = address;
		m_sTel = tel;
		m_cPosition = new Position(longitude, latitude);
	}
	
	public Defibrilateur(String id, String name, String address, String tel, double longitude, double latitude) {
		m_sID = id;
		m_sName = name;
		m_sAddress = address;
		m_sTel = tel;
		m_cPosition = new Position(longitude, latitude);
	}
	
	public String m_sID;
	public String m_sName;
	public String m_sAddress;
	public String m_sTel;
	public Position m_cPosition;
}

class Position {
	// change ',' to '.' in string to be able to convert it into number
	public Position(String longitude, String latitude) {
		this(Double.parseDouble(longitude.replace(',', '.')), Double.parseDouble(latitude.replace(',', '.')));
	}
	
	public Position(double longitude, double latitude) {
		// switch from degree to radian
		// 360 degree = 2PI radians
		m_dLongitude = (longitude * 2 * Math.PI) / 360.0d;
		m_dLatitude = (latitude * 2 * Math.PI) / 360.0d;
	}
	
	public double m_dLongitude;
	public double m_dLatitude;
}
