package ru.zubrilovskaya.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.zubrilovskaya.different.stock.Stock;
import ru.zubrilovskaya.different.stock.User;

@Component
@Scope("prototype")
public class Subscriber implements User {
    Stock stock;

    public Subscriber() {

    }

    public void setStock(Stock stock){
        this.stock = stock;
        stock.setUsers(this);
    }

    public Stock getStock() {
        return stock;
    }

    @Override
    public void getMessage(Stock stock) {
        System.out.println("Changes: "+ stock);
    }

}
