package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {

    // Constructor
    public DepositTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
    }

    // Validate the deposit amount
    private boolean isDepositAmountValid(double amount) {
        return amount > 0; // Deposit must be a positive value
    }

    // Print transaction details
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction Details:");
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Transaction Date: " + getDate().getTime());
        System.out.println("Amount Deposited: " + getAmount());
    }

    // Override the apply method to process the deposit for a BankAccount
    @Override
    public void apply(@NotNull BankAccount account) {
        // Validate the deposit amount
        if (!isDepositAmountValid(getAmount())) {
            throw new IllegalArgumentException("Invalid deposit amount. Must be greater than zero.");
        }

        // Update the balance in the bank account
        double currentBalance = account.getBalance();
        double newBalance = currentBalance + getAmount();
        account.setBalance(newBalance);

        // Print success message
        System.out.println("Deposit of " + getAmount() + " applied successfully. New balance: " + newBalance);
    }

    // Revert method to enforce irreversibility
    public void revert(@NotNull BankAccount account) {
        throw new UnsupportedOperationException("Deposits are irreversible and cannot be reverted.");
    }
}