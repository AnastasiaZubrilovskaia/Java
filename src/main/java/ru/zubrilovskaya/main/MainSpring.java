package ru.zubrilovskaya.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.zubrilovskaya.different.stock.Stock;
import ru.zubrilovskaya.spring.*;
import ru.zubrilovskaya.human.student.Student;

import java.util.Date;
import java.util.function.Predicate;

public class MainSpring {
    public static void main(String[] args){

        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        //9.1.1
        String hello = (String) ctx.getBean("hello");
        System.out.println(hello);
        //9.1.2
        int random1 = (int) ctx.getBean("random");
        int random2 = (int) ctx.getBean("random");
        System.out.println(random1 + "  " + random2);
        //9.1.3
        Date date1 = (Date) ctx.getBean("date");
        System.out.println(date1);
        //9.1.4
        Predicate<Integer> predicate = (Predicate<Integer>) ctx.getBean("range");
        System.out.println(predicate.test(5));
        System.out.println(predicate.test(6));
        //9.1.5
        int max = (int) ctx.getBean("max");
        int min = (int) ctx.getBean("min");
        System.out.println(max + " and " + min);
        //9.2.2
        Response r3 = (Response) ctx.getBean("response3");
        Response r4 = (Response) ctx.getBean("response3");
        System.out.println(r3);
        System.out.println(r4);
        //9.2.3
        Response r = (Response) ctx.getBean("response");
        System.out.println(r);
        //9.2.4
        Student student1 = ctx.getBean("student1", Student.class);
        student1.addMark(5);
        System.out.println(student1);
//        student1.addMark(6);
        //9.2.5
        StudentBuilder studentBuilder = ctx.getBean("studentBuilder", StudentBuilder.class);
        Student student2 = studentBuilder.build("Ivan", 5,5,3);
        System.out.println(student2);
        //9.2.7
        TrafficLight2 trafficLight = ctx.getBean("trafficLight2", TrafficLight2.class);
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();

        //9.2.8
        Subscriber subscriber1 = ctx.getBean("subscriber", Subscriber.class);
        Stock stock1 = new Stock("Stock1", 500);
        subscriber1.setStock(stock1);
        stock1.setCost(700);


    }
}
