package ru.zubrilovskaya.cities;

import java.util.Objects;

public class Way {
    private City city;
    private int pay;
    public Way (City city, int pay){
        this.pay = pay;
        this.city = city;
    }
    public City getCity(){
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Way way = (Way) o;
        return pay == way.pay && city == way.city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, pay);
    }

    public int getPay(){
        return pay;
    }
    public void setPay(int pay){
        this.pay = pay;
    }
    public String toString(){
        return city.getName() + " : " + pay + " руб";
    }
}
