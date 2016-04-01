package com.example1;

/**
 * Created by wunul on 01-04-2016.
 */
public class Account {

    String name;
    double balance;

    public Account(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }
    private void validateAmount(double amount){
        if(amount < 0) {
            throw new IllegalArgumentException("Valid amount should be specified");
        }
    }
    private void checkBalanceFirst(double amount) throws Exception{
        if(amount>this.balance){
            throw new Exception("Insuffcient Balance in the account");
        }
    }
    protected double withdraw(double amount) throws Exception {
        validateAmount(amount);
        checkBalanceFirst(amount);
        this.balance -= amount;
        return balance;
    }

    public double getBalanceAmount() {
        return this.balance;
    }

    public double deposit(double amount) {
        validateAmount(amount);
        this.balance = amount + this.balance;
        return this.balance;
    }
}
