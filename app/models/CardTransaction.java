package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;

public class CardTransaction {

	@Id
	@ObjectId
	public String id;

	public String originUserId;
	public String destinyUserId;
	public Date timestamp;
	public double amount;
	

	public static List<CardTransaction> all() {
		return getCollection().find().toArray();
	}

	public static void create(CardTransaction transacion) {
		getCollection().save(transacion);
	}

	public static void delete(String id) {
		CardTransaction transacion = getCollection().findOneById(id);
		if (transacion != null)
			getCollection().remove(transacion);
	}

	public static CardTransaction findByName(String id) {
		DBCursor<CardTransaction> cursor = getCollection().find().is("id", id);
		if (cursor.hasNext()) {
			CardTransaction transacion = cursor.next();
			return transacion;
		}
		return null;
	}

	public static JacksonDBCollection<CardTransaction, String> getCollection() {
		return Collections.getCardTransactionCollection();
	}

	/**
	 * Retrieve a list with all transactions for a given user
	 * 
	 * @param userEmail
	 * @return
	 */
	public static ArrayList<CardTransaction> getTransacionsPerUser(String userId) {
		DBCursor<CardTransaction> cursor = getCollection().find().is("destinyUserId", userId);
		ArrayList<CardTransaction> transactions = new ArrayList<CardTransaction>();
		while (cursor.hasNext()) {
			transactions.add(cursor.next());
		}
		return transactions;
	}
	
	/**
	 * Retrieve all user's card transactions from a given point in time forward.
	 * @param userId
	 * @param date
	 * @return
	 */
	public static ArrayList<CardTransaction> getTransactionsPerUserFromDate(String userId, Date date) {
		DBCursor<CardTransaction> cursor = getCollection().find().is("destinyUserId", userId).greaterThan("timestamp", date);
		ArrayList<CardTransaction> transactions = new ArrayList<CardTransaction>();
		while (cursor.hasNext()) {
			transactions.add(cursor.next());
		}
		return transactions;
	}
}
