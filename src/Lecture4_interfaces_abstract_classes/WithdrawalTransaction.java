package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

/**
 * Represents a withdrawal transaction in the banking system.
 * Extends BaseTransaction to handle withdrawal operations.
 */
public class WithdrawalTransaction extends BaseTransaction {
    private boolean isApplied = false;  // Tracks if the withdrawal was successfully applied.

    /**
     * Constructs a WithdrawalTransaction with the specified amount and date.
     * @param amount The withdrawal amount (must be positive).
     * @param date   The transaction date (must not be null).
     * @throws IllegalArgumentException if the amount is negative or the date is null.
     */
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (date == null) {
            throw new IllegalArgumentException("Transaction date cannot be null.");
        }
    }

    /**
     * Validates if the given amount is positive.
     * @param amount The amount to validate.
     * @return true if the amount is positive, false otherwise.
     */
    private boolean isValidAmount(double amount) {
        return amount > 0;
    }

    /**
     * Prints the details of the withdrawal transaction.
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction Details:");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
    }

    /**
     * Applies the withdrawal to the specified bank account, deducting a transaction fee.
     * @param bankAccount The bank account to update.
     * @throws InsufficientFundsException if the account balance is insufficient.
     */
    @Override
    public void apply(BankAccount bankAccount) throws InsufficientFundsException {
        if (bankAccount == null) {
            throw new IllegalArgumentException("Bank account cannot be null.");
        }

        double currentBalance = bankAccount.getBalance();
        double transactionFee = 2.0;  // Fixed transaction fee

        if (currentBalance >= getAmount() + transactionFee) {
            bankAccount.setBalance(currentBalance - getAmount() - transactionFee);
            isApplied = true;
            System.out.println("Withdrawal of " + getAmount() + " applied. Fee: " + transactionFee + ". New Balance: " + bankAccount.getBalance());
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal and fee.");
        }
    }

    /**
     * Attempts to apply the withdrawal with exception handling.
     * @param bankAccount The bank account to update.
     */
    public void applyWithExceptionHandling(BankAccount bankAccount) {
        try {
            apply(bankAccount);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Withdrawal application attempt completed.");
        }
    }

    /**
     * Reverses the withdrawal if it was successfully applied.
     * @param bankAccount The bank account to update.
     * @return true if the reversal was successful, false otherwise.
     */
    public boolean reverse(BankAccount bankAccount) {
        if (isApplied) {
            bankAccount.setBalance(bankAccount.getBalance() + getAmount());
            System.out.println("Withdrawal of " + getAmount() + " reversed. New Balance: " + bankAccount.getBalance());
            isApplied = false;  // Reset the applied flag
            return true;
        } else {
            System.out.println("No withdrawal to reverse.");
            return false;
        }
    }
}
