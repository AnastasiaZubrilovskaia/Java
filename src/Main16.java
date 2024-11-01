public class Main16 {
    public static void main(String[] args){
        //1.6.1
//        System.out.println("1.6.1:");
//        House house1 = new House(12);
//        House house2 = new House(-12);
//        //1.6.2
//        System.out.println("1.6.2:");
//        Time time1 = new Time(23);
//        System.out.println(time1);
//        //1.6.3
//        System.out.println("1.6.3:");
//        Square square = new Square(23, 55,555);
//        System.out.println(square.getSide());
//        System.out.println(square);
//        //1.6.4
//        System.out.println("1.6.4:");
//        Fraction fraction = new Fraction(-24, 60);
//        Fraction fraction1 = new Fraction(-11,45);
//        System.out.println(fraction.composition(fraction1));
        //1.6.5
        System.out.println("1.6.5:");
        Gun gun = new Gun(2,7);
        gun.reload(3);
        for (int i = 0; i < 5; i++){
            gun.shoot();
        }
        gun.shoot();
        System.out.println(gun.getBullet());
        gun.reload(5);
        gun.shoot();
        gun.shoot();
        System.out.println(gun.getBullet());
        System.out.println(gun.unload());
        System.out.println(gun.getBullet());
        gun.shoot();
        gun.shoot();
        gun.reload(4);
        System.out.println(gun.getBullet());
        //1.6.6
        System.out.println("1.6.6:");
        Point2D dot1 = new Point2D(23,45);
        Point2D dot2 = new Point2D(11,5);
        Point2D dot3 = new Point2D(111,85);
        Line line1 = new Line(dot1, dot2);
        Line line2 = new Line(dot1, dot2);
        Point2D y =line1.getEnd();
        System.out.println(dot2==y);
        System.out.println(line1.getEnd());
        line1.setEnd(dot3);
        System.out.println(line1);
//        //1.6.7
//        System.out.println("1.6.7:");
//        Name name1 = new Name("Korolev", "Ivan", "");
//        Name name2 = new Name("", "", "");
        //1.6.8
        System.out.println("1.6.8:");
        Name name3 = new Name("", "Ivan", "");
        Name name4 = new Name("Korolev", "Petr", "");
        Human person1 = new Human(name4, 345);
        Human person2 = new Human(name3, 45, person1);
        System.out.println(person2.father);
        System.out.println(person2);


//        Worker worker1= new Worker("Tom");
//        Worker worker2= new Worker("Tim");
//        Worker worker3= new Worker("boss");
//        Department department = new Department("IT");
//        department.setBoss(worker3);
//        worker1.setDepartment(department);
//        worker2.setDepartment(department);
//        System.out.println(department.getWorkers());

//        Worker worker  = new Worker("Tom");
//        Department department1 = new Department("IT");
//        Department department2 = new Department("Company");
//        Worker worker1  = new Worker("Tim");
//        Worker worker2  = new Worker("Sam");

        City A = new City("A");
        City B = new City("B");
        A.addWay(B, 500);
        A.addWay(B, 400);
    }
}
