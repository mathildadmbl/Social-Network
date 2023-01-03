package opinion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Member {
	
	// ATTRIBUTES 
	private String login; 
	
	private String password; 
	
	private String description; 
	
	private Map<Item, Review> reviews; 
	
	
	//CONSTRUCTOR 
	public Member(String login, String password, String description) {
		
		this.login = login; 
		this.password = password; 
		this.description = description; //Biographie du membre sur le réseau
		this.reviews = new HashMap<Item, Review>(); 
	}
	
	//METHODS 
	public String getLogin() {
		/**
	     * Get the login of the member in the <i>SocialNetwork</i>
	     * 
	     * @return the login of the member in the <i>SocialNetwork</i>
	     */
		
		return this.login; 
	}
	
	public String getPassword() {
		/**
	     * Get the password of the member in the <i>SocialNetwork</i>
	     * 
	     * @return the password of the member in the <i>SocialNetwork</i>
	     */
		return this.password; 
	}
	
	public String getDescription() {
		/**
	     * Get the description of the member in the <i>SocialNetwork</i>
	     * 
	     * @return the description of the member in the <i>SocialNetwork</i>
	     */
		
		return this.description; 
	}
	
	public void changeLogin(String newLogin) {
		/**
	     * Change the login of the member in the <i>SocialNetwork</i>
	     * 
	     * @param new login to substitute the current one 
	     */
		
		this.login = newLogin; 
	}
	
	public void changePassword(String newPassword) {
		/**
	     * Change the password of the member in the <i>SocialNetwork</i>
	     * 
	     * @param new password to substitute the current one 
	     */
		
		this.password = newPassword; 
	}
	
	public void addReview(Item item, Review review) {
		/**
	     * Save a review written by the member in the <i>SocialNetwork</i> in the historic reviews (a dictionary). 
	     * 
	     * @param the item reviewed by the member 
	     * @param the review written by the member 
	     */
		this.reviews.put(item, review); 
		item.addReview(review);
		
	}
	
	public Map<Item, Review> getReviews() {
		/**
	     * Get the historic of reviews of the member in the <i>SocialNetwork</i>  
	     * 
	     * @return the historic of reviews of the member 
	     */
		
		return this.reviews; 
	}
	
	public String toString() {
		/**
	     * A <i>Member</i> is described at least by member's name and description. 
	     * 
	     * @return a <code>String</code> representing the <i>Member</i>, with at least
	     *         member's name and description.
	     */
		
		String s = "The member " + this.getLogin() + " has the following description : " + this.getDescription() + "\n";
	
		s+= "Here are all the comments he published : \n"; 
		
		Map<Item, Review> reviews = this.getReviews(); 
		
		for (Item item : reviews.keySet()) {
			s += "About : " + item.getTitle() + ", \n"; 
			s += reviews.get(item).getTitle() + "\n"; 
			s += this.getLogin() + " wrote : " + reviews.get(item).getComment() + "\n";
		}
		return s; 
	}

	public static void main(String[] args) {
		
		Member bob = new Member("bob", "password", "book lover"); 
		
		Book book1 = new Book("The Little Prince", "book", 96, "Antoine de Saint-Exupéry"); 
		String comment1 = "Le livre de mon enfance, je ne m'en lasse pas."; 
		
		Book book2 = new Book("Les Misérables", "book", 2598, "Victor Hugo"); 
		String comment2 = "Très long mais passionnant."; 
		
		Review review1 = new Review(bob, "Mon avis sur Le Petit Prince", 9, comment1, book1); 
		Review review2 = new Review(bob, "Mon avis sur Les Misérables", 7, comment2, book2); 
		
		bob.addReview(book1, review1);
		bob.addReview(book2, review2);
		
		System.out.println(bob.toString());
		System.out.println(book1.toString());
		System.out.println(book2.toString());

	}

}
