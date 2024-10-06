import java.util.ArrayList;
import java.util.List;

public class Department {
    public String name;
    public Worker boss;
    List <Worker> wokers = new ArrayList<>();

    public Department (String name){
        this.name = name;
    }
    public void isWorker (Worker worker){
        if (worker.department.name == name){
            wokers.add(worker);
        }
    }
    public String toString(){
        String res = "department " + name;
        if (boss == null){
            return res + " without boss";
        }
        return res + " boss is " + boss.name;
    }
    public String toStringWorkers(){
        String res =  name + ": ";
        int count = 0;
        for (Worker x : wokers){
            res = res + x.name;
            count++;
            if (count < wokers.size()) res = res + ",";
        }
        return  res;
    }
}
