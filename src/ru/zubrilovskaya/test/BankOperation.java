package ru.zubrilovskaya.test;
public class BankOperation {
    private String name;
    private int sum;
    private BankOperation balance;
    public BankOperation(String name, int sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName(){
        return name;
    }
    public int getSum(){
        return sum;
    }

    public String toString(){
        return name +": " + sum;
    }
}
