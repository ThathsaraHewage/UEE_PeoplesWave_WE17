package com.example.peopleswave;

public class YourLoans {
    String amount,bank;

    public YourLoans(String amount, String bank) {
        this.amount = amount;
        this.bank = bank;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
