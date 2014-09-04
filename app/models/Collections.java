package models;

import net.vz.mongodb.jackson.JacksonDBCollection;
import play.modules.mongodb.jackson.MongoDB;

public class Collections {
	
	private static JacksonDBCollection<User, String> userCollection = MongoDB
			.getCollection("users", User.class, String.class);

	private static JacksonDBCollection<Role, String> roleCollection = MongoDB
			.getCollection("roles", Role.class, String.class);
	
	private static JacksonDBCollection<CardTransaction, String> cardTransactionCollection = MongoDB
			.getCollection("cardTransactions", CardTransaction.class, String.class);
	
	public static JacksonDBCollection<User, String> getUserCollection() {
		return userCollection;
	}
	
	public static JacksonDBCollection<Role, String> getRoleCollection() {
		return roleCollection;
	}
	
	public static JacksonDBCollection<CardTransaction, String> getCardTransactionCollection() {
		return cardTransactionCollection;
	}
}
