package ru.zubrilovskaya.test;
public class BankOperation {
    private String name;
    private int sum;
    private BankOperation balance;
    public BankOperation(String name, int sum) {
        this.name = name;
        setSum(sum);
    }
    public void setSum (int sum){
        if (sum < 0) throw new IllegalArgumentException("sum must be positive");
        this.sum = sum;
    }
    public int getSum(){
        return sum;
    }
    public String toString(){
        return name +": " + sum;
    }
}
