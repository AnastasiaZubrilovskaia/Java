package ru.zubrilovskaya.cities;
public class Town extends City{
    public Town(String name){
        super(name);
    }
    public Town(String name, Way... roads){
        super(name, roads);
    }
    @Override
    public void addWay(City city, int pay){
        super.addWay(city, pay);
        for (Way w: city.getWays()){
           if (this == w.getCity()) return;
        }
        city.addWay(this, pay);
    }

}
