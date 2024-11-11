package ru.zubrilovskaya.main;

import ru.zubrilovskaya.comparator.PointComparator;
import ru.zubrilovskaya.geometry.Point;
import ru.zubrilovskaya.human.student.IncorrectMarkException;
import ru.zubrilovskaya.human.student.RangeRule;
import ru.zubrilovskaya.human.student.Student;
import ru.zubrilovskaya.work.Department;
import ru.zubrilovskaya.work.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
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
        addMany(students, 7);
        System.out.println(students);
        Department d = new Department("it");
        Worker w = new Worker("name");
        w.setDepartment(d);
        d.addWorker(w);
    }

    public static void addMany(List<Student> studs, int x) throws IncorrectMarkException {
        for (Student s : studs) {
            try {
                Student st = new Student(s.getName(), s.getRule(), s.getMarks());
                st.addMark(x);
            } catch (IncorrectMarkException e) {
                return;
            }
        }
        for (Student st : studs) {
            st.addMark(x);
        }
    }


}









