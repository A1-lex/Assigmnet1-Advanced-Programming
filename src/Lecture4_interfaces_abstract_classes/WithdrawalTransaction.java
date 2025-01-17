package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    // Constructor
    public WithdrawalTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
    }

    // Check if the withdrawal amount is valid
    private boolean isWithdrawalAmountValid(double amount) {
        return amount > 0; // Withdrawal must be positive
    }

    // Print transaction details
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction Details:");
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Transaction Date: " + getDate().getTime());
        System.out.println("Amount Withdrawn: " + getAmount());
    }

    // Override the apply method to process the withdrawal for a BankAccount
    @Override
    public void apply(@NotNull BankAccount account) {
        // Validate the withdrawal amount
        if (!isWithdrawalAmountValid(getAmount())) {
            throw new IllegalArgumentException("Invalid withdrawal amount. Must be greater than zero.");
        }

        // Check if there are sufficient funds in the account
        double currentBalance = account.getBalance();
        if (currentBalance >= getAmount()) {
            // Deduct the amount from the balance
            double newBalance = currentBalance - getAmount();
            account.setBalance(newBalance);

            // Print success message
            System.out.println("Withdrawal of " + getAmount() + " applied successfully. New balance: " + newBalance);
        } else {
            // Insufficient funds
            throw new IllegalStateException("Insufficient funds for withdrawal.");
        }
    }

    // Method to reverse the withdrawal
    public void reverse(@NotNull BankAccount account) {
        // Add the withdrawn amount back to the account balance
        double newBalance = account.getBalance() + getAmount();
        account.setBalance(newBalance);

        // Print success message
        System.out.println("Withdrawal of " + getAmount() + " reversed successfully. New balance: " + newBalance);
    }
}