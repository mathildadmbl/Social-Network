package opinion;

import java.util.LinkedList;

import exceptions.*;

/**
	 * What is a social network without structuration and organization. We propose a solution in which people 
	 * can mark films and books with some reviews. Those people are identied and repertoried in the attribute 
	 * members as a LinkedList.
	 * 
	 * @author math & hippo
	 * 
	 */
public class SocialNetwork implements ISocialNetwork {
	

	// ATTRIBUTES
	private LinkedList<Member> members;
	
	private LinkedList<Item> items;
	
	

	// CONSTRUCTOR 
	public SocialNetwork() {
		/**
		 * Constructeur d'un réseau social permettant l'initialisation des attributs de ce réseau social.
		 */
		this.members = new LinkedList<Member>();
		this.items = new LinkedList<Item>();
	}
	
	public LinkedList<Member> getMembers() {
		/**
		 * In order to display the list of members of this Social Network
		 * @return <code>members</code>
		 */
		return this.members;
	}
	

	public LinkedList<Item> getItems() {
		/**
		 * In order to display de list of items of this Social Network
		 * @return items List of items reviewed in this social network
		 */
		return this.items;
	}

	public LinkedList<String> getLogins() {
		/**
		 * Get the list of the logins of the members in the Social Network 
		 * @return a list of the logins of the members in the Social Network 
		 */
		LinkedList<String> member_logins = new LinkedList<String>(); 
		for (Member member : this.getMembers()) {
			member_logins.add(member.getLogin()); 
		} 
		
		return member_logins; 

	}
	

	public boolean belongsToSocialNetwork(String login) {
		/**
		 * Check if a user is a member of the Social Network, according to its login 
		 * @return true if the user belongs to the Social Network, else false. 
		 */
		
		LinkedList<String> members_logins = this.getLogins(); 
		for (String l : members_logins) {
			if (login.trim().equalsIgnoreCase(l.trim())) return true; 
		} return false; 
	}
	
	public LinkedList<String> getPasswords() {
		/**
		 * Get the list of the passwords of the members in the Social Network 
		 * @return a list of the passwords of the members in the Social Network 
		 */
		LinkedList<String> member_passwords = new LinkedList<String>(); 
		for (Member member : this.getMembers()) {
			member_passwords.add(member.getPassword()); 
		} 
		
		return member_passwords; 
	}
	
	public boolean rightPassword(String login, String password) {
		/**
		 * Check if the password matches  
		 * @return true if the password is correct, else false.
		 */
		
		LinkedList<Member> members = this.getMembers(); 
		String rightPassword = ""; 
		
		for (Member m : members) {
			if (m.getLogin() == login) {
				rightPassword = m.getPassword(); 
			} break; 
		} return password == rightPassword; 
		
	}
	

	public boolean itemAlreadyExists(String title, String kind) {
		/**
		 * Check if an item exists in the Social Network 
		 * @param the title of the item 
		 * @param the kind of the item 
		 * @return true if the item is registered, else false
		 */
		
		LinkedList<Item> items = this.getItems(); 
		
		for (Item i : items) {
			if ((title.trim().toLowerCase() == i.getTitle().toLowerCase()) && (kind == i.getKind())) return true; 
		} return false; 
	}
	
	
	public Item getItem(String title, String kind) {
		/**
		 * Search for an Item by his title and his kind
		 * @param title, the title of the item researched
		 * @param kind, the kind of the item researched
		 * @return item researched
		 */
		LinkedList<Item> items = this.getItems(); 
		
		for (Item i : items) {
			if ((title.trim().toLowerCase() == i.getTitle().toLowerCase()) && (kind == i.getKind())) return i; 
		}
		return null;
	}
	
	
	@Override
	public int nbMembers() {
		/**
		 * Calculate and return the number of accounts created in the social network
		 * @return the number of members in the Social Network
		 */
		return this.members.size();
	}
	
	@Override
	public int nbFilms() {
		/**
		 * Calculate and return the number of films reviewed in the social network
		 * @return result The number of films created
		 */
		int result = 0;
		for (int i = 0; i<this.items.size(); i++) {
			if (items.get(i) instanceof Film) result++;
		}
		return result;
	}
	
	@Override
	public int nbBooks() {
		/**
		 * Calculate and return the number of books reviewed in the social network
		 * @return result The number of books created
		 */
		int result = 0;
		for (int i = 0; i<this.items.size(); i++) {
			if (items.get(i) instanceof Book) result++;
		}
		return result;
	}
	

