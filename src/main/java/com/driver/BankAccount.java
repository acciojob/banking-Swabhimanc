package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    private String accountNumber;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
        this.accountNumber = "";
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        if (digits <= 0 || sum < 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        int maxDigitSum = 9 * digits;
        if (sum > maxDigitSum) {
            throw new Exception("Account Number can not be generated");
        }
        int[] accountNumber = new int[digits];
        int remainingSum = sum;
        for (int i = 0; i < digits; i++) {
            int maxDigitValue = Math.min(remainingSum, 9);
            if (i == digits - 1) {
                if (remainingSum == 0) {
                    accountNumber[i] = 0;
                } else {
                    accountNumber[i] = remainingSum;
                }
            } else {
                accountNumber[i] = (int) (Math.random() * (maxDigitValue + 1));
            }
            remainingSum -= accountNumber[i];
        }
        if (remainingSum != 0) {
            throw new Exception("Account Number can not be generated");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            sb.append(accountNumber[i]);
        }
        return sb.toString();
    }

    public void deposit(double amount) {
        balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getMinimumBalance() {
        return minBalance;
    }
}