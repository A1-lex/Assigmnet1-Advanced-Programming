package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

/**
 * Represents a deposit transaction in the banking system.
 * Extends BaseTransaction to handle deposits to bank accounts.
 */
public class DepositTransaction extends BaseTransaction {

    /**
     * Constructs a DepositTransaction with a specified amount and date.
     *
     * @param amount The deposit amount (must be positive).
     * @param date   The transaction date (must not be null).
     * @throws IllegalArgumentException if the amount is negative or the date is null.
     */
    public DepositTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        if (date == null) {
            throw new IllegalArgumentException("Transaction date cannot be null.");
        }
    }

    /**
     * Validates the deposit amount.
     *
     * @param amt The deposit amount to validate.
     * @return true if the amount is greater than 0, false otherwise.
     */
    private boolean isValidAmount(double amt) {
        return amt > 0;
    }

    /**
     * Prints the details of the deposit transaction.
     * Includes the amount, date, and transaction ID.
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction Details:");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
    }

    /**
     * Applies the deposit transaction to the specified bank account.
     *
     * @param bankAccount The bank account to update.
     * @throws IllegalArgumentException if the deposit amount is invalid.
     */
    @Override
    public void apply(BankAccount bankAccount) {
        if (bankAccount == null) {
            throw new IllegalArgumentException("Bank account cannot be null.");
        }

        if (isValidAmount(getAmount())) {
            double newBalance = bankAccount.getBalance() + getAmount();
            bankAccount.setBalance(newBalance);
            System.out.println("Deposit of " + getAmount() + " applied. New Balance: " + bankAccount.getBalance());
        } else {
            System.out.println("Invalid deposit amount: " + getAmount());
        }
    }
}
