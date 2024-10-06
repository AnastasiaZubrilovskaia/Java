import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Stack stack1 = new Stack(10);
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
        Point a = new Point(13,45);
        Point b = new Point(45,60);
        Point c = new Point(11,20);
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
        Name name1 = Name.personal("Клеопатра");
//        Name name2 = new Name("Пушкин", "Александр", "Сергеевич" );
        Name name3 =  Name.surnamePersonalName("Маяковский","Владимир");
        System.out.println(name1);
//        System.out.println(name2);
        System.out.println(name3);
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
        //number 1.2.1
        System.out.println("1.2.1:");
        Point A = new Point(1,3);
        Point B = new Point(23,8);
        Point C = new Point(5,10);
        Point D = new Point(25,10);
        Line line1 = new Line(A, B);
        Line line2 = new Line(C, D);
        Line line3 = new Line (line1.begin, line2.end);
        System.out.println("1)" + line1);
        System.out.println("2)" + line2);
        System.out.println("3)" + line3);
        A.x=12;
        A.y=122;
        D.x=1;
        D.y=14;
        System.out.println("4)" + line1);
        System.out.println(line2);
        System.out.println(line3);
        Point X = new Point(100,100);
        Point Y = new Point(250,150);
        line1 = new Line (X,Y);
        System.out.println("5)" + line1);
        System.out.println(line2);
        System.out.println(line3);
        //number 1.2.2
//        System.out.println("1.2.2:");
//        PersonWithName person4 = new PersonWithName(person1, name1);
//        PersonWithName person5 = new PersonWithName(person2, name2);
//        PersonWithName person6 = new PersonWithName(person3, name3);
//        System.out.println(person4);
//        System.out.println(person5);
//        System.out.println(person6);
        //number 1.2.3
        System.out.println("1.2.3:");
//        Name name7 = new Name("Чудов", "Иван");
//        Name name8 = new Name("Чудов", "Петр" );
//        Name name9 = new Name("Борис");
//        PersonWithName person7 = new PersonWithName(person1, name7);
//        PersonWithName person8 = new PersonWithName(person2, name8);
//        PersonWithName person9 = new PersonWithName(person3, name9);
//        PersonWithParents people1 = new PersonWithParents(person8, person7);
//        PersonWithParents people2 = new PersonWithParents(person9, person8);
//        System.out.println(people1);
//        System.out.println(people2);
//        System.out.println(person7.name);
        //1.2.4
        System.out.println("1.2.4:");
        Worker worker2 = new Worker("Петров");
        Worker worker3 = new Worker("Козлов");
        Worker worker4 = new Worker("Сидоров");
        Department department1 = new Department("IT");
        worker2.department = department1;
        worker3.department = department1;
        worker4.department = department1;
        department1.boss = worker3;
        System.out.println(worker2);
        System.out.println(worker3);
        System.out.println(worker4);
        //1.3.1
        System.out.println("1.3.1:");
//        int[] marks={4, 5, 5};
//        Student student1= new Student("Petr", 4,5,6);
//        System.out.println(student1);
//        Student student2= new Student("Vasya", student1.marks);
//        System.out.println(student2);
        Student student3= new Student("Petr", 4,5,6);
        System.out.println(student3);
        //1.3.2
        System.out.println("1.3.2:");
//        BrokenLine brokenLine1 = new BrokenLine(new Point(1,5), new Point(2,8), new Point(5,3));
//        System.out.println(brokenLine1);
//        BrokenLine brokenLine2 = new BrokenLine(brokenLine1.points.get(0), new Point(2,-5), new Point(4,-8), brokenLine1.points.get(2));
//        System.out.println(brokenLine2);
//        brokenLine1.points.set(0, a);
//        System.out.println(brokenLine1);
//        System.out.println(brokenLine2);

//        System.out.println("1.3.2:");
//        Point[] point1 = {new Point(1,5), new Point(2,8), new Point(5,3)};
//        BrokenLine brokenLine1 = new BrokenLine(point1);
//        System.out.println(brokenLine1);
//        BrokenLine brokenLine2 = new BrokenLine(brokenLine1.points[0], new Point(2,-5), new Point(4,-8), brokenLine1.points[2]);
//        System.out.println(brokenLine2);
//        brokenLine1.points[0]=a;
//        System.out.println(brokenLine1);
//        System.out.println(brokenLine2);

        Point dot1 = new Point(1,5);
        Point dot2 = new Point(2,8);
        Point dot3 = new Point(5,3);
        BrokenLine brokenLine1 = new BrokenLine(dot1, dot2, dot3);
        Point dot4 = new Point(2,-5);
        Point dot5 = new Point(4,-8);
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

        city1.ways.add(road1);
        city1.ways.add(road2);
        city2.ways.add(road3);
        city2.ways.add(road4);
        city3.ways.add(road5);
        city3.ways.add(road6);
        System.out.println(city1);
        System.out.println(city2);
        System.out.println(city3);
        //1.3.4
        System.out.println("1.3.4:");
        Worker worker5 = new Worker("Петров");
        Worker worker6 = new Worker("Козлов");
        Worker worker7 = new Worker("Сидоров");
        Department department2 = new Department("IT");
        worker5.department = department2;
        worker6.department = department2;
        worker7.department = department2;
        department2.boss = worker6;
        department2.isWorker(worker5);
        department2.isWorker(worker6);
        department2.isWorker(worker7);
        System.out.println(department2.toStringWorkers());

    }

}