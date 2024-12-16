package ru.zubrilovskaya.different.stock;

public class Bot implements User{
    String name;
    Stock stock ;

    public Bot(String name, Stock stock) {
        this.name = name;
        setStocks(stock);
    }

    public void setStocks(Stock stock){
        this.stock = stock;
        stock.users.add(this);
    }


    @Override
    public void getMessage(Stock stock) {
        if(stock.cost < 70) System.out.println("надо покупать ORCL");
    }
}