	public Member getMember(String login, String password) throws BadEntryException, NotMemberException {
		/**
		 * Gives the member associated to a given combo login password
		 * 
		 * @param login Username asked
		 * @param password Password supposed to correspond to the username
		 * @return a instance of the class Member that matches with the given arguments
		 */
		for (Member member:this.getMembers()) {
			if (member.getLogin() == login) {
				if (member.getPassword() == password) {
					return member;
				}
			}
		}
		return null;
	}
	
	
	@Override
	public void addMember(String login, String password, String description)
			throws BadEntryException, MemberAlreadyExistsException {
		/**
		 * Adds a member to the Social Network
		 * 
		 * @param login Username of the new member
		 * @param password Password of the new member
		 * @param description Bio of the new member
		 * @throws BadEntryException
		 */
		if (   !(login instanceof String) || login.replaceAll(" ", "").length() <= 1   ) 
			throw new BadEntryException(login);
		if (   !(password instanceof String) || password.trim().length() < 4   )
			throw new BadEntryException(password);
		if (   !(description instanceof String)   )
			throw new BadEntryException(description);

		
		Member newMember = new Member(login, password, description);
		
		if (belongsToSocialNetwork(login)) {             // if the new member is already in the member list
			throw new MemberAlreadyExistsException(login);
		}
		else {
			members.add(newMember);
		}
	}
	

	@Override
	public void addItemFilm(String login, String password, String title, String kind, String director, String scenarist,
			int duration) throws BadEntryException, NotMemberException, ItemFilmAlreadyExistsException {
		
		/**
		 * Adds a film to the Social Network 
		 * 
		 * @param login, the username of the member
		 * @param password, the password of the member
		 * @param title, the title of the film 
		 * @param kind, the kind of the film 
		 * @param director, the director of the film 
		 * @param scenarist, the scenarist of the film 
		 * @param duration, the duration the film 
		 */
		
		// BAD ENTRY EXCEPTIONS 
		boolean login_checked = (login instanceof String) && login.replaceAll(" ", "").length() >= 1; 
		boolean password_checked = (password instanceof String) && password.trim().length() >= 4; 
		boolean title_checked = (title instanceof String) && title.replaceAll(" ", "").length() >= 1; 
		boolean kind_checked = (kind instanceof String); 
		boolean director_checked = (director instanceof String); 
		boolean scenarist_checked = (scenarist instanceof String); 
		boolean duration_checked = (duration > 0); 
		
		if (!login_checked) { throw new BadEntryException(login); }
		else if (!password_checked) { throw new BadEntryException(password); }
		else if (!title_checked) { throw new BadEntryException(title); }
		else if (!kind_checked) { throw new BadEntryException(kind); }	
		else if (!director_checked) { throw new BadEntryException(director); }
		else if (!scenarist_checked) { throw new BadEntryException(scenarist); }
		else if (!duration_checked) { throw new BadEntryException(Integer.toString(duration)); }
		
		// NOT MEMBER EXCEPTIONS 
		if (!this.belongsToSocialNetwork(login)) { throw new NotMemberException(login); }
		if (!this.rightPassword(login, password)) { throw new NotMemberException(password); }
		
		// FILM ALREADY EXISTS EXCEPTION 
		if (this.itemAlreadyExists(title, "film")) { throw new ItemFilmAlreadyExistsException(); }
		
		// IF NO EXCEPTION RAISED WE CREATE THE ITEM FILM AND ADD IT TO THE SOCIAL NETWORK 
		Film film = new Film(title, kind, director, scenarist, duration); 
		this.items.add(film); 
	}
	

	@Override
	public void addItemBook(String login, String password, String title, String kind, String author, int nbPages)
			throws BadEntryException, NotMemberException, ItemBookAlreadyExistsException {
		/**
		 * Adds a member to the Social Network
		 * 
		 * @param login, the username of the member
		 * @param password, the password of the member
		 * @param title, the title of the book 
		 * @param kind, the kind of the book 
		 * @param author, the name of the author of the book 
		 * @param nbPages, the number of pages of the book 
		 */
		
		// BAD ENTRY EXCEPTIONS 
		boolean login_checked = (login instanceof String) && login.replaceAll(" ", "").length() >= 1; 
		boolean password_checked = (password instanceof String) && password.trim().length() >= 4; 
		boolean title_checked = (title instanceof String) && title.replaceAll(" ", "").length() >= 1; 
		boolean kind_checked = (kind instanceof String); 
		boolean author_checked = (author instanceof String); 
		boolean nbPages_checked = (nbPages > 0); 
		
		if (!login_checked) { throw new BadEntryException(login); }
		else if (!password_checked) { throw new BadEntryException(password); }
		else if (!title_checked) { throw new BadEntryException(title); }
		else if (!kind_checked) { throw new BadEntryException(kind); }	
		else if (!author_checked) { throw new BadEntryException(author); }
		else if (!nbPages_checked) { throw new BadEntryException(Integer.toString(nbPages)); }
		
		// NOT MEMBER EXCEPTIONS 
		if (!this.belongsToSocialNetwork(login)) { throw new NotMemberException(login); }
		if (!this.rightPassword(login, password)) { throw new NotMemberException(password); }
		
		// BOOK ALREADY EXISTS EXCEPTION 
		if (this.itemAlreadyExists(title, "book")) { throw new ItemBookAlreadyExistsException(); }
				
		// IF NO EXCEPTION RAISED WE CREATE THE ITEM BOOK AND ADD IT TO THE SOCIAL NETWORK 
		Book book = new Book(title, kind, nbPages, author); 
		this.items.add(book); 
	}

