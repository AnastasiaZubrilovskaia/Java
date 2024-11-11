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
        if (this.department == department) return;
        if (this.department != null){
            this.department.removeWorker(this);
        }
        this.department = department;
        if (department != null){
            this.department.addWorker(this);
        }
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
        return name + " works in " + department;
    }
}
