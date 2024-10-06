import java.util.ArrayList;
import java.util.List;

public class City {
    public String name;
    List <Way> ways = new ArrayList<>();

    public City(String name){
        this.name = name;
    }
    public void add (Way road){
        ways.add(road);
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
