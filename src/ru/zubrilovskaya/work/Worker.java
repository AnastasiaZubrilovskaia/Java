package ru.zubrilovskaya.work;
public class Worker {
    String name;
    Department department;

    public Worker(String name, Department department) {
        setName(name);
        setDepartment(department);
    }

    public Worker(String name){
        this(name, null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        if (department == this.department) return;
        if (this.department != null) {
            if (this.department.boss == this) this.department.boss = null;
            this.department.workers.remove(this);
        }
        this.department = department;
        if (department != null) department.workers.add(this);
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public String toString() {
        if (department == null){
            return name + " has no work :(";
        }
        else if (department.boss == this){
            return name + " is boss of " + department.name;
        }
        return name + " works in " + department.name;
    }
}
