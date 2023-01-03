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
	
	
	
	private LinkedList<Member> members;
	
	private LinkedList<Item> items;
	
	
	
	public SocialNetwork() {
		/**
		 * Constructeur d'un réseau social permettant l'initialisation des attributs de ce réseau social.
		 */
		this.members = new LinkedList<Member>();
		this.items = new LinkedList<Item>();
	}
	
	public LinkedList<Member> getMembers() {
		/**
		 * In order to display de list of members of this Social Network
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
	
	@Override
	public int nbMembers() {
		/**
		 * Calculte and return the number of account created in the social network
		 * @return Size of members LinkedList()
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
		
		for (Member member:this.getMembers()) {
			if (member.getLogin() == login) {
				if (member.getPassword() == password) {
					return member;
				}
				else {
					throw new NotMemberException(password);
				}
			}
		}
		throw new NotMemberException(login);
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
		
		if (!(belongsToSocialNetwork(login))) {             // if the new member is already in the member list
			throw new MemberAlreadyExistsException(login);
		}
		else {
			members.add(newMember);
		}
	}

	@Override
	public void addItemFilm(String login, String password, String title, String kind, String director, String scenarist,
			int duration) throws BadEntryException, NotMemberException, ItemFilmAlreadyExistsException {
		// TODO 
	}

	@Override
	public void addItemBook(String login, String password, String title, String kind, String author, int nbPages)
			throws BadEntryException, NotMemberException, ItemBookAlreadyExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public float reviewItemFilm(String login, String password, String title, float mark, String comment)
			throws BadEntryException, NotMemberException, NotItemException {
		Member member = getMember(login, password);
		Review review = new Review(null, title, mark, comment, null);
		return 0;
	}

	@Override
	public float reviewItemBook(String login, String password, String title, float mark, String comment)
			throws BadEntryException, NotMemberException, NotItemException {
		// TODO Auto-generated method stub
		return 0;
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
