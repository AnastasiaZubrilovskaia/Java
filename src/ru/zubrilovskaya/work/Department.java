package ru.zubrilovskaya.work;
import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    Worker boss;
    List<Worker> workers;

    public Department(String name, List<Worker> workers) {
        setName(name);
        setWorkers(workers);
    }
    public Department(String name){
        this(name, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public List<Worker> getWorkers() {
        return new ArrayList<>(workers);
    }
    public Worker getBoss(){
        return boss;
    }
    public void setBoss(Worker worker){
        if (worker == null) boss = null;
        if (boss == worker) return;
        addWorker(worker);
        boss = worker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = new ArrayList<>(workers);
    }

    public void removeWorker(Worker worker){
        if (worker == null) return;
        worker.setDepartment(null);
    }

    public void addWorker(Worker worker){
        if (worker == null) return;
        worker.setDepartment(this);
    }


    public String toString(){
        String res = "department " + name + " with workers " + workers;
        if (boss == null){
            return res + " without boss";
        }
        return res + " boss is " + boss.name;
    }

}
