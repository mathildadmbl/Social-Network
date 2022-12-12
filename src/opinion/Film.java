package opinion;

public class Film extends Item {
	
	// ATTRIBUTES 
	private String director; 
	
	private String scenarist; 
	
	private float duration; 
	
	// CONSTRUCTOR 
	public Film(String title, String kind, String director, String scenarist, float duration) {
		
		super(title, kind); 
		this.director = director; 
		this.scenarist = scenarist; 
		this.duration = duration; 
	}
	
	// METHODS 
	
	public String getDirector() {
		/**
	     * Get the director of the film in the <i>SocialNetwork</i>
	     * 
	     * @return the name of the director of the film in the <i>SocialNetwork</i>
	     */
		return this.director; 
	}
	
	public String getScenarist() {
		/**
	     * Get the scenarist of the film in the <i>SocialNetwork</i>
	     * 
	     * @return the name of the scenarist of the film in the <i>SocialNetwork</i>
	     */
		return this.scenarist; 
	}
	
	public float getDuration() {
		/**
	     * Get the duration of the film in the <i>SocialNetwork</i>
	     * 
	     * @return the duration of the film in the <i>SocialNetwork</i>
	     */
		return this.duration; 
	}
	
	
	public String toString() {
		/**
	     * A <i>Film</i> is described at least by its title, its director and scenarist and its duration. 
	     * 
	     * @return a <code>String</code> representing the <i>Film</i>, with at least
	     *         its title, its director and scenarist and its duration. 
	     */
		
		String s = "The film entitled " + this.getTitle() + " directed by " + this.getDirector() + " and scenarized by " + this.getScenarist() + " is " + this.getDuration() + " hours long. ";
		s += super.toString(); 
		
		return s; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
