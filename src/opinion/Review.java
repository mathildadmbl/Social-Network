package opinion;

public class Review {
	
	// ATTRIBUTES 
	private Member member; 
	
	private String title; //Title of the review 
	
	private float mark; 
	
	private String comment; 
	
	private Item item; 
	
	// CONSTRUCTOR 
	public Review(Member member, String title, float mark, String comment, Item item) {
		
		this.member = member; 
		this.title = title; //title of the review 
		this.mark = mark; 
		this.comment = comment; 
		this.item = item; 
	}
	
	//METHODS 
	public float getMark() {
		/**
	     * Get the mark attributed by the review in the <i>SocialNetwork</i>
	     * 
	     * @return mark attributed by the review in the <i>SocialNetwork</i>
	     */
		return this.mark; 
	}
	
	public String getTitle() {
		/**
	     * Get the title of the review in the <i>SocialNetwork</i>
	     * 
	     * @return the title of the review in the <i>SocialNetwork</i>
	     */
		return this.title; 
	}

	public String getComment() {
		/**
	     * Get the comment written in the review in the <i>SocialNetwork</i>
	     * 
	     * @return the comment written in the review in the <i>SocialNetwork</i>
	     */
		return this.comment; 
	}
	
	public Member getWriter() {
		/**
	     * Get the author of the review in the <i>SocialNetwork</i>
	     * 
	     * @return the author of the review in the <i>SocialNetwork</i>
	     */
		return this.member; 
	}
	
	public Item getItem() {
		/**
	     * Get the item reviewed in the <i>SocialNetwork</i>
	     * 
	     * @return the item reviewed in the <i>SocialNetwork</i>
	     */
		return this.item; 
	}
	
	public String toString() {
		/**
	     * A <i>Review</i> is described at least by its title, its author, the item reviewed,
	     * the comment written and the mark attributed. 
	     * 
	     * @return a <code>String</code> representing the <i>Review</i>, its title, its author, the item reviewed,
	     * the comment written and the mark attributed.
	     */
		
		String s = "The user " + this.getWriter().getLogin() + " has given a mark of " + this.getMark() + " out of 10"; 
		
		s+= " to the item entitled " + this.getItem().getTitle(); 
		
				
		return s; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Item item1 = new Item("Avatar 2", "film"); 
		
		Member bob = new Member("bob", "motdepasse", "amateur de cinéma"); 
		String title1 = "Mon avis sur Avatar 2"; 
		String comment1 = "J'ai adoré ce film, je recommande !"; 
		
		Review review1 = new Review(bob, title1, 9, comment1, item1); 
		
		System.out.println(review1.toString());

	}

}
