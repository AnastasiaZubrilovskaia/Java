package ru.zubrilovskaya.test;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int balance;
    private List<BankOperation> operations = new ArrayList<>();
    public BankAccount(int balance){
        setBalance(balance);
    }
    public void setBalance(int balance){
        if (balance < 0) throw new IllegalArgumentException("Balance must be positive");
        this.balance = balance;
    }
    public int getBalance(){
        return balance;
    }
    public void refill(int sum){
        if (sum < 0) throw new IllegalArgumentException("Sum must be positive");
        balance+=sum;
        operations.add(new BankOperation("Refill", sum));
    }
    public void withdrawing(int sum){
        if (sum < 0) throw new IllegalArgumentException("Sum must be positive");
        if (balance < sum ) throw new IllegalArgumentException("Insufficient funds");
        balance-=sum;
        operations.add(new BankOperation("Withdrawing", sum));
    }
    public String toString(){
        return "balance: " + balance + ", history: " + operations;
    }
}
