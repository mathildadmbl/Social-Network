package opinion;

public class Member {
	
	// ATTRIBUTES 
	private String login; 
	
	private String password; 
	
	private String description; 
	
	//private LinkedList<Review> reviews; 
	
	
	//CONSTRUCTOR 
	public Member(String login, String password, String description) {
		
		this.login = login; 
		this.password = password; 
		this.description = description; //Biographie du membre sur le réseau
		//this.reviews = new LinkedList<Review>(); 
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
	
	public String toString() {
		/**
	     * A <i>Member</i> is described at least by member's name and description. 
	     * 
	     * @return a <code>String</code> representing the <i>Member</i>, with at least
	     *         member's name and description.
	     */
		
		String s = "Il s'agit du membre " + this.getLogin() + " dont la description est : " + this.getDescription(); 
		return s; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
