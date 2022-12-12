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
	
	// METHODS 
	public String getTitle() {
		/**
	     * Get the title of the item in the <i>SocialNetwork</i>
	     * 
	     * @return the title of the item in the <i>SocialNetwork</i>
	     */
		return this.title; 
	}
	
	public String getKind() {
		 /**
	     * Get the kind of the item in the <i>SocialNetwork</i>
	     * 
	     * @return the kind of the item in the <i>SocialNetwork</i>
	     */
		return this.kind; 
	}
	
	public LinkedList<Review> getReviews() {
		/**
	     * Get a list of the reviews given to the item in the <i>SocialNetwork</i>
	     * 
	     * @return a list of the reviews given to the item in the <i>SocialNetwork</i>
	     */
		return this.reviews; 
	}

	
	public float getScore() {
		/**
	     * Get the mean of the marks given to the item in the <i>SocialNetwork</i>
	     * 
	     * @return the mean of the marks given in the <i>SocialNetwork</i>
	     */
		
		LinkedList<Review> reviews = this.getReviews(); 
		float mean = 0; 
		
		for (Review review : reviews) {
			mean += review.getMark(); 
		}
		
		mean = mean/reviews.size(); 
		
		return mean; 
		
	}
	
	public void addReview(Review review) {
		/**
	     * Add a review to an item in the <i>SocialNetwork</i>
	     * 
	     * @param a review 
	     */
		
		this.reviews.add(review); 
	}
	
	public String toString() {
		
		int nbReviews = this.reviews.size(); 
		
		String s = " It received " + nbReviews + " reviews and an average mark of " + this.getScore();
		
		return s; 
	}

	public static void main(String[] args) {
		
		String title1 = "The Little Prince"; 
		String kind1 = "book";
		String author1 = "Antoine de Saint-Exupéry"; 
		
		Book book1 = new Book(title1, kind1, 96, author1); 
		
		System.out.println(book1.toString()); 
		

	}

}
