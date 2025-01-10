package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 * BaseTransaction Class
 * Represents an abstract base class for financial transactions.
 * Implements TransactionInterface to handle basic transaction details like amount, date, and ID.
 */
public abstract class BaseTransaction implements TransactionInterface {
    private final int amount;
    private final Calendar date;
    private final String transactionID;

    /**
     * Constructor for BaseTransaction.
     * Initializes the transaction with a specified amount and date, and generates a unique ID.
     *
     * @param amount - The transaction amount (must be positive).
     * @param date - The transaction date (must be a valid Calendar object).
     * @throws IllegalArgumentException if the amount is negative or date is null.
     */
    public BaseTransaction(int amount, @NotNull Calendar date) {
        if (amount < 0 || date == null) {
            throw new IllegalArgumentException("Invalid amount or date.");
        }
        this.amount = amount;
        this.date = (Calendar) date.clone();
        
        // Generate unique transaction ID using the timestamp and a random number
        String baseID = String.valueOf(date.getTimeInMillis());
        // Ensure the ID is long enough (8 digits) by padding with leading zeros if necessary
        baseID = String.format("%-8s", baseID).replace(' ', '0'); // Ensure 8 digits
        int uniq = (int) (Math.random() * 10000);
        transactionID = baseID.substring(0, 8) + "-" + uniq;
    }

    /**
     * Retrieves the transaction amount.
     * 
     * @return The transaction amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Retrieves a defensive copy of the transaction date.
     *
     * @return A cloned Calendar instance of the transaction date.
     */
    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    /**
     * Retrieves the unique transaction ID.
     *
     * @return The transaction ID.
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Abstract method to print transaction details.
     * To be implemented by subclasses to provide specific details.
     */
    public abstract void printTransactionDetails();

    /**
     * Abstract method to apply the transaction to a bank account.
     * Subclasses define specific behavior for the transaction.
     *
     * @param ba - The BankAccount object to apply the transaction to.
     * @throws InsufficientFundsException if there are not enough funds.
     */
    public abstract void apply(BankAccount ba) throws InsufficientFundsException;
}
