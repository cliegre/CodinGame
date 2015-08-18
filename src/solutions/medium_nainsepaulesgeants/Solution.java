import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    
    private static void addInfluence(String from, String to) {
		Person fromP;
		Person toP;
		if (all.containsKey(from)) {
			fromP = all.get(from);
		} else {
			fromP = new Person(from);
			all.put(from, fromP);
		}
		if (all.containsKey(to)) {
			toP = all.get(to);
		} else {
			toP = new Person(to);
			all.put(to, toP);
		}
		fromP.addChild(toP);
		toP.influence(fromP.getInfluence());
	}
	
	private static Hashtable<String, Person> all = new Hashtable<String, Person>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of relationships of influence
        for (int i = 0; i < n; i++) {
            int x = in.nextInt(); // a relationship of influence between two people (x influences y)
            int y = in.nextInt();
            System.err.println("x " + x + " y " + y);
            String xis = String.valueOf(x);
            String yis = String.valueOf(y);
            addInfluence(xis, yis);
        }

		int highestInfluence = 0;
		Iterator<Person> it = all.values().iterator();
		while (it.hasNext()) {
			Person p = it.next();
			highestInfluence = p.getInfluence() > highestInfluence ? p.getInfluence() : highestInfluence;
		}
		// Can't use the stream syntax as highestInfluence has to be updated
		//all.values().stream().forEach(p -> highestInfluence = p.getInfluence() > highestInfluence ? p.getInfluence() : highestInfluence);
		
		System.out.println(highestInfluence + 1);
    }
}

class Person
{
	private String name;
	private ArrayList<Person> children;
	private int influence;
	
	public Person(String name) {
		this.name = name;
		influence = 0;
		children = new ArrayList<Person>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addChild(Person p) {
		if ( ! children.contains(p)) {
			children.add(p);
		} else {
			System.err.println(p.getName() + " is already part of " + getName());
		}
	}
	
	public int getInfluence() {
		return influence;
	}
	
	public void influence(int inf) {
		int receivedInfluece = inf + 1;
		if (receivedInfluece > influence) {
			influence = receivedInfluece;
		}
		for (Person p : children) {
			p.influence(influence);
		}
	}
	
	@Override
	public String toString() {
		return name + ":" + influence;
	}
}