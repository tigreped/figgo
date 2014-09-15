package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * POJO to store information about a single card statement
 * @author pedro
 *
 */
public class CardStatement {
	public static Date dateZero = new Date();
	double startBalance = 0;
	double endBalance = 0;
	ArrayList<CardTransaction> cardTransactions = new ArrayList<CardTransaction>();
	String userId;
	Date start;
	Date end;
	
	/**
	 * Class main constructor
	 * @param userId
	 * @param start
	 * @param end
	 */
	public CardStatement(String userId, Date start, Date end) {
		setUserId(userId);
		setStart(start);
		setEnd(end);
		getZeroPointInTime();
	}

	public static CardStatement getCardStatement(String userId,
			Date start, Date end) {
		CardStatement cardStatement = new CardStatement(userId, start, end);
		ArrayList<CardTransaction> cardTransactionsAux = null;		
		ArrayList<CardTransaction> statementCardTrancations = null;
		
		// 1) Calculate user balance from first transaction(point 0 in time) until the start date:
		double balance = 0;
		// Negative transactions reduce balance:
		cardTransactionsAux = CardTransaction.getTransactionsFromUserBetweenDate(userId, dateZero, start);
		for (CardTransaction c: cardTransactionsAux) {
			balance -= c.getAmount();
		}
		// Positive transactions increase balance:
		cardTransactionsAux = CardTransaction.getTransactionsToUserBetweenDate(userId, dateZero, start);
		for (CardTransaction c: cardTransactionsAux) {
			balance += c.getAmount();
		}
		cardStatement.setStartBalance(balance);

		// 2) Get user transactions from start date until end date
		
		// Transactions from user:
		statementCardTrancations = CardTransaction.getTransactionsFromUserBetweenDate(userId, start, end);
		
		// Update balance with transactions from the user:
		for (CardTransaction c: cardTransactionsAux) {
			balance -= c.getAmount();
		}
		
		// Transactions to user:
		cardTransactionsAux = CardTransaction.getTransactionsToUserBetweenDate(userId, start, end);
		
		// Update balance with transactions to the user:
		for (CardTransaction c: cardTransactionsAux) {
			balance += c.getAmount();
		}
		
		// Update final balance:
		cardStatement.setEndBalance(balance);
		
		// Add card transactions "to" the user to the card transactions "from" the user:
		statementCardTrancations.addAll(cardTransactionsAux);
		
		// Order transactions by ascending timestamp
		Collections.sort(statementCardTrancations, new Comparator<CardTransaction>() {
	        @Override
	        public int compare(CardTransaction cardTransaction1, CardTransaction cardTransaction2)
	        {
	            return  cardTransaction1.timestamp.compareTo(cardTransaction2.timestamp);
	        }
	    });
		
		cardStatement.setCardTransactions(statementCardTrancations);
		return cardStatement;
	}
	
	
	public void getZeroPointInTime() {
		// Generate default point zero in time (Millenium bug).
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dateZero = new Date();
		try {
			dateZero = sdf.parse("01/01/2000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public double getStartBalance() {
		return startBalance;
	}

	public void setStartBalance(double startBalance) {
		this.startBalance = startBalance;
	}

	public ArrayList<CardTransaction> getCardTransactions() {
		return cardTransactions;
	}

	public void setCardTransactions(
			ArrayList<CardTransaction> cardTransactions) {
		this.cardTransactions = cardTransactions;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public double getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(double endBalance) {
		this.endBalance = endBalance;
	}
}