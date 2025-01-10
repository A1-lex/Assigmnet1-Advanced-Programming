package Lecture4_interfaces_abstract_classes;

/**
 * BankAccount Class
 * Represents a simple bank account with a monetary balance.
 * Provides methods to get and set the balance with non-negative values.
 */

public class BankAccount {
    private double balance;

    /**
     * Constructor for BankAccount.
     * Initializes the account with a non-negative initial balance.
     * @param balance - The initial balance (must be non-negative).
     * @throws IllegalArgumentException if the balance is negative.
     */

    public BankAccount(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = balance;
    }

    /**
     * Retrieves the current balance of the account.
     *
     * @return The current balance.
     */

    public double getBalance() {
        return balance;
    }

    /**
     * Sets a new balance for the account.
     * @param balance - The new balance (must be non-negative).
     * @throws IllegalArgumentException if the new balance is negative.
     */

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }
}

