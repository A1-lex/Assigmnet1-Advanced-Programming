package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;
import java.util.UUID;

public abstract class BaseTransaction implements TransactionInterface {
    private double amount; // The transaction amount
    private Calendar date; // The transaction date
    private String transactionID; // The unique identifier for the transaction

    // Constructor to initialize the Transaction object
    public BaseTransaction(double amount, Calendar date) {
        this.amount = amount;
        this.date = date;
        this.transactionID = generateTransactionID();
    }

    // Method to get the transaction amount
    @Override
    public double getAmount() {
        return amount;
    }

    // Method to get the transaction date
    @Override
    public Calendar getDate() {
        return date;
    }

    // Method to get a unique identifier for the transaction
    @Override
    public String getTransactionID() {
        return transactionID;
    }

    // Abstract method to apply the transaction to a BankAccount
    public abstract void apply(BankAccount account);

    // Helper method to generate a unique identifier
    private String generateTransactionID() {
        return UUID.randomUUID().toString();
    }
}