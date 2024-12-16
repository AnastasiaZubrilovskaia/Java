package ru.zubrilovskaya.different.stock;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    String name;
    int cost;
    List<User> users = new ArrayList<>();

    public Stock(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
        message();
    }


    public String toString(){
        return  name + " " + cost;
    }

    void message(){
        if (users!=null){
            for (User us: users) us.getMessage(this);
        }
    }
}
