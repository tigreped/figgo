package models;

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
	public ArrayList<String> roles;
	public String password;
	public double cardBalance;
	public Date cardBalanceTimestamp;

	private static final JacksonDBCollection<User, String> collection = Collections
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
	public static void removeUserRole(User user, String role) {
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
	public static void addUserRole(User user, String role) {
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
			// Check if balanceTimestamp is greater or equal to the timestamp of
			// the user's last cardTransaction
			ArrayList<CardTransaction> transactions = CardTransaction.getTransactionsPerUserFromDate(user.id,
					user.cardBalanceTimestamp);
			// Sum the amount of all recent transactions: 
			double sum = 0;
			if (transactions.size() > 0) {
				CardTransaction transaction = null;
				for (CardTransaction ct: transactions) {
					transaction = ct;
					sum += ct.amount;
				}	
				// Add the value to current balance
				updateCardBalance(user, sum);
				// Update balance timestamp according to last transaction:
				user.cardBalanceTimestamp = transaction.timestamp;
			}

			// Returns updated balance:
			return user.cardBalance;
		}
		return 0;
	}

	/**
	 * Updates the user balance retrieving current balance and adding new sum
	 * @param sum
	 */
	private static void updateCardBalance(User user, double sum) {
		user.cardBalance += sum ;		
	}	
}