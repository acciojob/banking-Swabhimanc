package com.driver;

public class CurrentAccount extends BankAccount{
    static String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        validateLicenseId();
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

    }

    public static void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        char[] chars = tradeLicenseId.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                if (i == chars.length - 1) {
                    // Last two characters are same, swap with first character
                    char temp = chars[0];
                    chars[0] = chars[i];
                    chars[i] = temp;
                } else {
                    // Swap with next character
                    char temp = chars[i];
                    chars[i] = chars[i + 1];
                    chars[i + 1] = temp;
                }
            }
        }
        tradeLicenseId = new String(chars);

    }

}
