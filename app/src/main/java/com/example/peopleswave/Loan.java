package com.example.peopleswave;

public class Loan {
    String name;
    String bank;
    String accountNo;
    String nic;
    String phone;
    String address;
    String amount;

    private String Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Loan(String id) {
        Id = id;
    }

    public Loan(){

    }
    public Loan(String name, String bank, String accountNo, String nic, String phone, String address, String amount) {
        this.name = name;
        this.bank = bank;
        this.accountNo = accountNo;
        this.nic = nic;
        this.phone = phone;
        this.address = address;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
