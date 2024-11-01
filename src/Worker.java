public class Worker {
    private String name;
    private Department department;

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
        else if (department.getBoss() == this){
            return name + " is boss of " + department.getName();
        }
        return name + " works in " + department;
    }





//    private String name;
//    private Department department;
//    public Worker (String name){
//        setName(name);
//    }
//    public void setName (String name){
//        this.name = name;
//    }
//    public String getName (){
//        return name;
//    }
//    public void setDepartment (Department department){
//        this.department = department;
//        if (department != null )department.isWorker(this);
//    }
//    public Department getDepartment(){
//        return department;
//    }
////    public  void removeWorker (Worker worker){
////        this.name = null;
////        if (department != null) removeWorker(worker);
////    }
//
//    public String toString (){
//        if (department == null){
//            return name + " has no work";
//        }
//        else if (department.getBoss() == this){
//            return name + " is boss of department " + department.getName();
//        }
//        return name + " works in " + department;
//    }
}
