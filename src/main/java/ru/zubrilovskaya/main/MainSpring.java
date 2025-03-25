package ru.zubrilovskaya.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.zubrilovskaya.spring.TrafficLight2;
import ru.zubrilovskaya.human.student.Student;
import ru.zubrilovskaya.spring.Config;
import ru.zubrilovskaya.spring.Response;
import ru.zubrilovskaya.spring.StudentBuilder;

import java.util.Date;
import java.util.function.Predicate;

public class MainSpring {
    public static void main(String[] args){

        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        String hello = (String) ctx.getBean("hello");
        System.out.println(hello);

        int random1 = (int) ctx.getBean("random");
        int random2 = (int) ctx.getBean("random");
        System.out.println(random1 + "  " + random2);

        Date date1 = (Date) ctx.getBean("date");
        System.out.println(date1);

        Predicate<Integer> predicate = (Predicate<Integer>) ctx.getBean("range");
        System.out.println(predicate.test(5));
        System.out.println(predicate.test(6));

        int max = (int) ctx.getBean("max");
        int min = (int) ctx.getBean("min");
        System.out.println(max + " and " + min);

        Response r3 = (Response) ctx.getBean("response3");
        Response r4 = (Response) ctx.getBean("response3");
        System.out.println(r3);
        System.out.println(r4);

        Response r = (Response) ctx.getBean("response");
        System.out.println(r);

        Student student1 = ctx.getBean("student1", Student.class);
        student1.addMark(5);
        System.out.println(student1);
//        student1.addMark(6);

        StudentBuilder studentBuilder = ctx.getBean("studentBuilder", StudentBuilder.class);
        Student student2 = studentBuilder.build("Ivan", 5,5,3);
        System.out.println(student2);

        TrafficLight2 trafficLight = ctx.getBean("trafficLight2", TrafficLight2.class);
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();


    }
}
