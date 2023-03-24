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

    public static void validateLicenseId() throws Exception
    {
        boolean isValid = true;
        char[] chars = tradeLicenseId.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                isValid = false;
                break;
            }
        }
        if (isValid)
        {
            return;
        }
        else
        {
            for (int i = 0; i < chars.length - 1; i++)
            {
                for (int j = i + 1; j < chars.length; j++)
                {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    isValid = true;
                    for (int k = 1; k < chars.length; k++)
                    {
                        if (chars[k] == chars[k - 1])
                        {
                            isValid = false;
                            break;
                        }
                    }
                    if (isValid)
                    {
                        tradeLicenseId = new String(chars);
                        return;
                    }
                    else
                    {
                        temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;
                    }
                }
            }
            throw new Exception("Valid License can not be generated");
        }
    }
}
