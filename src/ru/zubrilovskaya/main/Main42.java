package ru.zubrilovskaya.main;

import ru.zubrilovskaya.cat.*;
import ru.zubrilovskaya.comparator.PointComparator;
import ru.zubrilovskaya.geometry.Point;
import ru.zubrilovskaya.human.student.RangeRule;
import ru.zubrilovskaya.human.student.Student;
import ru.zubrilovskaya.work.Department;
import ru.zubrilovskaya.work.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main42 {
    public static void main(String[] args) throws Exception {
        List<Point> pts = new ArrayList<>();
        pts.add(new Point(1, 4));
        pts.add(new Point(7, 8));
        pts.add(new Point(1, 2));
        pts.sort(new PointComparator());
        System.out.println(pts);

        List<Point> pts2 = new ArrayList<>();
        pts2.add(new Point(1, 4));
        pts2.add(new Point(7, 8));
        pts2.add(new Point(1, 2));
        Collections.sort(pts2);
        System.out.println(pts2);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Vasya", 6, 7, 3));
        students.add(new Student("Ivan", new RangeRule(2, 5), 4, 4, 5));
        students.add(new Student("Petr", new RangeRule(1, 10), 8, 9, 10));
        students.add(new Student("Sasha", new RangeRule(2, 5), 4, 4, 5));
        addMany( students,5);
        System.out.println(students);


        Cat cat1 = new Cat("Cat1");
        Counter count = new Counter(cat1);
        meow(count);
        System.out.println("count: " + count.count);

        Alertor a = new Alertor(count);
        meow(a);

        Dog dog = new Dog("Bob");
        Doger doger = new Doger(dog);
        meow(doger);

        Worker a1 = new Worker("a");
        Worker a2 = new Worker("b");
        Worker a3 = new Worker("c");
        Department dd = new Department("d");
        dd.setBoss(a3);
        dd.addWorker(a1);
        dd.addWorker(a2);
        System.out.println(dd);

    }

    public static void meow(Meowable meowable){
        meowable.meow();
        meowable.meow();
    }

    public static void addMany(List<Student> studs, int x) {
        for (Student s : studs) {
            Student st = new Student(s);
            st.addMark(x);
        }
        for (Student st : studs) {
            st.addMark(x);
        }
    }
}









