package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        // Test case for BankAccount
        BankAccount account = new BankAccount("John Doe", 5000, 1000);
        if (account.getBalance() != 5000) {
            throw new AssertionError("Initial balance should be 5000");
        }
        account.deposit(2000);
        if (account.getBalance() != 7000) {
            throw new AssertionError("Balance should be 7000 after deposit");
        }
        account.withdraw(1500);
        if (account.getBalance() != 5500) {
            throw new AssertionError("Balance should be 5500 after withdrawal");
        }
        try {
            account.withdraw(5000);
            throw new AssertionError("InsufficientBalanceException not thrown");
        } catch (Exception e) {
            // test passed
        }
        try {
            account.generateAccountNumber(3, 30);
            throw new AssertionError("AccountNumberGenerationException not thrown");
        } catch (Exception e) {
            // test passed
        }

// Test case for CurrentAccount
//        CurrentAccount currentAccount = new CurrentAccount("GOOGLE", 8000, "ABC123");
//        if (!currentAccount.getTradeLicenseId().equals("ABC123")) {
//            throw new AssertionError("Trade license id should be ABC123");
//        }
//        CurrentAccount.validateLicenseId();
//        if (currentAccount.getTradeLicenseId().equals("ABC123")) {
//            throw new AssertionError("Trade license id should be changed after validation");
//        }
//        currentAccount.withdraw(4000);
//        if (currentAccount.getBalance() != 4000) {
//            throw new AssertionError("Balance should be 4000 after withdrawal");
//        }
//        currentAccount.deposit(3000);
//        if (currentAccount.getBalance() != 7000) {
//            throw new AssertionError("Balance should be 7000 after deposit");
//        }
//        try {
//            CurrentAccount.validateLicenseId();
//            throw new AssertionError("ValidLicenseGenerationException not thrown");
//        } catch (Exception e) {
//            // test passed
//        }

// Test case for SavingsAccount
        SavingsAccount savingsAccount = new SavingsAccount("XYZ Bank", 7000, 0.02, 5000, 500);
        if (savingsAccount.getBalance() != 7000) {
            throw new AssertionError("Initial balance should be 7000");
        }
        if (savingsAccount.getRate() != 0.02) {
            throw new AssertionError("Interest rate should be 0.02");
        }
        if (savingsAccount.getMinimumBalance() != 5000) {
            throw new AssertionError("Minimum balance should be 5000");
        }
        if (savingsAccount.getMaxWithdrawalLimit() != 500) {
            throw new AssertionError("Maximum withdrawal limit should be 500");
        }
        savingsAccount.withdraw(300);
        if (savingsAccount.getBalance() != 6700) {
            throw new AssertionError("Balance should be 6700 after withdrawal");
        }
        try {
            savingsAccount.withdraw(600);
            throw new AssertionError("MaximumWithdrawLimitExceededException not thrown");
        } catch (Exception e) {
            // test passed
        }
        try {
            savingsAccount.withdraw(10000);
            throw new AssertionError("InsufficientBalanceException not thrown");
        } catch (Exception e) {
            // test passed
        }

// Test case for StudentAccount
        StudentAccount studentAccount = new StudentAccount("Alice Smith", 2000, "Harvard University");
        if (!studentAccount.getInstitutionName().equals("ABC University")) {
            throw new AssertionError("Institution name should be ABC University");
        }
        studentAccount.deposit(500);
        if (studentAccount.getBalance() != 2500) {
            throw new AssertionError("Balance should be 2500");
        }
    }
}