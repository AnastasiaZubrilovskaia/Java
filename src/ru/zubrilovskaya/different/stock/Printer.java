package ru.zubrilovskaya.different.stock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Printer implements User{
    String name;
    List<Stock> stocks = new ArrayList<>();

    public Printer(String name, List<Stock> stocks) {
        this.name = name;
        setStocks(stocks);
    }

    public void setStocks(List<Stock> stocks){
        for(Stock st: stocks){
            st.users.add(this);
        }
        this.stocks.addAll(stocks);
    }
    public void setStocks(Stock... stocks){
        setStocks(Arrays.asList(stocks));
    }


    @Override
    public void getMessage(Stock stock) {
        System.out.println(stock);
    }
}
