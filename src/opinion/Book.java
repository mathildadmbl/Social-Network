package opinion;

public class Book extends Item {
	
	// ATTRIBUTES 
	private String genre; 
	
	private int nbPages; 
	
	private String author; 
	
	// CONSTRUCTOR 
	public Book(String title, String genre, int nbPages, String author) {
		super(title, "book"); 
		this.genre = genre; 
		this.nbPages = nbPages; 
		this.author = author; 
	}
	
	//METHODS 
	
	public String getGenre() {
		return this.genre; 
	}
	
	public String getAuthor() {
		/**
	     * Get the author of the book in the <i>SocialNetwork</i>
	     * 
	     * @return the name of the author in the <i>SocialNetwork</i>
	     */
		return this.author; 
	}
	
	public int getNbPages() {
		/**
	     * Get the number of pages of the book in the <i>SocialNetwork</i>
	     * 
	     * @return the number of pages of the book in the <i>SocialNetwork</i>
	     */
		return this.nbPages; 
	}
	
	
	public String toString() {
		/**
	     * A <i>Book</i> is described at least by its title, its author and the number of pages. 
	     * 
	     * @return a <code>String</code> representing the <i>Book</i>, with at least
	     *         its title, its author and the number of pages.
	     */
		
		String s = "The book entitled " + this.getTitle() + " from the genre " + this.getGenre() + " and written by " + this.getAuthor() + " is " + this.getNbPages() + " pages long." ;
		s += super.toString(); 
		
		return s; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
