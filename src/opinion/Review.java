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
		this.title = title; 
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
		
		String s = this.getWriter().getLogin() + " a attribué la note de " + this.getMark() + " à l'oeuvre intitulée this.getItem().getTitle()" + " par this.getItem().getAuthor()"; //à compléter
		return s; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
