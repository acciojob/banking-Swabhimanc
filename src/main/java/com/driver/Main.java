package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount acc1 = new BankAccount("Swabhiman", 17403.1,0.0);
        acc1.generateAccountNumber(2,9);
        acc1.deposit(354.2);
        acc1.withdraw(27000.2);
        System.out.println(acc1.getAccountNumber());
    }
}