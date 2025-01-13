package ru.zubrilovskaya.different.stock;

import java.util.ArrayList;
import java.util.List;

//задание решается с использованием паттерна "Наблюдатель"

public class Stock {
    final String name;
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

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
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
