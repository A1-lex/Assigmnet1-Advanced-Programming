package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount account = new BankAccount(500.0);

        // Create a withdrawal transaction
        Calendar date = Calendar.getInstance();
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(100.0, date);

        // Print transaction details
        withdrawal.printTransactionDetails();

        // Apply the withdrawal transaction
        try {
            withdrawal.apply(account);
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }

        // Print the updated balance
        System.out.println("Account Balance After Withdrawal: " + account.getBalance());

        // Reverse the withdrawal
        try {
            withdrawal.reverse(account);
        } catch (Exception e) {
            System.out.println("Reversal Failed: " + e.getMessage());
        }

        // Print the final balance
        System.out.println("Final Account Balance: " + account.getBalance());
    }
}