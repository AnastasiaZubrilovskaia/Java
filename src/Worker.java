public class Worker {
    public String name;
    public Department department;
    public Worker (String name){
        this.name = name;
    }

    public String toString (){
        if (department == null){
            return name + " has no work";
        }
        else if (department.boss == this){
            return name + " is boss of department " + department.name;
        }
        return name + " works in " + department;
    }
}
