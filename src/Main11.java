public class Main11 {
    public static void main(String[] args) {
        Stack stack1 = new Stack(10);
//        stack1.push(12);
//        stack1.push(11);
//        System.out.println(stack1.toString());
//        System.out.println(stack1.pop());
//        Department department= new Department("VrLab");
//        System.out.println(department);
//        Worker worker = new Worker("Korolev");
//        department.boss = worker;
//        worker.department = department;
//        System.out.println(department);
//        System.out.println(worker);
        // number 1.1.1
        System.out.println("1.1.1:");
        Point2D a = new Point2D(13,45);
        Point2D b = new Point2D(45,60);
        Point2D c = new Point2D(11,20);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        // number 1.1.2
        System.out.println("1.1.2:");
        Person person1 = new Person("Клеопатра", 152);
        Person person2 = new Person("Пушкин", 167);
        Person person3 = new Person("Владимир", 189);
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        // number 1.1.3
        System.out.println("1.1.3:");
//        Name name1 = Name.personal("Клеопатра");
//        Name name2 = new Name("Пушкин", "Александр", "Сергеевич" );
//        Name name3 =  Name.surnamePersonalName("Маяковский","Владимир");
//        System.out.println(name1);
//        System.out.println(name2);
//        System.out.println(name3);
        // number 1.1.4
        System.out.println("1.1.4:");
        Time time1 = new Time (10);
        Time time2 = new Time (10000);
        Time time3 = new Time (100000);
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
        // number 1.1.5
        System.out.println("1.1.5:");
        House house1 = new House(1);
        House house2 = new House(5);
        House house3 = new House(23);
        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);
//        //number 1.2.1
//        System.out.println("1.2.1:");
//        Point A = new Point(1,3);
//        Point B = new Point(23,8);
//        Point C = new Point(5,10);
//        Point D = new Point(25,10);
//        Line line1 = new Line(A, B);
//        Line line2 = new Line(C, D);
//        Line line3 = new Line (line1.begin, line2.end);
//        System.out.println("1)" + line1);
//        System.out.println("2)" + line2);
//        System.out.println("3)" + line3);
//        A.x=12;
//        A.y=122;
//        D.x=1;
//        D.y=14;
//        System.out.println("4)" + line1);
//        System.out.println(line2);
//        System.out.println(line3);
//        Point X = new Point(100,100);
//        Point Y = new Point(250,150);
//        line1 = new Line (X,Y);
//        System.out.println("5)" + line1);
//        System.out.println(line2);
//        System.out.println(line3);
        //number 1.2.2
//        System.out.println("1.2.2:");
//        Human person4 = new Human(person1, name1);
//        Human person5 = new Human(person2, name2);
//        Human person6 = new Human(person3, name3);
//        System.out.println(person4);
//        System.out.println(person5);
//        System.out.println(person6);
        //number 1.2.3
        System.out.println("1.2.3:");
//        Name name7 = Name.withSurnamePersonalName("Чудов", "Иван");
//        Name name8 = Name.withSurnamePersonalName("Чудов", "Петр" );
//        Name name9 = Name.withPersonal("Борис");
//        Human person7 = new Human(52, name7);
//        Human person8 = new Human(55, name8, person7);
//        Human person9 = new Human(55, name9, person8);
//        System.out.println(person7);
//        System.out.println(person8);
//        System.out.println(person9);
        //1.2.4
//        System.out.println("1.2.4:");
//        Worker worker2 = new Worker("Петров");
//        Worker worker3 = new Worker("Козлов");
//        Worker worker4 = new Worker("Сидоров");
//        Department department1 = new Department("IT");
//        worker2.setDepartment(department1);
//        worker3.setDepartment(department1);
//        worker4.setDepartment(department1);
//        department1.setBoss(worker3);
//        System.out.println(worker2);
//        System.out.println(worker3);
//        System.out.println(worker4);
//        //1.3.1
        System.out.println("1.3.1:");
//        int[] marks={4, 5, 5};
//        Student student1= new Student("Petr", 4,5,6);
//        System.out.println(student1);
//        Student student2= new Student("Vasya", student1.marks);
//        System.out.println(student2);
        Student student3= new Student("Petr", 4,5,5);
        System.out.println(student3);
        //1.3.2
        System.out.println("1.3.2:");
        Point2D dot1 = new Point2D(1,5);
        Point2D dot2 = new Point2D(2,8);
        Point2D dot3 = new Point2D(5,3);
        BrokenLine brokenLine1 = new BrokenLine(dot1, dot2, dot3);
        Point2D dot4 = new Point2D(2,-5);
        Point2D dot5 = new Point2D(4,-8);
        BrokenLine brokenLine2 = new BrokenLine(dot1, dot4, dot5, dot3);
        System.out.println(brokenLine1);
        System.out.println(brokenLine2);
        dot1.x  = 22;
        dot1.y = 33;
        System.out.println(brokenLine1);
        System.out.println(brokenLine2);

        //1.3.3
        System.out.println("1.3.3:");
        City city1= new City ( "A");
        City city2= new City ( "B");
        City city3= new City ( "C");
        Way road1 = new Way (city3,1);
        Way road2 = new Way (city2,5);
        Way road3 = new Way (city1,6);
        Way road4 = new Way (city3,5);
        Way road5 = new Way (city1,3);
        Way road6 = new Way (city2,6);
        city1.addWay(road1);
        city1.addWay(road2);
        city2.addWay(road3);
        city2.addWay(road4);
        city3.addWay(road5);
        city3.addWay(road6);
        System.out.println(city1);
        System.out.println(city2);
        System.out.println(city3);
        //1.3.4
//        System.out.println("1.3.4:");
//        Worker worker5 = new Worker("Петров");
//        Worker worker6 = new Worker("Козлов");
//        Worker worker7 = new Worker("Сидоров");
//        Department department2 = new Department("IT");
//        worker5.setDepartment(department2);
//        worker6.setDepartment(department2);
//        worker7.setDepartment(department2);
//        department2.setBoss(worker6);
//        department2.isWorker(worker5);
//        department2.isWorker(worker6);
//        department2.isWorker(worker7);
//        System.out.println(department2.getWorkers());
    }
}