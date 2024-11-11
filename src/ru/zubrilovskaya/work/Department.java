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
        setName(name);
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
        if (!workers.contains(worker)) throw new IllegalArgumentException("Person isn't worker of Detachment");
        this.boss = worker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = new ArrayList<>(workers);
    }

    public void removeWorker(Worker worker){
        if (worker == null) return;
        if (!workers.contains(worker)) return;
        if (boss == worker) boss = null;
        worker.setDepartment(null);
        workers.remove(worker);

    }
    public void addWorker(Worker worker){
        if (worker == null) return;
        if (workers.contains(worker) && worker.department == this) return;
        if (worker.department != this) {
            worker.setDepartment(this);
        }
        if (!workers.contains(worker)) {
            workers.add(worker);
        }
    }


    public String toString(){
        String res = "department " + name + " with workers " + workers;
        if (boss == null){
            return res + " without boss";
        }
        return res + " boss is " + boss.name;
    }

}
