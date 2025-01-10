package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;

/**
 * Defines the blueprint for transaction-related operations in a banking system.
 * Ensures consistency across financial transaction types.
 * 
 * Core Operations:
 * - Retrieve transaction amount, date, and unique identifier.
 */
public interface TransactionInterface {

    /**
     * Returns the monetary amount for the transaction.
     *
     * @return The transaction amount (non-negative).
     * @pre None
     * @post The amount is returned as a positive value; no state is modified.
     */
    double getAmount();

    /**
     * Returns the transaction date.
     *
     * @return A non-null Calendar object representing the transaction date and time.
     * @pre None
     * @post The date is returned without altering the transaction's state.
     */
    Calendar getDate();

    /**
     * Returns a unique identifier for the transaction.
     * @return A non-null, unique string identifier.
     * @pre None
     * @post The identifier is consistent and unique throughout the transaction's lifecycle.
     */
    String getTransactionID();
}