	@Override
	public float reviewItemFilm(String login, String password, String title, float mark, String comment)
			throws BadEntryException, NotMemberException, NotItemException {
		/**
		 * Adds a review to a film
		 * 
		 * @param login, the username of the member
		 * @param password, the password of the member
		 * @param title, the title of the film 
		 * @param mark, the mark given to the film
		 * @param comment, the commentary attached to the review
		 */
		
		boolean login_checked = (login instanceof String) && login.replaceAll(" ", "").length() >= 1; 
		boolean password_checked = (password instanceof String) && password.trim().length() >= 4; 
		boolean title_checked = (title instanceof String) && title.replaceAll(" ", "").length() >= 1; 
		boolean mark_checked = (0.0 <= mark && mark <= 5.0); 
		boolean comment_checked = (comment instanceof String); 
		
		// BAD ENTRY EXCEPTION
		if (!login_checked) { throw new BadEntryException(login); }
		else if (!password_checked) { throw new BadEntryException(password); }
		else if (!title_checked) { throw new BadEntryException(title); }
		else if (!mark_checked) { throw new BadEntryException(Float.toString(mark)); }
		else if (!comment_checked) { throw new BadEntryException(comment); }
		
		// NOT MEMBER EXCEPTION
		if (!this.belongsToSocialNetwork(login)) throw new NotMemberException(login);
		if (this.rightPassword(login, password)) throw new NotMemberException(password);
		
		// NOT ITEM EXCEPTION
		Item item = this.getItem(title, "film");
		if (item == null) throw new NotItemException(title);
		
		// IF ANY EXCEPTION OCCURS
		Member member = getMember(login, password);
		Review review = new Review(member, title, mark, comment, item);
		item.addReview(review);
		return item.getScore();
	}

	@Override
	public float reviewItemBook(String login, String password, String title, float mark, String comment)
			throws BadEntryException, NotMemberException, NotItemException {
		/**
		 * Adds a review to a book
		 * 
		 * @param login, the username of the member
		 * @param password, the password of the member
		 * @param title, the title of the book 
		 * @param mark, the mark given to the book
		 * @param comment, the commentary attached to the review
		 */
		
		boolean login_checked = (login instanceof String) && login.replaceAll(" ", "").length() >= 1; 
		boolean password_checked = (password instanceof String) && password.trim().length() >= 4; 
		boolean title_checked = (title instanceof String) && title.replaceAll(" ", "").length() >= 1; 
		boolean mark_checked = (0.0 <= mark && mark <= 5.0); 
		boolean comment_checked = (comment instanceof String); 
		
		// BAD ENTRY EXCEPTION
		if (!login_checked) { throw new BadEntryException(login); }
		else if (!password_checked) { throw new BadEntryException(password); }
		else if (!title_checked) { throw new BadEntryException(title); }
		else if (!mark_checked) { throw new BadEntryException(Float.toString(mark)); }
		else if (!comment_checked) { throw new BadEntryException(comment); }
		
		// NOT MEMBER EXCEPTION
		if (!this.belongsToSocialNetwork(login)) throw new NotMemberException(login);
		if (this.rightPassword(login, password)) throw new NotMemberException(password);
		
		// NOT ITEM EXCEPTION
		Item item = this.getItem(title, "book");
		if (item == null) throw new NotItemException(title);
		
		// IF ANY EXCEPTION OCCURS
		Member member = getMember(login, password);
		Review review = new Review(member, title, mark, comment, item);
		item.addReview(review);
		return item.getScore();
	}

	@Override
	public LinkedList<String> consultItems(String title) throws BadEntryException {
		/**
		 * Return a list of possible titles corresponding to a guessed title
		 * 
		 * @param title Title guessed
		 * 
		 * @return s List of possible titles in the database
		 */
		LinkedList<String> s = new LinkedList<String>();
		try {
			for (Item item:items) if (item.getTitle().contains(title)) s.add(item.getTitle());
		}
		catch (Exception e) {
			System.out.println("Error indefined: " + e);
			e.printStackTrace();
		}
		return s;
	}
	
	public static void main(String[] args) {
		SocialNetwork sn = new SocialNetwork();
	}

}
