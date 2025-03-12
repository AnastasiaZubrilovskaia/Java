package ru.zubrilovskaya.main;

import ru.zubrilovskaya.database.Connection;
import ru.zubrilovskaya.database.DataBase;
import ru.zubrilovskaya.different.converter.Converter;
import ru.zubrilovskaya.different.converter.Openning;
import ru.zubrilovskaya.different.converter.Trasformer;
import ru.zubrilovskaya.different.converter.Writer;
import ru.zubrilovskaya.different.light.TrafficLight;
import ru.zubrilovskaya.different.statement.Security;
import ru.zubrilovskaya.different.statement.Statement;
import ru.zubrilovskaya.different.watchman.Person;
import ru.zubrilovskaya.different.watchman.Pupil;
import ru.zubrilovskaya.different.watchman.Teacher;
import ru.zubrilovskaya.different.watchman.Watchman;
import ru.zubrilovskaya.geometry.BrokenLine;
import ru.zubrilovskaya.geometry.ClosedLine;
import ru.zubrilovskaya.geometry.Point;
import ru.zubrilovskaya.human.student.Student;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

public class Main73 {
    public static void main(String[] args){
        TrafficLight tf = new TrafficLight();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();

        //7.3.1
        DataBase dataBase = new DataBase(2);
        Connection connection1 = new Connection(dataBase);
        Connection connection2 = dataBase.getConnections();
        connection2.setData("123");
        connection1.setData("12,45");
        String str = dataBase.get(9, String.class);
        Point point = dataBase.get(11, Point.class);
        Integer in = dataBase.get(10, Integer.class);
        System.out.println(str);
        System.out.println(point);
        System.out.println(in);

        //7.3.4
        // откат на опреацию назад
        Student student = new Student("Vasya");
        student.addMark(List.of(4));
        student.addMark(List.of(3));
        student.addMark(List.of(6));
        System.out.println(student);
        student.addMark(List.of(5,5,7));
        student.removeMark(2);
        student.setName("Cat");
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.undo();
        System.out.println(student);
        //7.3.7
        Statement stat = new Statement("Pushkin", "Texttt");
        Statement statement = new Statement("Pushkin", "Text");
        Security security = new Security(List.of(stat));
        security.check(statement);
        System.out.println(statement.isMark());
        //7.3.12
        BrokenLine brokenLine = new BrokenLine(new Point(1,1), new Point(2,2), new Point(3,3));
        brokenLine.setCurrent(1);
        Iterator<Point> iterator1 = brokenLine.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        ClosedLine closedLine = new ClosedLine(new Point(1,1), new Point(2,2), new Point(3,3));
        closedLine.setCurrent(2);
        Iterator<Point> iterator2 = closedLine.iterator();
        for (int i = 0; i<10; i++){
            System.out.println(iterator2.next());
        }
        //7.3.10
        Openning openning = new Openning();
        Trasformer trasformer = new Trasformer((a)->a.toUpperCase());
        Writer writer = new Writer();
        Converter converter = new Converter(openning, trasformer, writer);
        converter.convert("file1.txt", "file2.txt");
        //7.3.11
        Person person1 = new Person("Name1");
        Pupil pupil = new Pupil("Alex", "");
        Teacher teacher = new Teacher("Tom", "456", "teather");
        Watchman watchman = new Watchman();
        System.out.println(watchman.checkUser(person1));
        System.out.println(watchman.checkUser(pupil));
        System.out.println(watchman.checkUser(teacher));

    }
}
