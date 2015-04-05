package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import util.Constants;
import util.Facade;

/**
 * POJO to store information about a single card statement
 * 
 * @author pedro
 * 
 */
public class CardStatement {
	private static Date dateZero = null;
	double startBalance = 0;
	double endBalance = 0;
	ArrayList<CardTransaction> cardTransactions = new ArrayList<CardTransaction>();
	String userId;
	Date start;
	Date end;

	/**
	 * Class main constructor
	 * 
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

	/**
	 * This method returns a full card statement based on the start and end
	 * dates provided as the period of the required statement
	 * 
	 * @param userId
	 * @param start
	 * @param end
	 * @return
	 */
	public static CardStatement getCardStatement(String userId, Date start,
			Date end) {
		CardStatement cardStatement = new CardStatement(userId, start, end);
		ArrayList<CardTransaction> statementCardTrancations = null;

		// 1) Calculate user balance from first transaction(point 0 in time)
		// until the start date:
		double balance = 0;

		// Negative transactions reduce balance:
		statementCardTrancations = CardTransaction
				.getTransactionsFromUserBetweenDate(userId, dateZero, start);
		for (CardTransaction c : statementCardTrancations) {
			balance -= c.getAmount();
		}

		// Positive transactions increase balance:
		statementCardTrancations = CardTransaction
				.getTransactionsToUserBetweenDate(userId, dateZero, start);
		for (CardTransaction c : statementCardTrancations) {
			balance += c.getAmount();
		}

		cardStatement.setStartBalance(balance);

		// 2) Get user transactions from start date until end date

		// Transactions from user:
		statementCardTrancations = CardTransaction
				.getTransactionsFromUserBetweenDate(userId, start, end);

		// Update balance with transactions from the user and add transaction
		// cardStatements:
		for (CardTransaction c : statementCardTrancations) {
			balance -= c.getAmount();
			cardStatement.getCardTransactions().add(c);
		}

		// Transactions to user:
		statementCardTrancations = CardTransaction
				.getTransactionsToUserBetweenDate(userId, start, end);

		// Update balance with transactions to the user and add transaction
		// cardStatements:
		for (CardTransaction c : statementCardTrancations) {
			balance += c.getAmount();
			cardStatement.getCardTransactions().add(c);
		}

		// Update final balance:
		cardStatement.setEndBalance(balance);

		// receive both "from" and "to" transactions:
		statementCardTrancations = cardStatement.getCardTransactions();

		// Sort transactions by ascending timestamp
		Collections.sort(statementCardTrancations,
				new Comparator<CardTransaction>() {
					@Override
					public int compare(CardTransaction cardTransaction1,
							CardTransaction cardTransaction2) {
						return cardTransaction1.timestamp
								.compareTo(cardTransaction2.timestamp);
					}
				});

		cardStatement.setCardTransactions(statementCardTrancations);

		return cardStatement;
	}

	/**
	 * Returns the startDate Date as a String with a simple date format
	 * dd/MM/yyyy
	 * 
	 * @return
	 */
	public String getFormattedStartDate() {
		return Facade.getFormattedDate(getStart());
	}

	/**
	 * Returns the endDate Date as a String with a simple date format dd/MM/yyyy
	 * 
	 * @return
	 */
	public String getFormattedEndDate() {
		return Facade.getFormattedDate(getEnd());
	}

	/**
	 * This method is supposed to represent the system's starting point in time,
	 * arbitrarily set to Jan 1st 2000.
	 */
	public void getZeroPointInTime() {
		dateZero = Facade
				.formatDate(Constants.TIME_ZERO, Constants.DATE_FORMAT);
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

	public void setCardTransactions(ArrayList<CardTransaction> cardTransactions) {
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