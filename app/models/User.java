package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;

public class User {

	@Id
	@ObjectId
	public String id;

	public String email;
	public String name;
	public ArrayList<String> roles = new ArrayList<String>();
	public String password;
	public double cardBalance;
	public Date cardBalanceTimestamp;
	
	private static final JacksonDBCollection<User, String> collection = models.Collections
			.getUserCollection();

	public static List<User> all() {
		return getCollection().find().toArray();
	}

	public static void create(User user) {
		user.cardBalanceTimestamp = new Date();
		getCollection().save(user);
	}

	public static void delete(String id) {
		User user = getCollection().findOneById(id);
		if (user != null)
			getCollection().remove(user);
	}

	public static User findByEmail(String email) {
		DBCursor<User> cursor = getCollection().find().is("email", email);
		if (cursor.hasNext()) {
			User user = cursor.next();
			return user;
		}
		return null;
	}
	
	public static User findById(String id) {
		return getCollection().findOneById(id);
	}

	public static User authenticate(String email, String password) {
		User user = findByEmail(email);
		if (user != null ) {
			if (user.password.equalsIgnoreCase(password)) {
				return user;
			}
		}	
		return null;
	}

	public static JacksonDBCollection<User, String> getCollection() {
		return collection;
	}

	public ArrayList<String> getRoles() {
		return roles;
	}

	/**
	 * Retrieve user's list of roles
	 * 
	 * @param username
	 * @return a list with the roles associated to the user
	 */
	public static ArrayList<String> getUserRoles(String username) {
		DBCursor<User> cursor = getCollection().find().is("email", username);
		if (cursor.hasNext()) {
			User user = cursor.next();
			return user.getRoles();
		}
		return null;
	}

	/**
	 * Remove role from user role list, if there is such a role and such a user.
	 * 
	 * @param user
	 * @param role
	 */
	public static void removeRole(User user, String role) {
		if (!user.equals(null)) {
			// If it finds such a role in the user roles
			if (user.roles.indexOf(role) != -1) {
				// remove it from its role list
				user.roles.remove(role);
				// update object on MongoDB
				getCollection().save(user);
			}
		}
	}

	/**
	 * Add role to user role list, if there is such a user
	 * 
	 * @param user
	 * @param role
	 */
	public static void addRole(String userId, String role) {
		User user = getCollection().findOneById(userId);
		// Check if the user is not null
		if (!user.equals(null)) {
			// Check for empty roles list
			if (user.roles.equals(null)) {
				user.roles = new ArrayList<String>();
				user.roles.add(role);
				getCollection().save(user);
			}
			// Check if role already exists
			else {
				if (!user.roles.contains(role)) {
					user.roles.add(role);
					getCollection().save(user);
				}
			}
		}
	}

	/**
	 * Remove role from user role list, if there is such a user and role
	 * 
	 * @param user
	 * @param role
	 */
	public static void removeRole(String userId, String role) {
		User user = getCollection().findOneById(userId);
		// Check if the user is not null
		if (!user.equals(null)) {
			// Check for empty roles list
			if (!user.roles.equals(null)) {
				if (user.roles.contains(role)) {
					user.roles.remove(role);
					getCollection().save(user);
				}
			}
		}
	}
	
	/**
	 * Retrieves user's balance from database, checks for more recent transactions
	 * and updates the balance if not updated (i.e., if there are card
	 * transactions with a timestamp more recent than the current balance timestemp)
	 * 
	 * @param user
	 * @return
	 */
	public static double getCardBalance(User user) {
		// Check if the user is not null
		if (!user.equals(null)) {
			// Update balance:
			updateCardBalance(user);
			return user.cardBalance;
		} // End null user condition
		return 0;
	}

	/**
	 * Updates the user balance retrieving current balance and adding new sum
	 * @param sum
	 */
	public static void updateCardBalance(User user, double sum) {
		user.cardBalance += sum ;
	}
	
	public static void updateCardBalance(User user) {
		// Check if balanceTimestamp is greater or equal to the timestamp of
		// the user's last cardTransaction
		ArrayList<CardTransaction> transactionsTo = CardTransaction.getTransactionsToUserFromDate(user.id,
				user.cardBalanceTimestamp);
		ArrayList<CardTransaction> transactionsFrom = CardTransaction.getTransactionsFromUserFromDate(user.id,
				user.cardBalanceTimestamp);
		// Sum the amount of all recent transactions: 
		double sum = 0;
		if (transactionsTo.size() > 0) {
			// Cards received:
			for (CardTransaction ct: transactionsTo) {
				if(user.cardBalanceTimestamp.before(ct.getTimestamp())) 
					user.cardBalanceTimestamp = ct.getTimestamp();
				sum += ct.amount;
			}
		}
		if (transactionsFrom.size() > 0) {
			// Cards given:
			for (CardTransaction ct: transactionsFrom) {
				if(user.cardBalanceTimestamp.before(ct.getTimestamp())) 
					user.cardBalanceTimestamp = ct.getTimestamp();
				sum -= ct.amount;
			}
		}	
		
		// Add the value to current balance
		updateCardBalance(user, sum);
		
		// Update balance:
		User.create(user);
	}
	
	/**
	 * Return the users's bank statement
	 * @param start
	 * @param end
	 * @return
	 */
	public CardStatement getCardStatement(String startDate, String endDate) {
		// Generate default point zero in time (Millenium bug).
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date startDateFormatted = new Date();
		Date endDateFormatted = new Date();
		try {
			startDateFormatted  = sdf.parse(startDate);
			endDateFormatted  = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return CardStatement.getCardStatement(id, startDateFormatted, endDateFormatted);
	}

	/** Getters and setters: */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}

	public Date getCardBalanceTimestamp() {
		return cardBalanceTimestamp;
	}

	public void setCardBalanceTimestamp(Date cardBalanceTimestamp) {
		this.cardBalanceTimestamp = cardBalanceTimestamp;
	}

	public void setRoles(ArrayList<String> roles) {
		this.roles = roles;
	}
}
