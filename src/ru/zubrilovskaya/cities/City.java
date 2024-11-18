package ru.zubrilovskaya.cities;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City{
    private String name;
    private List <Way> ways = new ArrayList<>();

    public City(String name){
       setName(name);
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public City(String name, Way... roads){
        this(name);
        addWays(roads);
    }
    public void addWay (Way road){
        for (Way x : ways){
            if (x.getCity() == road.getCity()){
                ways.remove(x);
                break;
            }
        }
        ways.add(road);
    }
    public void addWay(City city, int pay){
        addWay(new Way(city, pay));
    }

    public void addWays (Way... roads){
        for (Way w : roads){
            if (!this.ways.contains(w))
                addWay(w);
        };
    }

    public List<Way> getWays() {
        return new ArrayList<>(ways);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;

        return city.getWays().size() == this.getWays().size() &&
                city.getWays().containsAll(this.getWays());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ways);
    }

    public void removeWay(Way road){
        if (ways.contains(road)) ways.remove(road);
    }
    public String toString(){
        String res =  name + " [";
        int count = 0;
        for (Way x : ways){
            res = res + " {" + x + "} ";
            count++;
            if (count < ways.size()) res = res + ",";
        }
        return  res + "]";
    }

}
