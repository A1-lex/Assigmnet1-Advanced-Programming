package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;
public interface TransactionInterface {
    // Method to get the transaction amount
    double getAmount();

    // Method to get the transaction date
    Calendar getDate();

    // Method to get a unique identifier for the transaction
    String getTransactionID();
}