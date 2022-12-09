package opinion;

import java.util.LinkedList;

public class Item {
	
	// ATTRIBUTES 
	private String title; 
	
	private String kind; 
	
	private LinkedList<Review> reviews; 
	
	// CONSTRUCTOR 
	public Item(String title, String kind) {
		this.title = title; 
		this.kind = kind; 
		this.reviews = new LinkedList<Review>(); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
