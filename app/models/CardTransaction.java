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
	
	public CardTransaction() {
		
	}

	public CardTransaction(String originUserId, String destinyUserId, Date timestamp, double amount) {
		setOriginUserId(originUserId);
		setDestinyUserId(destinyUserId);
		setTimestamp(timestamp);
		setAmount(amount);
		CardTransaction.create(this);
	}
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
	 * Retrieve all card transactions made to a user from a given point in time forward.
	 * @param userId
	 * @param date
	 * @return
	 */
	public static ArrayList<CardTransaction> getTransactionsToUserFromDate(String userId, Date date) {
		DBCursor<CardTransaction> cursor = getCollection().find().is("destinyUserId", userId).greaterThan("timestamp", date);
		ArrayList<CardTransaction> transactions = new ArrayList<CardTransaction>();
		while (cursor.hasNext()) {
			transactions.add(cursor.next());
		}
		return transactions;
	}

	/**
	 * Retrieve all card transactions made from a given user from a given point in time forward.
	 * @param userId
	 * @param date
	 * @return
	 */
	public static ArrayList<CardTransaction> getTransactionsFromUserFromDate(String userId, Date date) {
		DBCursor<CardTransaction> cursor = getCollection().find().is("originUserId", userId).greaterThan("timestamp", date);
		ArrayList<CardTransaction> transactions = new ArrayList<CardTransaction>();
		while (cursor.hasNext()) {
			transactions.add(cursor.next());
		}
		return transactions;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the originUserId
	 */
	public String getOriginUserId() {
		return originUserId;
	}

	/**
	 * @param originUserId the originUserId to set
	 */
	public void setOriginUserId(String originUserId) {
		this.originUserId = originUserId;
	}

	/**
	 * @return the destinyUserId
	 */
	public String getDestinyUserId() {
		return destinyUserId;
	}

	/**
	 * @param destinyUserId the destinyUserId to set
	 */
	public void setDestinyUserId(String destinyUserId) {
		this.destinyUserId = destinyUserId;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
